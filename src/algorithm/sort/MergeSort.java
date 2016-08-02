/**
 * author : Jerry
 **/
package algorithm.sort;

/**
 * Created by sooglejay on 16/8/1.
 */
public class MergeSort {
    public static void main(String[] args) {

        int A[] = new int[]{1, 2,10,11,22, 3, 4, 5, 1, 2, 3};
        mergeSort(A, 0, A.length - 1);
        for (int a : A) {
            System.out.print(a + " ");
        }

        //fix bug : int[] is instanceof Object
        //is true as syntax
        System.out.print(A instanceof Object);
        int test = 100;
// you will get error if you execute the Commented-Out Code
// System.out.print(test instanceof Object);

    }

    public static void mergeSort(int A[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int A[], int m, int s, int r) {
        int n1 = s - m + 1;
        int n2 = r - s;
        int L[] = new int[n1];
        int R[] = new int[n2];

        int i = 0;
        for (; i < n1; i++) {
            L[i] = A[i + m];//last element is A[n1-1+m=s]
        }
        int j = 0;
        for (; j < n2; j++) {
            R[j] = A[j + s + 1];//last element is A[n2-1+s+1]=A[r]
        }
        //fix bug
        i = 0;
        j = 0;//you have to reset the index of L and R

        //fix bug
        int k = m;//please note here, k=m not k=A.length
        for (; k <= r; k++) {
            if (i == n1 || j == n2) {
                break;
            }
            if (L[i] < R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }

    }

}
