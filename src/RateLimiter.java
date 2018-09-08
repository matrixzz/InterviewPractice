import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class RateLimiter {
//    private final int capacity;
//    private final int tokensPerSecond;
//    private int tokens = 0;
//    private long timestamp = System.currentTimeMillis();
//
//    public RateLimiter(int tokenPerUnit, TimeUnit unit) {
//        this.capacity = this.tokensPerSecond = (int) (tokenPerUnit / unit.toSeconds(1L));
//    }
//
//    public boolean isAllowed() {
//        long now = System.currentTimeMillis();
//        tokens += (int) (now - timestamp) * tokensPerSecond / 1000;
//        if (tokens > capacity) tokens = capacity;
//        if (tokens < 1) return false;
//        tokens--;
//        return true;
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        RateLimiter rl = new RateLimiter(60, TimeUnit.MINUTES);
//        Thread.sleep(1000L);
//        for (int i = 0; i < 5; i++) {
//            System.out.println(rl.isAllowed());
//        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println(rl.isAllowed());
//        }
//    }
    private Map<Long, Queue<Long>> map = new HashMap<>();
    private int maxRate;
    private long timeInterval;

    public RateLimiter(int maxRate, long timeInterval) {
        this.maxRate = maxRate;
        this.timeInterval = timeInterval;
    }

    public boolean take(long clientId) {
        long current = System.currentTimeMillis();
        if (map.containsKey(clientId)) {
            Queue<Long> q = map.get(clientId);
            if (q.size() >= maxRate) {
                long prev = q.poll();
                q.offer(current);
                if (current - prev < timeInterval) {
                    return false;
                }
            } else {
                q.offer(current);
            }
        } else {
            Queue<Long> q = new LinkedList<>();
            q.offer(current);
            map.put(clientId, q);
        }

        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rl = new RateLimiter(5, TimeUnit.SECONDS.toSeconds(1L));
        for (int i = 0; i < 10; i++) {
            System.out.println(rl.take(1));
        }
        Thread.sleep(1000L);
        System.out.println("=====================");
        for (int i = 0; i < 10; i++) {
            System.out.println(rl.take(1));
        }
    }
}
