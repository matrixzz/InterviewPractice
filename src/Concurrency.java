import java.util.Random;
import java.util.concurrent.*;

public class Concurrency implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        Integer i = new Random().nextInt(100);
        return i;
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 61000,
                TimeUnit.MICROSECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 10; i++) {
            Callable<Integer> callable = new Concurrency();

            try {
                Future<Integer> futureResultQueue = executorService.submit(callable);
                System.out.println(futureResultQueue.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
