import java.util.Stack;

public class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0 || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

