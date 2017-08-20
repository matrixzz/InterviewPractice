public class DropEggs {
    public int dropEggs(int n) {
        int i = 1;
        long res = 0;
        while(true) {
            res += (long) i;
            if (res >= (long) n) {
                return i;
            }
            i++;
        }
    }

    public static final void main(String[] args) {
        DropEggs problem = new DropEggs();
        int n = 2147483647;
        System.out.println(problem.dropEggs(n));
    }
}
