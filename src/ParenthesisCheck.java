import java.util.Stack;

public class ParenthesisCheck {
    public static boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '(':
                    stack.push(arr[i]);
                    break;
                case ')':
                    if (stack.empty() || stack.peek() != '(') {
                        if (count > 0) {
                            count--;
                        } else {
                            return false;
                        }
                    } else {
                        stack.pop();
                    }
                    break;
                case '*':
                    count++;
                    break;
            }
        }
        while(!stack.isEmpty()) {
            if (count > 0) {
                stack.pop();
                count--;
            } else {
                return false;
            }
        }

        return count >= 0;
    }

    public static void main(String[] args) {
        System.out.println(ParenthesisCheck.checkValidString("((*)(*))((*"));
    }
}
