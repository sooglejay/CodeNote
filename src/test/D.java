/**
 * author : Jerry
 **/
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sooglejay on 4/20/16.
 */
public class D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            getN(n, m);
        }
    }

    public static void getN(int n, int m) {
        List<Integer> result = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            if (is(i)) {
                result.add(i);
            }
        }
        if (result.size()<1){
            System.out.print("no");
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    public static boolean is(int n) {
        int i = n;
        int sum = 0;
        while (i > 0) {
            int temp = i % 10;
            sum += (int) Math.pow(temp, 3);
            i = i / 10;
        }
        if (sum == n) return true;
        return false;
    }
}
