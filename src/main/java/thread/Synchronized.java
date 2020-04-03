package thread;

/**
 * Created by liuwei on 2020/2/20
 */
public class Synchronized {

    public static void main(String[] args) {
        synchronized (Synchronized.class) {

        }
        f();
    }

    public static synchronized void f() {}
}
