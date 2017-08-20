import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[1];
        }
        int carry = 1;
        int i = digits.length - 1;
        while (carry > 0) {
            if (i < 0) {
                int[] newResult = new int[digits.length + 1];
                newResult[0] = carry;
                for (int j = 0; j < digits.length; j++) {
                    newResult[j + 1] = digits[j];
                }
                digits = newResult;
            }
            carry = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
            i--;
            String s = "123";
        }

        return digits;
    }

    public static final void main(String[] args) {
        PlusOne problem = new PlusOne();
        int[] digits = new int[] {0};
        System.out.println(problem.plusOne(digits)[0]);
        HashMap<Integer, Integer> hs = new HashMap<>();
        int i = hs.get(1);
        System.out.println(i);
        List<Integer> res = new ArrayList<>();
        int[] result = res.stream().mapToInt((Integer k) -> k.intValue()).toArray();
    }
}
