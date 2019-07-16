package Thread;

import java.util.Vector;

/**
 * 对Vetor线程安全的测试
 * 虽然vector里面的方法都是synchronzied，方法的都是线程安全，但是在多线程的环境下，如果不在方法端做线程同步的话，还是会出现线程不安全
 * 因此需要对调用方法，加锁
 */
public class Demo1 {

    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while(true){
            for (int i =0;i<10;i++){
                vector.add(i);
            }

           /* Thread removedThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0;i<vector.size();i++){
                        vector.remove(i);
                    }
                }
            });*/
            Thread removedThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });


            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });

            removedThread.start();
            printThread.start();

            while(Thread.activeCount()>20);
        }
    }
}

