package thread;

import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by liuwei on 2020/2/22
 */
public class CyclicBarrierTest implements Runnable {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                countMap.put(Thread.currentThread().getName(), 1);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    @Override
    public void run() {
        int result = 0;
        for (Entry<String, Integer> sheet : countMap.entrySet()) {
            result += sheet.getValue();
        }
        countMap.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        cyclicBarrierTest.count();
    }
}
