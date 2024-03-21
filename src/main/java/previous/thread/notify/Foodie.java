package previous.thread.notify;

/**
 * 2023/4/9
 * czetao
 * Description TODO
 **/
public class Foodie extends Thread {


    @Override
    public void run() {

        while (true){
            synchronized (Desk.lock){
                if (Desk.count == 0){
                    break;
                }
                if (Desk.foodFlag ==0){
                    try {
                        Desk.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    // 吃完饭了
                    Desk.foodFlag =0;
                    System.out.println("吃完饭了，叫厨师");
                    Desk.lock.notifyAll();
                }
            }
        }

    }
}
