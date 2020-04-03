package thread;

import java.sql.Connection;

/**
 * Created by liuwei on 2020/2/21
 */
public class ConnectionPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ConnectionPool connectionPool = new ConnectionPool(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    connectionPool.fetchConnection(1000);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        Connection connection = connectionPool.fetchConnection(100);
        if (connection == null) {
            System.out.println("connection is null");
        }
    }

}
