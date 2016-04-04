package leetCode;

/**
 * Created by sooglejay on 16/1/18.
 */
public class PowerOfThree {
    public static void main(String[] args) {
        System.out.print(isPowerOfThree(3));
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;

        if (n == 1) return true;
        int nums[]=new int[]{1,3,3};
        int as = nums.length;
        double x = (Math.log(n) / Math.log(3));
        String right = (x + "").split("\\.")[1];
        Print.print("x=" + x + "right=" + right + "Math.round(Math.pow(3,x))=" + (int) (Math.pow(3, Math.round(x))) + "   n=" + Math.round(Math.pow(3, x)));
        if (right.contains("999")) {
            int a = (int) x + 1;
            if ((int) Math.pow(3, a) == n) {
                return true;
            }
        } else if ((int) Math.pow(3, (int) x) == n) {
            return true;
        }
        return false;
    }
}
