import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new LinkedList<>();
        char[] pair = new char[]{'(', ')'};
        remove(s, ans, pair, 0, 0);
        return ans;
    }

    private static void remove(String s, List<String> ans, char[] pair, int last_i, int last_j) {
        int stack = 0;
        for (int i = last_i; i < s.length(); i++) {
            if(s.charAt(i) == pair[0]) stack++;
            else if(s.charAt(i) == pair[1]) stack--;
            if (stack >= 0) continue;

            for(int j = last_j; j <= i; j++) {
                if(s.charAt(j) == pair[1] && (j == last_j || s.charAt(j) != s.charAt(j-1)) ) {
                    String newStr = s.substring(0, j) + s.substring(j+1, s.length());
                    System.out.println(newStr);
                    remove(newStr, ans, pair, i, j);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println("Reversed: " + reversed);
        if(pair[0] == '(') {
            remove(reversed, ans, new char[]{')', '('}, 0, 0);
        } else {
            ans.add(reversed);
        }
    }

    public static void main(String[] args) {
        String s = "()())()";
        removeInvalidParentheses(s);
    }
}
