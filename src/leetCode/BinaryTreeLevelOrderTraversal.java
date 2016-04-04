package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by sooglejay on 16/1/16.
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null)
            return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> sonlist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sonlist.add(node.val);
            }
            resultList.add(0,sonlist);
        }
        return resultList;
    }



    public boolean isBalanced(TreeNode root, TreeNode p) {
        if (root == null && p != null) return false;
        if (root != null && p == null) return false;
        if (root == null && p == null) return true;
        if (root.val != p.val)
            return false;
        return isBalanced(root.right, p.right) && isBalanced(root.left, p.left);
    }


}
