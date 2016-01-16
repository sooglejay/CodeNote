import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        char c = '#';
        TreeNode node = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        TreeNode right1_l = new TreeNode(15);
        TreeNode right1_r = new TreeNode(7);
        node.left = left1;
        node.right = right1;
        right1.left = right1_l;
        right1.right = right1_r;


        System.out.print(levelOrder(node).toString());
//        ReverseLink.main(args);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        while (nodes.size() > 0) {
            int size = nodes.size();
            List<Integer> integerList = new ArrayList<>();
            List<TreeNode> tempNodes = new ArrayList<TreeNode>();
            for (int j = 0; j < size; j++) {
                TreeNode node = nodes.get(j);
                integerList.add(node.val);
                if (node.left != null) {
                    tempNodes.add(node.left);
                }
                if (node.right != null) {
                    tempNodes.add(node.right);
                }
            }
            list.add(integerList);
            nodes.clear();
            nodes.addAll(tempNodes);
        }
        return list;
    }

}
