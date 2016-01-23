
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumArray {
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public NumArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                map.put(Pair.of(i, j), sum);
            }
        }
    }

    public int sumRange(int i, int j) {
        return map.get(Pair.of(i, j));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);