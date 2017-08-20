public class IdenticalBinaryTree {

     public static class TreeNode {
         public int val;
         public TreeNode left, right;
         public TreeNode(int val) {
             this.val = val;
             this.left = this.right = null;
         }
     }

    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if ((a == null && b == null)) {
            return true;
        } else if ( a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right)) {
            return true;
        }
        return false;
    }

    public static final void main(String args[]) {
        IdenticalBinaryTree problem = new IdenticalBinaryTree();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);

        System.out.println(problem.isIdentical(a, b));
    }
}
