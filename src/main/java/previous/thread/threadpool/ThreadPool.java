package previous.thread.threadpool;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/28 21:04
 * @Description: 简单的线程池定义接口
 */
public interface ThreadPool<Job extends Runnable>{
    //执行一个job,这个job需要实现runnable
    void execute(Job job);

    //关闭线程池
    void shutdown();

    //增加工作者线程
    void addWorkers(int num);
    //减少工作者线程
    void removeWorker(int num);

    //得到正在等待执行的任务数量
    int getJobSize();
}
