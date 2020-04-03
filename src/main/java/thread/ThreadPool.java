package thread;

/**
 * Created by liuwei on 2020/2/22
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorker(int num);

    void removeWorker(int num);

    int getJobSize();


}
