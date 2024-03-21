package previous.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/31 16:27
 * @Description: 按顺序打印，有3个方法，三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 */
public class PriteByNum {

    //使用两个同步工具类，保证A在B之前，B在C之前
    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    /***
     * 初始化两个同步工具
     */
    public PriteByNum() {
        countDownLatch1 = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(2);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // 方法执行完，countDownLatch1 - 1
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // 阻塞等待A方法执行完
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        // B方法执行完，countDownLatch2 - 1
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}
