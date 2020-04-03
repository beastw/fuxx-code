package thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liuwei on 2020/3/3
 */
public class TestReadWriteLock {

    private Map<String, String> map = new HashMap<>();

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock r = readWriteLock.readLock();

    private Lock w = readWriteLock.writeLock();

    public String get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public void set(String key, String value) {
        w.lock();
        try {
            map.put(key, value);
        } finally {
            w.unlock();
        }
    }
}
