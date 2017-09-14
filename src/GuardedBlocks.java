import java.util.concurrent.*;

public class GuardedBlocks {
    private static final String DONE = "Finished delivering messages";

    private static class Producer implements Runnable {
        private BlockingQueue<String> store;

        public Producer(BlockingQueue<String> store) {
            this.store = store;
        }

        @Override
        public void run() {
            String[] importantMessages = {"I ", "love ", "you!"};
            try {
                for (String m : importantMessages) {
                    store.put(m);
                    Thread.sleep(300);
                }
                store.put(DONE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable {
        private BlockingQueue<String> store;

        public Consumer(BlockingQueue<String> store) {
            this.store = store;
        }

        @Override
        public void run() {
            try {
                for (String message = store.take(); !DONE.equals(message); message = store.take()) {
                    System.out.print(message);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new SynchronousQueue<>());

        BlockingQueue<String> store = new SynchronousQueue<>();
        executorService.submit(new Producer(store));
        executorService.submit(new Consumer(store));

        executorService.shutdown();
    }
}
