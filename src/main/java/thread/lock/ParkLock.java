package thread.lock;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import thread.lock.SleepLock.SleepLockTest;

/**
 * 运用LockSupport来创建一个锁
 * Created by liuwei on 2020/2/24
 */
public class ParkLock {

    private LinkedList<Thread> queue = new LinkedList<>();

    private AtomicInteger status = new AtomicInteger(0);

    public void lock() {
        while (!status.compareAndSet(0, 1)) {
            queue.offer(Thread.currentThread());
            LockSupport.park();
        }
    }

    //释放锁的时候让队列开始抢占锁
    public void unlock() {
        status.set(0);
        LockSupport.unpark(queue.poll());
    }

    static class ParkLockTest {
        private ParkLock lock = new ParkLock();

        private int count = 100;

        public void get() {
            lock.lock();
            System.out.println("count is:" + ++count);
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ParkLockTest lockTest = new ParkLockTest();
        for (int i = 0; i < 10 ;i++) {
            new Thread(() -> {
                lockTest.get();
            }).start();
        }

    }
}
