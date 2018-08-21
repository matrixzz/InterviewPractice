public class ConstructTreeFromPreAndPost {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    private int preindex;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        preindex = 0;
        return con(pre, post, 0, pre.length - 1, pre.length);
    }

    private TreeNode con(int[] pre, int[] post, int l, int h, int size) {
        if (preindex >= size || l > h) return null;
        TreeNode root = new TreeNode(pre[preindex++]);

        if (l == h || preindex >= size)
            return root;
        int i;
        for (i = l; i <= h; i++) {
            if (post[i] == pre[preindex])
                break;
        }

        if (i <= h) {
            root.left = con(pre, post, l, i, size);
            root.right = con(pre, post, i + 1, h - 1, size);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3,4,1,2};
        int[] post= new int[]{1,4,2,3};
        ConstructTreeFromPreAndPost p = new ConstructTreeFromPreAndPost();
        TreeNode r = p.constructFromPrePost(pre, post);
        System.out.println("Complete");
    }
}
