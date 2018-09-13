import java.util.HashMap;
import java.util.Map;

public class ColaMachine {
    public static void main(String[] args) {
        int[][] buttons = new int[][]{{100, 120}, {200, 240}, {400, 410}};
        int[] target = new int[]{100, 110};
        Map<int[], Boolean> cache = new HashMap<>();
        int[] cur = new int[]{0, 0};
        System.out.println(helper(buttons, new int[]{100, 120}, cache, cur));
        System.out.println(helper(buttons, new int[]{90, 120}, cache, cur));
        System.out.println(helper(buttons, new int[]{300, 350}, cache, cur));
        System.out.println(helper(buttons, new int[]{310, 360}, cache, cur));
        System.out.println(helper(buttons, new int[]{300, 370}, cache, cur));
        System.out.println(helper(buttons, new int[]{100, 110}, cache, cur));
    }

    private static boolean helper(int[][] buttons, int[] target, Map<int[], Boolean> cache, int[] cur) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        if (cur[0] >= target[0] && cur[1] <= target[1]) {
            cache.put(cur, true);
            return true;
        } else if (cur[1] > target[1]) {
            return false;
        } else {
            for (int[] b : buttons) {
                if (helper(buttons, target, cache, new int[]{cur[0] + b[0], cur[1] + b[1]})) {
                    cache.put(cur, true);
                    return true;
                }
            }
            cache.put(cur, false);
            return false;
        }
    }
}
