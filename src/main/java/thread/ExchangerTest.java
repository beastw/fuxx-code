package thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuwei on 2020/2/22
 */
public class ExchangerTest {

    private static Exchanger<String> exchanger = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            String a = "this is a ";
            try {
                String b = exchanger.exchange(a);
                System.out.println("b info is: " + b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            String b = "this is b";
            try {
                String a = exchanger.exchange(b);
                System.out.println("a info is: " + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdown();
    }

}
