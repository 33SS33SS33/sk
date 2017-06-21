package aFB;

import java.util.Stack;

/**
 * Created by GAOSHANSHAN835 on 2016/1/18.
 * 中序遍历二叉树即可
 * 题目说要修改BST结构 可以在每个节点加上一个属性指示这个节点下面的左子树有多少个节点
 * 这样就可以用二分查找了
 * 未实现
 * 要熟练掌握二叉树的 递归和迭代遍历
 */

public class KthSmallestElementinaBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        System.out.println(new KthSmallestElementinaBST().kthSmallesta(root, 3));
        System.out.println(new KthSmallestElementinaBST().kthSmallesta3(root, 3));
        System.out.println(new KthSmallestElementinaBST().kthSmallestA(root, 3));
        System.out.println(new KthSmallestElementinaBST().kthSmallestB(root, 3));
    }

    /**
     * Binary Search (dfs): most preferable
     */
    public int kthSmallesta(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallesta(root.left, k);
        } else if (k > count + 1) {
            return kthSmallesta(root.right, k - 1 - count); // 1 is counted as current node
        }
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /**
     * DFS in-order iterative
     */
    public int kthSmallesta3(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0)
                return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        return -1; // never hit if k is valid
    }

    boolean reachLeftMost = false;
    boolean stop = false;
    int kth = 0;
    int k = 0;

    public int kthSmallestA(TreeNode root, int k) {
        this.k = k;
        search(root);
        return kth;
    }

    void search(TreeNode root) {
        if (stop) {
            return;
        }
        if (root == null) {
            reachLeftMost = true;
            return;
        }
        search(root.left);
        if (reachLeftMost) {
            k--;
        }
        if (k == 0) {
            kth = root.val;
            stop = true;
            return;
        }
        search(root.right);
    }

    /**
     * creek  -----We can inorder traverse the tree and get the kth smallest element. Time is O(n).
     */
    public int kthSmallestB(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int result = 0;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                k--;
                if (k == 0)
                    result = t.val;
                p = t.right;
            }
        }
        return result;
    }

    /**
     * creek------We can let each node track the order, i.e.,
     * the number of elements that are less than itself. Time is O(log(n)).
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}