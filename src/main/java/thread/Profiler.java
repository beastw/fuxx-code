package thread;

/**
 * Created by liuwei on 2020/2/20
 */
public class Profiler {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal
        .withInitial(() -> System.currentTimeMillis());

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();

        new Thread(() -> {
            Profiler.begin();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + ": " + Profiler.end());

    }

}
