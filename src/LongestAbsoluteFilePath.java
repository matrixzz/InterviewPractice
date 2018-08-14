import java.util.Stack;

public class LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {
        if (input == null || input == "") return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] fds = input.split("\n");
        int max = 0;
        for (String fd : fds) {
            System.out.println("fd = " + fd);
            int lev = fd.lastIndexOf("\t") + 1;
            System.out.println("lev = " + lev);
            while (lev + 1 < stack.size()) stack.pop();
            int len = stack.peek() + fd.length() - lev + 1;
            System.out.println("len = " + len);
            stack.push(len);
            if (fd.contains(".")) max = Math.max(max, len - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String a = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        lengthLongestPath(a);
    }
}
