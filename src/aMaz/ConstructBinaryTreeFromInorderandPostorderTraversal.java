package aMaz;

import java.util.HashMap;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not wordSearchb in the tree.
 * Tags: Tree, Array, DFS
 * 跟上面题思路差不多
 * 只是后序的话  确定根是从后往前走  最后的元素是根 倒数第二个就是右子树的根
 * 每次pop最后一个  然后用它来分割中序的字符串
 */
class ConstructBinaryTreeFromInorderandPostorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 3, 6};
        int[] postorder = {4, 5, 2, 6, 3, 1};
        TreeNode root = new ConstructBinaryTreeFromInorderandPostorderTraversal().constructBinaryTreeFromInorderandPostorderTraversal(inorder, postorder);
    }

    /**
     * The the basic idea is to take the last element in postorder array as the root, find the
     * position of the root in the inorder array; then locate the range for left sub-tree and
     * right sub-tree and do recursion. Use a HashMap to record the index of root in the
     * inorder array 复杂度和空间复杂度也还是O(n)
     */
    public TreeNode constructBinaryTreeFromInorderandPostorderTraversal(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR,
                            HashMap<Integer, Integer> map) {
        if (inL > inR || postL > postR)
            return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(root.val);
        root.left = helper(inorder, postorder, inL, index - 1, postL, postL + index - inL - 1, map);
        root.right = helper(inorder, postorder, index + 1, inR, postR - (inR - index), postR - 1,
                map);
        return root;
    }

    /**
     * DFS, find root, find range of left and right sub trees
     * The calculation of post array is trivial
     * For left subtree, ps = ps, pe = ps - is - 1 + pos(offset, including root)
     * For right subtree, ps = pe - ie + pos, pe = pe - 1(without root)
     */
    public TreeNode constructBinaryTreeFromInorderandPostorderTraversalb(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe) {
        if (ps > pe)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int pos = is;
        for (; pos <= ie; pos++) {
            if (inorder[pos] == root.val)
                break;
        }
        // Note how to calcuclate the start and end indices for post array
        root.left = helper(inorder, postorder, is, pos - 1, ps, ps - is - 1 + pos);
        root.right = helper(inorder, postorder, pos + 1, ie, pe - ie + pos, pe - 1);
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
