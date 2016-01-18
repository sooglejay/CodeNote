import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sooglejay on 16/1/17.
 */
public class FourSum {
    public static void main(String[] args) {
        int nums[] = new int[]{2, 0, 0, 0, 1, 0, 0, 1};
        int t = 2;
        System.out.println(nums[0] << 2);

        fourSum(nums, t);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (nums[i] << 2 > target) return list;
            for (int j = length - 1; j > i + 2; j--) {
                if (nums[j] << 2 < target) break;
                int res = target - nums[i] - nums[j];
                int lo = i + 1;
                int hi = j - 1;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if (sum < res) ++lo;
                    else if (sum > res) --hi;
                    else {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
                        while (hi >= ++lo && nums[lo] == nums[lo - 1]) continue;
                        while (--hi >= lo && nums[hi] == nums[hi + 1]) continue;
                    }
                }
                while (j >= 1 && nums[j] == nums[j - 1]) --j;
            }
            while (i < length - 1 && nums[i] == nums[i + 1]) ++i;
        }
        return list;
    }

}
