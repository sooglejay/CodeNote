
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sooglejay on 16/1/11.
 */
public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {3, 2, 4};
        int target = 6;
        int result[] = {0, 0};
        result = function(nums, target);
        System.out.println("Output: index1=" + result[0] + ",index2=" + result[1]);
    }

    private static int[] function(int[] nums, int target) {
        List<Integer> datasList = new ArrayList<Integer>();
        int size = nums.length;
        int[] result = new int[]{0, 0};
        for (int i = 0; i < size; i++) {
            datasList.add(nums[i]);
        }
        int temp = 0;
        int index2 = 0;
        for (int index1 = 0; index1 < size; index1++) {
            temp = target - nums[index1];
            if (datasList.contains(temp)) {
                index2 = datasList.indexOf(temp);
                if (index2 == index1) {//this is a trap of this question here
                    continue;
                }
                if (index1 > index2) {
                    temp = index1;
                    index1 = index2;
                    index2 = temp;
                }
                result[0] = index1 + 1;
                result[1] = index2 + 1;
                break;
            }
        }
        return result;
    }
}