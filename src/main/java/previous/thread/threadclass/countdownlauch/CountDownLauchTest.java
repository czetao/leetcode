package previous.thread.threadclass.countdownlauch;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/31 11:56
 * @Description: 使用CountDownLatch 实现线程之间的同步例子
 */
public class CountDownLauchTest {

    /***
     * 构造函数接收一个int类型的参数作为计数器，如果想等待N个点完成，这里就传入N
     */
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        //主线程等待子线程执行完成。即计数器如果为0，才往下走
        c.await();
        System.out.println(3);
    }
}
