import java.util.HashMap;

public class MinimalSubString {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int count = 0, left = 0, minLeft = 0, minLen = s.length()+1;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) count++;
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    Character leftC = s.charAt(left);
                    if (map.containsKey(leftC)) {
                        map.put(leftC, map.get(leftC) + 1);
                        if (map.get(leftC) > 0) count--;
                    }
                    left++;
                }
            }
        }

        if (minLen > t.length()) return "";
        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
