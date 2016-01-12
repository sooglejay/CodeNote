import java.util.HashMap;

/**
 * Created by sooglejay on 16/1/12.
 */
public class PlusOne {
    public static void main(String[] args) {
        plusOne(new int[]{9, 9});
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int sum;
        int one = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = length - 1; i >= 0; i--) {
            sum = one + digits[i];
            one = sum / 10;
            map.put(i, sum % 10);
        }
        if (one > 0) {
            int newDigits[] = new int[map.size()+1];
            newDigits[0] = one;
            for (int j = 1; j < map.size(); j++) {
                newDigits[j] = map.get(j - 1);
            }
            return newDigits;
        } else {
            int newDigits[] = new int[map.size()];
            for (int j = 0; j < map.size(); j++) {
                newDigits[j] = map.get(j);
            }
            return newDigits;
        }

    }
}
