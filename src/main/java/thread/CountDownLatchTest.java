package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liuwei on 2020/2/22
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        System.out.println(3);
           }
}
