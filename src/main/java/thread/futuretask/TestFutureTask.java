package thread.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by liuwei on 2020/3/6
 */
public class TestFutureTask {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("子线程正在进行计算");
            Thread.sleep(3000);
            return "futureTask";
        });
        executorService.submit(futureTask);
        executorService.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程正在执行任务");

        try {
            System.out.println("futuretask运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程正在执行任务完毕");
    }

}


