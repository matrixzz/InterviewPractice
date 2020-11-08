public class CaesarEditDistance {
    public static void main(String[] args) {
        String source = "a";
        String target = "a";

        System.out.println(distance(source, target));
    }

    private static int distance(String source, String target) {
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            String newSource;
            if (i == 0) {
                newSource = source;
            } else {
                for (char c : source.toCharArray()) {
                    char r = (char) (c + i);
                    if (r > 'z') {
                        r = (char) (r - 'z' + 'a');
                    }
                    sb.append(r);
                }
                newSource = sb.toString();
                sb.delete(0, sb.length());
            }
            int value = helper(newSource, target);
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    private static int helper(String source, String target) {
        int n = source.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
            dp[0][i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (source.charAt(i) == target.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j] + 2, dp[i+1][j] + 1), dp[i][j+1] + 1);
                }
            }
        }

        return dp[n][n];
    }
}
