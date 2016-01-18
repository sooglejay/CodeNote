/**
 * Created by sooglejay on 16/1/18.
 */
public class PowerOfThree {
    public static void main(String[] args) {
        System.out.print(isPowerOfThree(3));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        int j = 0;
        while (n >=3) {
            n = n / 3;
            j++;
        }
        if (j % 3 == 0) {
            return true;
        } else {
            return false;
        }


    }
}
