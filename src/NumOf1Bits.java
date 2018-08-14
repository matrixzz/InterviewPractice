public class NumOf1Bits {
    static public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>= 1;
        }
        return result;
    }

    static public void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
