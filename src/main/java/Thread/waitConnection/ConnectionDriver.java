package Thread.waitConnection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/28 17:50
 * @Description: 只是示例，自己实现数据库驱动。该connection的代理实现仅仅是在commit()方法调用时休眠100毫秒。
 */
public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
            if (method.getName().equals("commit")){
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    // 创建一个Connection的代理，在commit时休眠100毫秒
    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class<?>[]{ Connection.class},new ConnectionHandler());
    }
}
