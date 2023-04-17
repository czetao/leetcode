package thread.celltitck;

/**
 * 2023/4/9
 * czetao
 * Description TODO
 **/
public class test {
    public static void main(String[] args) {
        CellTitck t1 = new CellTitck();
        CellTitck t2 = new CellTitck();
        CellTitck t3 = new CellTitck();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}
