import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhu on 7/16/17.
 */
public class TwoSum_1 {
        public int[] twoSum(int[] nums, int target) {
//            int result[];
            for(int i = 0; i < nums.length; i++) {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target) {
                        int result[] = {i, j};
                        return result;
                    }
                }
            }
            return null;
        }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer comp = target - nums[i];
            if(map.containsKey(comp) && map.get(comp) != i) {
                return new int[]{map.get(comp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static final void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
    }
}
