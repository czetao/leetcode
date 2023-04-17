package thread.celltitck;

/**
 * 2023/4/9
 * czetao
 * Description TODO
 **/
public class TestRunable {

    public static void main(String[] args) {
        CellTitckRunable cellTitckRunable = new CellTitckRunable();

        Thread thread = new Thread(cellTitckRunable);
        Thread thread2 = new Thread(cellTitckRunable);
        Thread thread3 = new Thread(cellTitckRunable);

        thread.setName("1");
        thread2.setName("2");
        thread3.setName("3");

        thread.start();
        thread2.start();
        thread3.start();
    }
}
