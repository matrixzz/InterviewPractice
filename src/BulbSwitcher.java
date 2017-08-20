/**
 * Created by zhangzhu on 7/15/17.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (findOnOrOff(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean findOnOrOff(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count % 2 == 0 ? true : false;
    }

    public static final void main(String[] args) {
        BulbSwitcher solution = new BulbSwitcher();
        for(int n = 1; n <= 999; n++)
            System.out.println("n = " + n + "; count = " + solution.bulbSwitch(n));

        // return (int) Math.sqrt(n);
    }
}
