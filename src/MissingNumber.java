import java.util.Arrays;

public class MissingNumber {
    int ans = -1;
    boolean stopSign = false;

    public int findMissing(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n; i++, j++) {
            if (nums[i] != j) {
                return j;
            }
        }
        return n;
    }

    public int findMissing2(int n, String str) {
        int i = 0;
        boolean[] showed = new boolean[n + 1];
        char[] c = str.toCharArray();
        dfs(i, c, showed, n);

        return ans;
    }

    private void dfs(int i, char[] c, boolean[] showed, int n) {
        if (i >= c.length) {
            stopSign = true;
            for (int j = 1; j < showed.length; j++) {
                if (!showed[j]) {
                    ans = j;
                    break;
                }
            }
            return;
        }
        int num = c[i] - '0';
        while (num > 0 && num <= n) {
            if (!showed[num]) {
                showed[num] = true;
                dfs(i + 1, c, showed, n);
                if(stopSign) break;
                showed[num] = false;
            }
            if (++i >= c.length) return;
            num = num * 10 + c[i] - '0';
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
                0, 1, 2, 5, 6, 4
        };
        MissingNumber problem = new MissingNumber();
        System.out.println(problem.findMissing(nums));
        System.out.println(problem.findMissing2(11, "111098765432"));
    }
}
