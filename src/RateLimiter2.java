import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RateLimiter2 {
    private final int capacity;
    private final int tokensPerSecond;
    private int tokens = 0;
    private long timestamp = System.currentTimeMillis();

    public RateLimiter2(int tokenPerUnit, TimeUnit unit) {
        this.capacity = this.tokensPerSecond = (int) (tokenPerUnit / unit.toSeconds(1L));
    }

    public boolean isAllowed(long timestamp) {
        tokens += (int) ((timestamp - this.timestamp) * tokensPerSecond / 1000);
        if (tokens > capacity) tokens = capacity;
        if (tokens < 1) return false;
        tokens--;
        this.timestamp = timestamp;
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter2 rl = new RateLimiter2(2, TimeUnit.SECONDS);
        Thread.sleep(1000L);
        for (int i = 0; i < 6; i++) {
            long timestamp = System.currentTimeMillis();
            System.out.println(new SimpleDateFormat("HH/mm/ss.SSS").format(new Date(timestamp)));
            System.out.println(rl.isAllowed(timestamp));
            Thread.sleep(250L);
        }
        for (int i = 0; i < 6; i++) {
            long timestamp = System.currentTimeMillis();
            System.out.println(rl.isAllowed(timestamp));
        }
    }
}