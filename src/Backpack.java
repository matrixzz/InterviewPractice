public class Backpack {
    public int numberOfCombo(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            dp[i] = 0;
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public int backPackII(int m, int[] A, int[] V) {
        int[] max = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) {
                    max[j] = Math.max(V[i] + max[j - A[i]], max[j]);
                }
            }
        }
        return max[m];
    }

    public static void main(String[] args) {
        Backpack problem = new Backpack();
        int[] nums = new int[] {1, 2, 4};
        int target = 4;
        int[] A = new int[]{2, 3, 5, 7};
        int[] V = new int[]{1, 5, 2, 4};
        int m = 10;
        System.out.println(problem.numberOfCombo(nums, target));
        System.out.println(problem.backPackII(m, A, V));
    }
}
