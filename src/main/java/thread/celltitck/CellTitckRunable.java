package thread.celltitck;

/**
 * 2023/4/9
 * czetao
 * Description runable 实现版本
 **/
public class CellTitckRunable implements Runnable {

    int titck = 0;

    @Override
    public void run() {
        while (true) {
            if (sell()) break;
        }
    }

    private synchronized boolean sell() {
        if (titck == 100) {
            return true;
        } else {
            titck++;
            System.out.println("当前窗口名称：" + Thread.currentThread().getName() + "还剩" + titck + "张票！");
        }
        return false;
    }

}
