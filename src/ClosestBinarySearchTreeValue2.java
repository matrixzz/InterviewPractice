import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValue2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        inorderTravel(res, root, target, k);
        return res;
    }

    private boolean inorderTravel(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) {
            return false;
        }

        if (inorderTravel(res, root.left, target, k)) {
            return true;
        }

        if (res.size() == k) {
            if (Math.abs(res.getFirst() - target) < Math.abs(root.val - target)) {
                return true;
            } else {
                res.removeFirst();
            }
        }

        res.add(root.val);
        return inorderTravel(res, root.right, target, k);
    }

    public static void main(String[] args) {
        ClosestBinarySearchTreeValue2 problem = new ClosestBinarySearchTreeValue2();
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right = new TreeNode(5);

        problem.closestKValues(tree, 3.7882, 2);
    }
}
