import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargest {
    public List<Integer> topK(int[] a, int k) {
        PriorityQueue<Integer> maxStack = new PriorityQueue<Integer>((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        });

        for(int i = 0; i < a.length; i++) {
            maxStack.offer(a[i]);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(maxStack.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 100, 10, 4, -88, 2};
        int k = 2;
        TopKLargest problem = new TopKLargest();
        problem.print(problem.topK(a, k));
    }

    private void print(List<Integer> list) {
        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
