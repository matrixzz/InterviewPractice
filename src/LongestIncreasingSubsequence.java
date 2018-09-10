public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int size = 0;
        int[] tails = new int[nums.length];
        for (int n : nums) {
            int l = 0, r = size, m;
            while (l < r) {
                m = l + (r - l) / 2;
                if (tails[m] < n) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tails[l] = n;
            if (l == size) size++;
        }
        return size;
    }
}
