package thread.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS实现的简单锁
 * Created by liuwei on 2020/2/24
 */
public class FirstLock {

    private volatile AtomicInteger status = new AtomicInteger(0);

    public void lock() {

        while(!status.compareAndSet(0, 1)) {

        }
    }

    public void unlock() {
        status.set(0);
    }

    public static void main(String[] args) {

        FirstLock firstLock = new FirstLock();

        Thread thread1 = new Thread(() -> {
            firstLock.lock();
            System.out.println("thread1 acquire lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            firstLock.unlock();
        });
        Thread thread2 = new Thread(() -> {
            firstLock.lock();
            System.out.println("thread2 acquire lock");
            firstLock.unlock();
        });

        thread1.start();
        thread2.start();
    }

}
