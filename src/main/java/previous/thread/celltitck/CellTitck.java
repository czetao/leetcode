package previous.thread.celltitck;

/**
 * 2023/4/9
 * czetao
 * Description 100张票，模拟电影院卖票，3个窗口在卖
 **/
public class CellTitck extends Thread {

    // 会创建多个对象，共享变量应该为类对象 static
    static int titck = 0;

    @Override
    public void run() {
        while (true){
            synchronized (CellTitck.class){
                if (titck == 100){
                    break;
                }else {
                    titck ++ ;
                    System.out.println("当前窗口名称："+Thread.currentThread().getName()+"还剩"+titck+"张票！");
                }
            }
        }
    }
}
