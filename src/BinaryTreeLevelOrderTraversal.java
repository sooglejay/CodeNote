import java.util.ArrayList;
import java.util.List;

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
        List<Integer> sonlist = new ArrayList<>();


        if (root != null) {
            if (root.val != '#')
                sonlist.add(root.val);
            else return resultList;
            if (root.left != null) {
                   if(root.left.val!='#')
                   {
                       sonlist.add(root.left.val);
                   }
            }
        } else return resultList;

        return null;

    }

}
