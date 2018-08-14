import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeOrder {
    public static void main(String[] args) {
        TreeOrder s = new TreeOrder();
        int[] a = new int[]{1, 2, 3, 4, 5};
        Deque<Integer> stack = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
            queue.add(a[i]);
        }
        System.out.println("Stack: ");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Queue: ");
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
