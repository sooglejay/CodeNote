/**
 * author : Jerry
 **/

import leetCode.Print;

import static java.util.Arrays.sort;

/**
 * Created by sooglejay on 4/2/16.
 */
public class FastSort {
    public static void main(String[] args) {
        int a[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        Print.print(a);
        fastSort(a, 0, 8);
        Print.print("\n  to see :\n");
        Print.print(a);
    }


    public static void fastSort(int a[], int left, int right) {
        int i = left;
        int j = right;
        if (right >= a.length || left >= a.length || right <= 0) return;
        while (i != j) {
            if (a[left] < a[j]) {
                j--;
                continue;
            }
            if (a[left] < a[i]) {
                i++;
                continue;
            }
            if (a[j] < a[i]) {
                HeapSort.exchange(a, i, j);
            }
        }
        if (a[left] < a[i]) {
            HeapSort.exchange(a, left, j);
        }

        if (i < right) {
            fastSort(a, i+1, right);
        }
        if (j > left) {
            fastSort(a, left, j-1);
        }


    }


}
