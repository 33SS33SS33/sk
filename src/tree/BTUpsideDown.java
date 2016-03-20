package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by GAOSHANSHAN835 on 2016/1/18.
 */
public class BTUpsideDown {
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
        System.out.println(new BTUpsideDown().levelOrder(new BTUpsideDown().upsideDownBinaryTree(root)));
    }
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

    void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        queue.add(root);
        if(root.left != null) {
            queue.add(root.right);
        }
        // bad side effect
        root.left  = null;
        root.right = null;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        inOrder(root);
        TreeNode newRoot = queue.poll();
        root = newRoot;
        while(!queue.isEmpty()){
            root.right = queue.poll();
            root.left  = queue.poll();
            root = root.right;
        }
        return newRoot;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                curLevel.add(n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            res.add(curLevel);
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
