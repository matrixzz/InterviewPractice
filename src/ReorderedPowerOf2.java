import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        if (isPower2(N)) return true;

        String tmp = N + "";
        int[] digits = new int[tmp.length()];
        for (int i = 0; i < tmp.length(); i++) {
            digits[i] = tmp.charAt(i) - '0';
        }
        Arrays.sort(digits);
        List<Integer> per = new ArrayList<>();
        permutation(digits, 0, digits.length -1, per);

        for (Integer i : per) {
            if (isPower2(i)) return true;
        }

        return false;
    }

    private void permutation(int[] digits, int s, int e, List<Integer> per) {
        if (s == e) {
            int res = 0;
            for (int i : digits) {
                if (res == 0 && i == 0) return;
                res = res * 10 + i;
            }
            per.add(res);
        }
        int i = 0;
        for (i = s; i <= e; i++) {
            swap(digits, i, s);
            permutation(digits, s + 1, e, per);
            swap(digits, i, s);
        }
    }

    private void swap(int[] digits, int i, int j) {
        int tmp = digits[i];
        digits[i] = digits[j];
        digits[j] = tmp;
    }

    private boolean isPower2(int N) {
        int one = 0;
        while (N != 0) {
            if ((N & 1) == 1) {
                one++;
                if (one > 1)
                    return false;
            }
            N >>= 1;
        }
        return one == 1;
    }

    public static void main(String[] args) {
        int n = 46;
        ReorderedPowerOf2 c = new ReorderedPowerOf2();
        System.out.println(c.reorderedPowerOf2(n));
    }
}
