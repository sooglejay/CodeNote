/**
 * author : Jerry
 **/
package algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by sooglejay on 16/8/3.
 */
public class Kth {
    public static void main(String[] args) {

//        int data[] = new int[]{4, 3, 10, 5, 2, 9, 8, 6, 2, 1, 2, 3};
//        heapSort(data);
//        for (int a : data) {
//            System.out.print(a + "  ");
//        }
        int matrix[][] = {
                {1, 2},
                {1, 3},
        };
        for (int a[] : matrix) {
            System.out.print("\n");
            for (int b : a) {
                System.out.print(b + "  ");
            }
        }
        System.out.print("\n " + test(matrix, 2));
    }

    public static int test(int matrix[][], int k) {
        int r = matrix.length;
        if (r < 1 || k > r * r) {
            return 0;
        }
        int B[] = new int[r * r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                B[i * r + j] = matrix[i][j];
            }
        }
        Arrays.sort(B);
        return B[k - 1];
    }


}
