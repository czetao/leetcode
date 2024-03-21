package previous.thread.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/28 21:48
 * @Description: 自定义线程池  本质是通过一个工作队列，对客户端线程 和工作者线程进行连接
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool {

    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //线程池最小的数量
    private static final int MIN_WORKER_NUMBERS =1;
    //这是一个工作列表，将会向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    //工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程的数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();


    //初始化线程池,默认线程大小是5
    public DefaultThreadPool(){
        initializeWokers(DEFAULT_WORKER_NUMBERS);
    }
    //带参数的线程池初始化，对长度进行判断，要小于最大，大于最小
    public DefaultThreadPool(int nums ){
        workerNum = nums > MAX_WORKER_NUMBERS? MAX_WORKER_NUMBERS :nums<MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS :nums;
        initializeWokers(workerNum);
    }
    //初始化线程工作者
    private void initializeWokers(int nums) {
        for (int i = 0 ;i<nums;i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"threadpool-Worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Runnable job) {

        if (job != null){
            //添加一个工作，然后进行通知
            synchronized (jobs){
                jobs.addLast((Job) job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            //限制新增的worker数量不能超过最大值
            if (num+this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWokers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if (num > this.workerNum){
                throw new IllegalArgumentException("beyond worknum");
            }
            //按照给定的数量停止worker
            int count = 0;
            while (count < num){
                Worker worker = workers.get(count);
                if (workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            //重新计算工作者的数量
            this.workerNum -=count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    //工作者，负责消费任务
    class Worker implements  Runnable {

        //是否工作
        private volatile boolean running = true;
        @Override
        public void run(){
            //通过running 决定工作者是否工作
            while (running){
                Job job = null;
                synchronized (jobs){
                    //如果工作者列表是空的，就wait
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        }catch (InterruptedException ex){
                            //感知到外部对workerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    //取出一个job
                    job = jobs.removeFirst();
                }
                if (job != null){
                    try {
                        job.run();
                    }catch (Exception ex){
                        //忽略job执行中的Exception
                    }
                }
            }
        }
        //关闭工作者
        public void shutdown(){
            running = false;
        }

    }
}
