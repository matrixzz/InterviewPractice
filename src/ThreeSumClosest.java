import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1] )) {
                int lo = i + 1, hi = nums.length - 1, sum = target - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        return target;
                    } else {
                        if (Math.abs(nums[lo] + nums[hi] + nums[i] - target) < Math.abs(closest - target))
                            closest = nums[lo] + nums[hi] + nums[i];
                        if (nums[lo] + nums[hi] < sum) {
                            lo++;
                        } else {
                            hi--;
                        }
                    }
                }
            }
        }
        return closest;
    }

    public static final void main(String[] args) {
        int[] num = new int[]{-3,-2,-5,3,-4};
        int t = -1;
        ThreeSumClosest problem = new ThreeSumClosest();

        System.out.println(problem.threeSumClosest(num, t));
    }
}
