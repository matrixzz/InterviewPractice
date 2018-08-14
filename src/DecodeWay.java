import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DecodeWay {
    static public int numDecodings(String s) {
        if (s == null || s == "") return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int k = Integer.parseInt(s.substring(i-2, i));
            System.out.println(k);
            dp[i] = dp[i-1] + k <= 26 ? dp[i-2] : 0;
        }
        return dp[s.length()];
    }

    static public void main(String[] args) {
        int a = numDecodings("123");
        System.out.println("Ans = " + a);
        int[] arr = new int[]{10, 11};
    }
}
