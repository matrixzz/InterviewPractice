import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class TrapRain1 {
    public static int trap(int[] height) {
        int rain = 0;
        for(int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for(int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for(int k = i; k < height.length; k++) {
                maxRight = Math.max(maxRight, height[k]);
            }
            rain += Math.min(maxLeft, maxRight) - height[i];
        }

        return rain;
    }

    public static int trap_stack(int[] height) {
        int rain = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < height.length; i++) {
            while(!st.empty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if(st.empty()) break;
                int distance = i - st.peek() - 1;
                rain += distance * (Math.min(height[st.peek()], height[i]) - height[top]);
            }
            st.push(i);
        }
        return rain;
    }

    public static int trap_dynamic_programming(int[] height) {
        int rain = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            rain += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return rain;
    }

    public static final void main(String[] args) {
        int[] height = new int[]{1, 2, 0, 1, 0, 4};
        int rain = trap_dynamic_programming(height);

        System.out.println(rain);
    }
}
