package thread.threadclass.countdownlauch;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/31 11:51
 * @Description: 使用join实现，线程之间的等待同步。主线程等待线程1和线程2都完成了，再进行汇报。
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        });

        thread1.start();
        thread2.start();
        //主线程main， 等待线程1,2完成并返回。 join方法：例如thread1.join()，即主线程，等待thread1结束，结束则返回，没结束会一直循环。
        thread1.join();
        thread2.join();
    }

}
