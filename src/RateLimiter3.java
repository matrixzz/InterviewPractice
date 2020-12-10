import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RateLimiter3 {

    class Counter {
        long[] queue;
        int idx;

        Counter(int capacity) {
            this.queue = new long[capacity];
            this.idx = 0;
        }
    }

    private static final int TIME_UNIT = 1000;

    Map<Long, Counter> clientRequestCountMap;
    int capacity;

    public RateLimiter3(int capacity) {
        this.clientRequestCountMap = new HashMap<>();
        this.capacity = capacity;
    }

    public boolean isAllowed(long clientId, long timeStamp) {
        if(clientRequestCountMap.containsKey(clientId)) {
            Counter counter = clientRequestCountMap.get(clientId);
            long prevTime = counter.queue[counter.idx];
            if (timeStamp - prevTime < TIME_UNIT) {
                return false;
            }
            updateCounter(counter, timeStamp);

            return true;
        } else {
            Counter counter = new Counter(this.capacity);
            updateCounter(counter, timeStamp);
            clientRequestCountMap.put(clientId, counter);

            return true;
        }
    }

    private void updateCounter(Counter counter, long timeStamp) {
        counter.queue[counter.idx++] = timeStamp;
        counter.idx %= counter.queue.length;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter3 rl = new RateLimiter3(2);
        Thread.sleep(1000L);
        for (int i = 0; i < 6; i++) {
            long timestamp = System.currentTimeMillis();
            System.out.println(new SimpleDateFormat("HH/mm/ss.SSS").format(new Date(timestamp)));
            System.out.println(rl.isAllowed(1000, timestamp));
            Thread.sleep(250L);
        }
        for (int i = 0; i < 6; i++) {
            long timestamp = System.currentTimeMillis();
            System.out.println(rl.isAllowed(1000, timestamp));
            Thread.sleep(100L);
        }
    }
}
