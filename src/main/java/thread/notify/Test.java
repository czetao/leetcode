package thread.notify;

/**
 * 2023/4/9
 * czetao
 * Description 厨师做菜，顾客吃饭。等着唤醒
 **/
public class Test {
    public static void main(String[] args) {
        Cook cook = new Cook();
        Foodie foodie = new Foodie();

        cook.setName("厨师");
        foodie.setName("顾客");

        cook.start();
        foodie.start();

    }
}
