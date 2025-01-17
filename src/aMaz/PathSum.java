package aMaz;

import java.util.LinkedList;


class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        System.out.println(new PathSum().hasPathSumA(root, 7));
        System.out.println(new PathSum().hasPathSumB(root, 7));
        System.out.println(new PathSum().hasPathSumA(root, 10));
        System.out.println(new PathSum().hasPathSumB(root, 10));
        System.out.println(new PathSum().hasPathSumA(root, 4));
        System.out.println(new PathSum().hasPathSumB(root, 4));
    }

    /**
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1  Given the  binary tree and sum = 22,
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals the given sum.
     * return true, as there a root-to-leaf path 5->4->11->2 which sum is 22.
     * Tags: Tree, DFS 先序遍历 碰到叶子了计算一下
     * 递归  creek 算法的复杂度是输的遍历，时间复杂度是O(n)，空间复杂度是O(logn)
     * 递归条件是看左子树或者右子树有没有满足条件的路径，也就是子树路径和等于当前sum减去当前节点的值。
     * 结束条件是如果当前节点是空的，则返回false，如果是叶子，那么如果剩余的sum等于当前叶子的值，则找到满足条件的路径，返回true
     */
    public boolean hasPathSumA(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSumA(root.left, sum - root.val) || hasPathSumA(root.right, sum - root.val);
    }

    public boolean hasPathSumB(TreeNode root, int sum) {
        if (root == null)
            return false;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();
        nodes.add(root);
        values.add(root.val);
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();
            if (curr.left == null && curr.right == null && sumValue == sum) {
                return true;
            }
            if (curr.left != null) {
                nodes.add(curr.left);
                values.add(sumValue + curr.left.val);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
                values.add(sumValue + curr.right.val);
            }
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}