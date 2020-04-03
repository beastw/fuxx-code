package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by liuwei on 2020/2/22
 */
public class SemaphoreTest {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(30);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("save data");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPool.shutdownNow();

    }

}
