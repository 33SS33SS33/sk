package aMaz;

/**
 * Created by shanshan on 2/9/19.
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference
 * between the values of any two different nodes in the tree.
 * Input: root = [4,2,6,1,3,null,null] Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2,
 * also between node 3 and node 2.
 * Note: The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer,
 * and each node's value is different.
 */
public class MinimumDistanceBetweenBSTNodes {
    Integer res = Integer.MAX_VALUE, pre = null;

    public int minimumDistanceBetweenBSTNodes(TreeNode root) {
        if (root.left != null)
            minimumDistanceBetweenBSTNodes(root.left);
        if (pre != null)
            res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null)
            minimumDistanceBetweenBSTNodes(root.right);
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
