import java.util.*;

// // Check if a Binary Tree contains duplicate subtrees of size 4 or more

/*

     1
    2 3
   3   5
  4   2
 5   3
    4
   5

*/


public class UberFindDuplicateSubTree {
    private static final String SIGNAL = "@";
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Set<String> set = new HashSet<>();
    }

    class Node {
        int key;
        Node left, right;
    }

    private boolean check(Node root, Set<String> set) {
        if (root == null) return false;
        Map<Node, String> map = new HashMap<>();
        String s = "" + root.key + helper(root.left, map) + helper(root.right, map);
        String k = s.replace(SIGNAL, "");
        if (k.length() >= 4 && set.contains(s)) {
            return true;
        }
        set.add(s);

        if (root.left != null && check(root.left, set)) {
            return true;
        }

        if (root.right != null && check(root.right, set)) {
            return true;
        }

        return false;
    }

    private String helper(Node root, Map<Node, String> map) {
        if (root == null)
            return SIGNAL;

        if (map.containsKey(root)) {
            return map.get(root);
        }
        String s = "" + root.key;
        String left = helper(root.left, map);
        String right = helper(root.right, map);

        s = s + left + right;

        map.put(root, s);
        return s;
    }
}