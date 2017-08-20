import java.util.HashMap;

public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        } else if (s.length() <= k) {
            return s.length();
        }
        int i = 0, j = 0;
        int max = 0;
        int current = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        char[] c = s.toCharArray();
        for (; i < c.length; i++) {
            if (!map.containsKey(c[i]) && map.keySet().size() < k) {
                map.put(c[i], 1);
                current++;
            } else if (map.containsKey(c[i])) {
                int value = map.get(c[i]) + 1;
                map.put(c[i], value);
                current++;
            } else {
                while(map.keySet().size() == k) {
                    int value = map.get(c[j]) - 1;
                    if (value != 0) {
                        map.put(c[j], value);
                    } else {
                        map.remove(c[j]);
                    }
                    j++;
                    current--;
                }
                map.put(c[i], 1);
                current++;
            }
            if (current > max) {
                max = current;
            }
            print(map);
        }
        return max;
    }

    private void print (HashMap<Character, Integer> map) {
        System.out.println("Print: ");
        map.forEach((k, v) -> {
            System.out.println("Key: " + k + " Value: " + v);
        });
    }

    static public void main (String[] args) {
        LongestSubstringKDistinct problem = new LongestSubstringKDistinct();
        String s = "eceabceeeee";
        int k = 3;
        System.out.println(problem.lengthOfLongestSubstringKDistinct(s, k));
    }
}
