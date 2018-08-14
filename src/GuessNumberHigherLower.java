public class GuessNumberHigherLower {
    int num;

    GuessNumberHigherLower(int n) {
        this.num = n;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int p = (low + high) / 2;
        while (true) {
            int result = guess(p);
            if (result == 0) {
                return p;
            } else if (result > 0) {
                high = p;
            } else {
                low = p;
            }
            System.out.println("low is " + low);
            System.out.println("high is " + high);
            p = (low + high) / 2;
            System.out.println("new p is " + p);
        }
    }

    private int guess(int n) {
        if (n == this.num) {
            return 0;
        } else if (n > this.num) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        GuessNumberHigherLower problem = new GuessNumberHigherLower(2);
        System.out.println(problem.guessNumber(2));
    }
}
