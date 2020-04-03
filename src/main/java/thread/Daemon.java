package thread;

/**
 * Created by liuwei on 2020/2/20
 */
public class Daemon {

    public static void main(String[] args) {
        Thread daemonRunner = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "DaemonRunner");
        daemonRunner.setDaemon(true);
        daemonRunner.start();
    }

}
