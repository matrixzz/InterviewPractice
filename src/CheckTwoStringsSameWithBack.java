public class CheckTwoStringsSameWithBack {
    public static void main(String[] args) {
        System.out.println(check("abc\\b\\b", "ade\\b\\b"));
        System.out.println(check("aebc\\b\\b", "ade\\b\\b"));
    }

    private static boolean check(String s, String t) {
        if (s.length() != t.length()) return false;
        int sb = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != t.charAt(i) && sb > 0) {
                sb--;
                continue;
            } else if (s.charAt(i) != t.charAt(i)) {
                return false;
            }
            if (i > 0 && s.charAt(i) == 'b' && s.charAt(i-1) == '\\' && t.charAt(i-1) == '\\') {
                sb++;
                i--;
            }
        }
        return true;
    }
}
