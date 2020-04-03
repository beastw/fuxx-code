package thread.threadlocal;

/**
 * Created by liuwei on 2020/3/5
 */
public class TestThreadLocal {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static final ThreadLocal<String> threadLocal02 = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                threadLocal.set(Thread.currentThread().getName());
                threadLocal02.set(Thread.currentThread().getName() + "02");
            }).start();
        }
    }

}
