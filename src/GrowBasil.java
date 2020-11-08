import util.Printer;

public class GrowBasil {

    public static void main(String[] args) {
        Printer.print(getNumOfBasil(1));
        Printer.print(getNumOfBasil(2));
        Printer.print(getNumOfBasil(3));
        Printer.print(getNumOfBasil(4));
        Printer.print(getNumOfBasil(5));
        Printer.print(getNumOfBasil(6));
    }

    private static int getNumOfBasil(int weeks) {
        int[] dp = new int[weeks+1];
        int[] dp2 = new int[weeks+1];
        dp[0] = 0;
        dp[1] = 0;
        dp2[0] = 0;
        dp2[1] = 1;

        for (int i = 2; i <= weeks; i++) {
            dp[i] = dp[i-1] + dp2[i-1];
            dp2[i] = dp[i-1];
        }

        return dp[weeks] + dp2[weeks];
    }
}
