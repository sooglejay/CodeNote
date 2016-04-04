package leetCode;

import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y, z;
        while (scanner.hasNext()) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();
            String seq = scanner.next();
            System.out.print("" + lengthOfLongestSubstring(x, y, z, seq) + "\n");
        }
    }

    public static int lengthOfLongestSubstring(int x, int y, int z, String s) {
        int balls = 0;
        int length = s.length();
        char charsArray[] = s.toCharArray();
        int Cr = 0, Cb = 0, Cy = 0;
        for (int i = 0; i < length; i++) {

            switch (charsArray[i]) {
                case 'R':
                    Cr++;
                    break;
                case 'B':
                    Cb++;
                    break;
                case 'Y':
                    Cy++;
                    break;
                default:
                    break;
            }
            if (Cr + Cb + Cy >= 3) {
                if (vanish(x, y, z, Cr, Cb, Cy)) {
                    balls = Math.max(balls, Cr + Cb + Cy);
                    Cr = 0;
                    Cb = 0;
                    Cy = 0;
                }
            }
        }
        balls = Math.max(balls, Cr + Cb + Cy);
        return balls;
    }

    private static boolean vanish(int x, int y, int z, int cr, int cy, int cb) {
        int xx = Math.abs(cr - cy);
        int yy = Math.abs(cy - cb);
        int zz = Math.abs(cr - cb);
        if (xx + yy + zz == x + y + z && xx * yy * zz == x * y * z) {
            return true;
        }
        return false;
    }
}
