package thread;

/**
 * Created by liuwei on 2020/2/22
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("parser1 finish");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("parser2 finish");
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("all finish");
    }

}
