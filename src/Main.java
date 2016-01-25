import javax.sound.midi.SysexMessage;
import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

//        int[] aa = new int[]{3, 1, 1, 2};

//        Print.print(Math.log(Math.E)+"");
//        System.out.print(PowerOfThree.isPowerOfThree(2147483647));
//        NumArray numArray = new NumArray(nums);
//        Print.print("\n\n"+numArray.sumRange(0, 1)+"\n\n");
//        Print.print(numArray.sumRange(50, 9678));
        int str = 508;

        Print.print(243*243*81*3);
    }

    public static long trailingZeroes(int n) {
        long sum = 1;
        while (n > 0) {
            sum = sum*n;
            Print.println("n="+n+"  sum= "+sum +" ");
            n--;
        }
        String str = sum + "";
        sum = 0;
        Print.print(str);
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                sum++;
            } else {
                break;
            }
        }
        return sum;
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


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();

        //first sort
        for (int j = 1; j < nums.length; j++) {
            int key = nums[j];
            int i = j - 1;
            while (i >= 0 && nums[i] > key) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = key;
        }

        String numberStr = "";
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int p = nums.length - 1;
                while (k < p) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[p];
                    if (sum == target) {
                        String tempStr = nums[i] + "" + nums[j] + "" + nums[k] + "" + nums[p];
                        if (numberStr.equals("")) {
                            numberStr = tempStr;
                        } else if (numberStr.equals(tempStr)) {
                            k++;
                            continue;
                        }
                        List<Integer> sonList = new ArrayList<>();

                        sonList.add(nums[i]);
                        sonList.add(nums[j]);
                        sonList.add(nums[k]);
                        sonList.add(nums[p]);
                        list.add(sonList);
                        do {
                            ++k;
                        }
                        while (k < p && nums[k] == nums[k - 1]);
                        do {
                            --p;
                        }
                        while (k < p && nums[p] == nums[p + 1]);
                    } else if (sum < target)
                        k++;  //we can do this operation because of we sort the array at the beginnin
                    else
                        p--;
                }

            }
        }
        return list;

    }
}
