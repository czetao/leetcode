package previous.thread;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/31 20:23
 * @Description: 假设有这么一个类：
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 *   public void zero(printNumber) { ... }  // 仅打印出 0
 *   public void even(printNumber) { ... }  // 仅打印出 偶数
 *   public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出："0102030405"
 */
public class ZeroOddEven {
    private int n;

    private CountDownLatch countDownLatchA = new CountDownLatch(0); // zero 为0 ，因为最开始打印不能让它等待
    private CountDownLatch countDownLatchB = new CountDownLatch(1); // 控制打印奇数的顺序
    private CountDownLatch countDownLatchC = new CountDownLatch(1); // 控制打印偶数的顺序


    public ZeroOddEven(int n) {
        this.n = n;
    }

    //多线程打印
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0 ; i < n;i++){
            countDownLatchA.await();
           // printNumber.accept(0);
            System.out.println(i);
            countDownLatchA = new CountDownLatch(1);

            if (i % 2 == 0){
                countDownLatchB.countDown(); //i是偶数，下一个应该是奇数。激活打印奇数的方法
            }else {
                countDownLatchC.countDown(); //打印偶数
            }
        }
    }

    /**
     * 打印偶数
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2;i<=n;i= i+2){
            countDownLatchC.await();
            //printNumber.accept(i);
            System.out.println(i);
            countDownLatchC = new CountDownLatch(1);
            countDownLatchA.countDown();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i =1; i<= n ;i = i+2){
            countDownLatchB.await();
            System.out.println(i);
            countDownLatchB = new CountDownLatch(1);
            countDownLatchA.countDown();
        }
    }

    
}
