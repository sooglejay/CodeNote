/**
 * Created by sooglejay on 16/1/12.
 */
public class RemoveValue {
    public static void main(String args[]) {

        System.out.print(removeElement(new int[]{4, 5}, 4));
    }

    public static int removeElement(int[] nums, int val) {
        int length;
        if ((length = nums.length) < 1) {
            return length;
        }
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[newLength] = nums[i];
            newLength++;
        }
        return newLength;
    }
}
