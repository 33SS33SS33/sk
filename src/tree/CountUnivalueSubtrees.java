package tree;

/**
 * Created by GAOSHANSHAN835 on 2016/1/18.
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example:
 * Given binary tree,
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * return 4.
 */

/**
 * 只要叶子节点 就一定是一个univalue tree 所以使用后序遍历即可 如果自己的左右子树都是 那么自己的值又和左右子树都一样 那么就把自己也算上(记得考虑子树是none的情况)
 * 然后返回即可
 */
public class CountUnivalueSubtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        System.out.println(new CountUnivalueSubtrees().countUnivalSubtrees(root));
    }

    public int countUnivalSubtrees(TreeNode root) {
        return _countUnivalSubtrees(root)[0];
    }

    // [count, uniq val]
    Integer[] _countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return new Integer[] { 0, null };

        Integer[] left = _countUnivalSubtrees(root.left);
        patch(left, root, root.left);

        Integer[] right = _countUnivalSubtrees(root.right);
        patch(right, root, root.right);

        if (Objects.equals(left[1], root.val) && Objects.equals(right[1], root.val)) {
            return new Integer[] { left[0] + right[0] + 1, root.val };
        }
        return new Integer[] { left[0] + right[0], null };
    }

    void patch(Integer[] v, TreeNode parent, TreeNode me) {
        if (me == null) {
            v[1] = parent.val;
        }
    }

    public static class TreeNode {
        Integer  val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Objects {
        public static boolean equals(Integer obj1, Integer obj2) {
            return obj1.equals(obj2);
        }
    }
}
