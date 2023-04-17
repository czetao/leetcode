package thread.notify;

/**
 * 2023/4/9
 * czetao
 * Description TODO
 **/
public class Desk {

    // 0 饭没做好，1 饭已经做好
    static int foodFlag = 0;
    // 吃10次
    static int count = 10;
    // 公共资源
    static Object lock = new Object();
}
