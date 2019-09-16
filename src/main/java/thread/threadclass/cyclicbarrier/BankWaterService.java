package thread.threadclass.cyclicbarrier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/31 11:14
 * @Description: CyclicBarrier的应用场景。可以用于多线程计算数据，最后合并计算结果的场景。用一个Excel保存了用户所有银行流水，每个sheet保存一个账户近一年的每笔银行流水。
 * 先用多线程处理每个sheet里的银行的银行流水，都执行完后，得到每个sheet的日均银行流水，最后，再用barrierAction用这些线程的计算结构，计算出整个excel的日均银行流水
 */
public class BankWaterService implements Runnable {

    /***
     * 创建4个屏障，处理完之后执行当前类的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4,this);

    /**
     * 创建有4个线程的线程池
     * 根据阿里巴巴java开发手册，使用Executors创建线程池会导致内存溢出，并不建议使用
     * private static ExecutorService executor = new ThreadPoolExecutor(10, 10,
     *         60L, TimeUnit.SECONDS,
     *         new ArrayBlockingQueue(10));
     *  通过ThreadPoolExecutor创建
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银流结果
     */
    private ConcurrentHashMap<String ,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){
        for (int i = 0;i<4;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //计算当前sheet的数据，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    //数据计算结束，插入一个屏障
                    try {
                        c.await();
                    }catch (Exception e){

                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
        //汇总每个sheet计算出的结果
        for (Map.Entry<String,Integer> sheet : sheetBankWaterCount.entrySet()){
            //取出每一个键值对的值
            result += sheet.getValue();
        }

        //将结果输出
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
