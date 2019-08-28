### 一个简单的数据库连接池实例
   我们使用等待超时模式来构造一个简单的数据库连接池，在示例中模拟从连接池中获取，使用和释放连接
   的过程，而客户端获取连接的过程被设定为等待超时的模式，也就是在1000毫秒内如果无法获取
   到可用连接，将会返回给客户端一个null。设定连接池的大小为10个，然后通过调节客户端的线程数来模拟无法获取连接的场景。
主要代码
```$java
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
``` 