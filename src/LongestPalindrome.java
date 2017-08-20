public class LongestPalindrome {
    public String get(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return j - i - 1;
    }

    public static final void main(String[] args) {
        LongestPalindrome problem = new LongestPalindrome();
        print(problem.get("abadefgh"));
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
