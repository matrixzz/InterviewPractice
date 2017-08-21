import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);
        int c = nums.length / 2;
        int i = 0;
        for (; i < c; i++) {
            nums[i * 2] = copy[i];
            nums[i * 2 + 1] = copy[n - 1 - i];
        }
        if (i * 2 - n != 0) {
            nums[i * 2] = copy[n - 1 - i];
        }
//        if (nums[nums.length - 1] == nums[nums.length - 2]) {
//            for(int j = 0; j < nums.length - 1; j++) {
//                swap(nums, j, nums.length - 1);
//                if ( (j > 0 && nums[j] > nums[j - 1] || j == 0) && (nums[j] > nums[j + 1])
//                        && (nums[nums.length - 1] > nums[nums.length - 2 ])) {
//                    return;
//                } else {
//                    swap(nums, j, nums.length - 1);
//                }
//            }
//        }
    }

    public void wiggleSort2(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int n = nums.length;
        int i = 0;
        int j = n;
        int k = (n + 1) / 2;
        Arrays.sort(copy);
        for (; i < n; i++) {
            nums[i] = i % 2 == 1 ? copy[--j] : copy[--k];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print("" + nums[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
            4,5,5,6
        };
        WiggleSort problem = new WiggleSort();
        problem.wiggleSort2(nums);
        problem.print(nums);
    }
}
