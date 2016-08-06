/**
 * author : Jerry
 **/
package algorithm.Poj;

import java.util.Scanner;

/**
 * Created by sooglejay on 16/8/5.
 */
public class Exponentiation {

    public static void main(String args[]) {
        String mine;
        String others;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            int count = scanner.nextInt();
//            mine = func(input, count);
//            System.out.println(mine);

            others = funcOthers(input, count);
            System.out.println(others);
        }
    }

    public static String func(String input, int count) {
        String newStr = input.replace(".", "");
        int len = newStr.length();

        int cc = (len - input.indexOf(".")) * count;
        if (!input.contains(".")) {
            cc = 0;
        }
        int B[] = new int[len];

        int zeroCount = 0;
        for (int i = 0; i < len; i++) {
            B[len - i - 1] = newStr.charAt(i) - '0';
            if (B[len - i - 1] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == len) {
            return "0";
        }
        int a[] = B;
        while (count-- > 1) {
            a = mul(a, B);
        }
        int jj = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 0) {
                jj++;
                continue;
            } else {
                break;
            }
        }
        boolean flag = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length - 1; i >= jj; i--) {

            if (i == cc - 1) {
                stringBuilder.append(".");
            }
            if (a[a.length - 1] == 0 && flag) {
                flag = false;
                continue;
            }
            stringBuilder.append(a[i] + "");
        }
        return stringBuilder.toString();

    }

    public static int[] mul(int a[], int b[]) {
        int A[] = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                A[i + j] += a[i] * b[j];
                if (A[i + j] >= 10) {
                    A[i + j + 1] += A[i + j] / 10;
                    A[i + j] %= 10;
                }
            }
        }
        if (A[A.length - 1] > 0) {
            return A;
        } else {
            int r[] = new int[A.length - 1];
            for (int i = A.length - 2; i >= 0; i--) {
                r[i] = A[i];
            }
            return r;
        }
    }


    static int len; // total length of exponentiation result
    static int product[] = new int[126]; // storing result, at most length 5*25 + 1 = 126


    static void multiply(int a[], int inputNumber) {
        int i;
        int carry = 0; // a carry number in multiplying
        for (i = 0; i < len; i++) {
            int temp = a[i] * inputNumber + carry;
            a[i] = temp % 10;
            carry = temp / 10;
        }
        while (carry > 0) {
            a[i++] = carry % 10;
            carry /= 10;
        }
        len = i;
    }

    public static String funcOthers(String input, int count) {
        int position = 0, i = 0, num = 0, j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                position = (input.length() - 1 - i) * count; // calculate decimal point position after R^count
            } else {
                //确实好算法,每次输入一个数字,都进行下面的处理,就可以得到输入的数字字符串的数值了.
                num = num * 10 + input.charAt(i) - 48; // transfer float to integer
            }
        }

        // product calculation
        product[0] = 1;
        len = 1;
        for (i = 0; i < count; i++) {
            multiply(product, num);
        }

        // format output
        if (len <= position) // product is less than 1
        {
            System.out.print(".");
            for (i = 0; i < position - len; i++) {
                stringBuilder.append("0");
            }

            j = 0;
            //while (product[j] == 0) // trim trailing zeros
            //{
            //    j++;
            //}
            for (i = len - 1; i >= j; i--) {
                stringBuilder.append("" + product[i]);
            }
        } else {
            j = 0;
            while (product[j] == 0 && j < position) // trim trailing zeros
            {
                j++;
            }
            for (i = len - 1; i >= j; i--) {
                if (i + 1 == position) // cause index in C language starts from 0
                {
                    stringBuilder.append(".");
                }
                stringBuilder.append("" + product[i]);
            }
        }
        return stringBuilder.toString();
    }
}
