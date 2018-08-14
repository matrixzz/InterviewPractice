public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] a = new int[] {1, 5, 11, 5};
        System.out.println("Answer is:");
        System.out.println(solution(a));


//        System.out.println("\nAnswer 2 is:");
//        System.out.println(solution2(a));
    }

    public static int solution(int[] a) {
        int sum = 0;
        for(int n : a) {
            sum += n;
        }
        if (sum % 2 != 0) return 0;

        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int n : a) {
            for (int s = sum; s >= n; s--) {
                dp[s] = dp[s] + dp[s - n];
                System.out.println("Updating dp[" + s + "]... = " + dp[s] + " using" + " dp[" + s +"] and dp[" + (s-n) +"]");
            }
        }
        return dp[sum];
    }

    public static int solution2(int[] a) {
        int sum = 0;
        for(int n : a) {
            sum += n;
        }
        if (sum % 2 != 0) return 0;

        int[][] dp = new int[a.length+1][sum+1];
        for(int i = 0; i < a.length+1; i++) dp[i][0] = 1;
        for (int i = 1; i < a.length + 1; i++) {
            for (int s = a[i-1]; s <= sum; s++) {
                dp[i][s] = dp[i-1][s] + dp[i-1][s - a[i-1]];
                System.out.println("Updating dp[" + i + "]" + "[" + s + "] = " + dp[i][s]);
            }
        }
        return dp[a.length][sum];
    }
}
