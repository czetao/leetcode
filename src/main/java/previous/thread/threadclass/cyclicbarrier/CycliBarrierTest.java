package previous.thread.threadclass.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/31 10:52
 * @Description: 同步屏障测试CycliBarrier 当主线程和子线程都到达内存屏障的时候，线程才不会被阻塞，接着往下走
 */
public class CycliBarrierTest {

    //构造方法，参数表示屏障拦截的线程数量
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //到达内存屏障，阻塞
                    c.await();
                }catch (Exception e){

                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        }catch (Exception e){

        }
        System.out.println(2);


    }

}
