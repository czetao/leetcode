package previous.thread.notify;

/**
 * 2023/4/9
 * czetao
 * Description TODO
 **/
public class Cook extends Thread{

    @Override
    public void run() {

        while (true){
            synchronized (Desk.lock){
                if (Desk.count == 0 ){
                    break;
                }
                if (Desk.foodFlag == 1){
                    // 做好饭了，
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    Desk.foodFlag = 1;
                    Desk.count -- ;
                    System.out.println("做好饭了，剩下"+Desk.count+"份");
                    Desk.lock.notifyAll();
                }

            }
        }
    }
}
