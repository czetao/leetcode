package Thread.waitConnection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/28 17:34
 * @Description: 连接池通过构造函数初始化连接的最大上限，通过一个双向队列来维护连接。
 * 调用方需要先通过fetchConnection（long）方法来指定在多少毫秒内超时
 * 获取连接。 当连接使用完成后，需要调用releaseConnection(Connection)方法将连接放回线程池。
 */
public class ConnectionPool {

    //通过一个双向队列来维护连接
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize){
        if (initialSize > 0) {
            for (int i =0 ;i<initialSize;i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null){
            synchronized (pool){
                 // 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    //在mills时间内无法获取到连接，将会返回null
    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized(pool){
            //完全超时
            if (mills <=0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                //超时时间 ： 当前时间 + mills
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                // 当超时大于0，并且result返回值不满足要求。 如果remaining <=0 ,表示已经超时。跳出循环
                while (pool.isEmpty() && remaining >0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return  result;
            }
        }
    }
}
