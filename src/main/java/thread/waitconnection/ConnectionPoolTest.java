package thread.waitconnection;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/28 19:55
 * @Description: 模拟客户端ConnectionRunner获取，使用，最后释放连接的过程。 当它使用时，连接将会增加获取到连接的数量，反之，将会增加未获取到连接的数量
 */
public class ConnectionPoolTest {
    //初始化连接池
    static ConnectionPool pool = new ConnectionPool(10);

    //保证所有ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    //main线程将会等待所有ConnectionRunner 结束后才能继续执行
    static CountDownLatch end ;

    public static void main(String[] args) throws Exception{
        //线程数量，可以修改线程数量进行观察
        int threadCound = 20;
        end = new CountDownLatch(threadCound);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0 ; i<threadCound;i++){
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke:" + (threadCound* count));
        System.out.println("got connection:" + got);
        System.out.println("not got connection "+ notGot);
    }

    static class ConnectionRunner implements Runnable{
        int count ;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        @Override
        public void run(){
            try{
                start.await();
            }catch (Exception ex){

            }
            while (count >0){
                try{
                    //从线程池中获取连接，如果1000ms内无法获取到，将会返回null
                    //分别统计连接获取的数量got和未获取的数量notgot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }
                }catch (Exception ex){

                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

}
