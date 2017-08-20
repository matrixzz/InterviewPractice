import java.util.Arrays;

public class MinStack {
    int total_size, size;
    int[] data;

    public MinStack() {
        this.total_size = 256;
        this.data = new int[total_size];
        this.size = 0;
    }

    public void push(int number) {
        if (++size > total_size) {
            total_size *= 2;
            this.data = Arrays.copyOf(data, total_size);
        }
    }

    public int pop() {
        // write your code here
        return 0;
    }

    public int min() {
        // write your code here
        return 0;
    }
}

