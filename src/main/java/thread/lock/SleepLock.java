package thread.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuwei on 2020/2/24
 */
public class SleepLock {

    private volatile AtomicInteger status = new AtomicInteger(0);

    public void lock() {

        while(!status.compareAndSet(0, 1)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void unlock() {
        status.set(0);
    }

    public static void main(String[] args) {
        SleepLockTest sleepLockTest = new SleepLockTest();
        for (int i = 0; i < 10 ;i++) {
            new Thread(() -> {
                sleepLockTest.get();
            }).start();
        }

    }

    static class SleepLockTest {
        private SleepLock lock = new SleepLock();

        private int count = 100;

        public void get() {
            lock.lock();
            System.out.println("count is:" + ++count);
            lock.unlock();
        }
    }
}
