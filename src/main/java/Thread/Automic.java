package Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic变量自增运算测试
 */
public class Automic {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increace(){
        race.incrementAndGet();
        //race++
    }
    private static final int count  = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[count];
        for(int i =0;i<count;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                        for (int i = 0;i<10000;i++){
                            increace();
                        }
                }
            });

        threads[i].start();
        }

        while (Thread.activeCount()>1) {
            Thread.yield();

            System.out.println(race);
        }

    }
}
