import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) return false;
        Map<String, Boolean> dict = new HashMap<>();
        for (String w : wordDict) {
            dict.put(w, true);
        }
        return breakRecur(s, 0, dict);
    }

    private boolean breakRecur(String s, int i, Map<String, Boolean> dict) {
        if (i >= s.length()) return true;
        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);
            if (dict.containsKey(word) && breakRecur(s, j, dict)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak problem = new WordBreak();
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(problem.wordBreak("leetcode", wordDict));
    }
}
