package thread;

/**
 * Created by liuwei on 2020/2/21
 */
public class WaitTimeout {

    public static void main(String[] args) {
        try {
            new WaitTimeout().test(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void test(long waitTime) throws InterruptedException {

    }

    public String getResult() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "wait 3s";
    }

}
