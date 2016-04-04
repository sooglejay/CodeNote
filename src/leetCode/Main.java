package leetCode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        int[] aa = new int[]{3, 1, 1, 2};

//        leetCode.Print.print(Math.log(Math.E)+"");
//        System.out.print(leetCode.PowerOfThree.isPowerOfThree(2147483647));
//        leetCode.NumArray numArray = new leetCode.NumArray(nums);
//        leetCode.Print.print("\n\n"+numArray.sumRange(0, 1)+"\n\n");
//        leetCode.Print.print(numArray.sumRange(50, 9678));
        int str = 508;
        String mylm = "12.34.56";
        String a[] = mylm.split(".");
ShellSort.shellSort(new int[]{7,111,1,46,5,4,3,2,1});
        try {
//            leetCode.InterFace.main(args);
        } catch (Exception e) {

        }

//        System.out.print(a);
    }

    public static long trailingZeroes(int n) {
        long sum = 1;
        while (n > 0) {
            sum = sum * n;
            Print.println("n=" + n + "  sum= " + sum + " ");
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

    public static boolean getHint(String pattern, String str) {
        if (str == null) {
            return true;
        }
        int length = pattern.length();
        String array[] = str.split("\\s+");
        if (array.length != length) return false;
        HashMap<Integer, String> map = new HashMap<>();
        String temp = "null";
        map.put((int) pattern.charAt(0), array[0]);

        for (int i = 0; i < length; i++) {
            temp = map.get((int) pattern.charAt(i));
            System.out.println("i" + i + "  array[" + i + "]:" + array[i] + "  temp:" + temp);
            if (temp == null) {
                if (map.containsValue(array[i])) {
                    return false;

                } else {
                    map.put((int) pattern.charAt(i), array[i]);

                }
            }

            if (!temp.equals(array[i])) {
                System.out.println("  will return : i" + i + "  array[" + i + "]:" + array[i] + "  temp:" + temp);
                return false;
            }
        }

        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int snum[] = new int[136];
        int tnum[] = new int[136];

        for (int i = 0; i < s.length(); i++) {
            int indexS = (s.charAt(i) - ' ');
            int indexT = (t.charAt(i) - ' ');


            if (snum[indexS] != 0) {
                snum[indexS] += i + 100;
            } else
                snum[indexS] = i + 1;


            if (tnum[indexT] != 0) {
                tnum[indexT] += i + 100;
            } else
                tnum[indexT] = i + 1;

            if (snum[indexS] != tnum[indexT]) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.entrySet();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (i - index > k) {
                    continue;
                } else return true;
            } else {
                map.put(nums[i], i);
            }
        }

        HashMap<Integer, String> dic = new HashMap<>();
        HashMap<String, Integer> dicStr = new HashMap<>();
        dic.put(31, "One");
        dic.put(32, "Two");
        dic.put(33, "Three");
        dic.put(34, "Four");
        dic.put(35, "Five");
        dic.put(36, "Six");
        dic.put(37, "Seven");
        dic.put(38, "Eight");
        dic.put(39, "Nine");

        dic.put(10, "Ten");
        dic.put(11, "Eleven");
        dic.put(12, "Twelve");
        dic.put(13, "Thirteen");
        dic.put(14, "Fourteen");
        dic.put(15, "Fifteen");
        dic.put(16, "Sixteen");
        dic.put(17, "Seventeen");
        dic.put(18, "Seventeen");
        dic.put(19, "Eighteen");
        dic.put(20, "Twenty");
        dic.put(30, "Thirty");
        dic.put(40, "Forty");
        dic.put(50, "Fifty");
        dic.put(60, "Sixty");
        dic.put(70, "Seventy");
        dic.put(80, "Eighty");
        dic.put(90, "Ninety");
        dic.put(2, "Hundred");
        dic.put(3, "Thousand");
        dic.put(4, "Ten Thousand");
        dic.put(5, "Hundred Thousand");
        dic.put(6, "Million");
        dic.put(7, "Ten Million");
        dic.put(8, "Hundred Million");
        dic.put(9, "Billion");
//        dic.put(1000, "Thousand");
//        dic.put(1000000, "Million");
//        dic.put(1000000000, "Billion");


        int number = 1234;
        String str = "";
        int i = number % 100;
        number /= 100;
        int count = 2;
        while (number > 0) {
            dicStr.put(count + "", i);
            count++;
            number /= 10;
            i = number % 10;
        }
        String result = "";
        for (int j = count; j > 0; j--) {
            if (j > 2) {
                if (dicStr.containsKey(j + "")) {
                    result += dicStr.get(j + "") + dic.get(j);
                }
            } else if (j == 2) {
                int n = dicStr.get(2 + "");
                if (n % 10 == 0) {
                    result += dic.get(n);
                } else {
                    result += dic.get(j + 30);
                }
            }
        }
        return false;

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
