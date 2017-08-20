import java.util.Arrays;

public class MissingNumber {
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

    public static void main(String[] args) {
        int[] nums = new int[] {
                0, 1, 2, 5, 6, 4
        };
        MissingNumber problem = new MissingNumber();
        System.out.println(problem.findMissing(nums));
    }
}
