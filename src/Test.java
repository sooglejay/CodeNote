import leetCode.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sooglejay on 3/20/16.
 */
public class Test {
    public static void main(String[] args) {

        Print.print(firstBadVersion(19)+1);

    }

    public static int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int number[] = new int[n];
        int index;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(gifts[i])) {
                index = hashMap.get(gifts[i]);
                number[index]++;
                if (number[index] > n / 2) {
                    return gifts[index];
                }
            } else {
                hashMap.put(gifts[i], i);
            }
        }
        return -1;

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        int length = 0;
        if ((length = nums.length) < 1) {
            return resultList;
        }
        int first = nums[0];
        int j = 1;
        int index = 1;
        int end = nums[length - 1];
        for (; j < length; j++) {
            if (nums[j] == first + index) {
                index++;
            } else if (nums[j] > first + index) {
                // 1 2 3 5
                if (index == 1) {
                    resultList.add(first + "");
                } else {
                    String item = first + "->" + nums[j - 1];
                    resultList.add(item);
                    index = 1;
                }
                first = nums[j];
            } else if (nums[j] < first + index) {//equal
                // 1 2 3 3
                if (index == 1) {
                    resultList.add(first + "");
                } else {
                    //1 2 3 4 5 6 8 |  8 9
                    String item = first + "->" + nums[j - 1];
                    resultList.add(item);
                    first = nums[j];
                    index = 1;
                }
            }
        }

        if (j > 1) {
            if (first == end) {
                resultList.add(first + "");
            } else {
                resultList.add(first + "->" + end);
            }

        } else
            resultList.add(first + "");
        return resultList;

    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        int length;
        if ((length = nums.length) < 1) {
            return false;
        }
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                index = map.get(nums[i]);
                if ((index > i ? index - i : i - index) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;

    }


    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        int length;
        if ((length = nums.length) < 1) {
            return false;
        }
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                index = map.get(nums[i]);
                if ((index > i ? index - i : i - index) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static int firstBadVersion(int n) {
        int low = 1, high = n;

        int mid = low + (high - low) / 2;
        while (low < high) {
            if (isBadVersion(mid)) {
                mid = low + (high - low) / 2;
            } else {
                low = mid;
            }
        }
        return mid;
    }

    public static boolean isBadVersion(int n) {
        if (n == 8)
            return true;
        return false;

    }


}
