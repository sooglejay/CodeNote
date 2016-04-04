/**
 * author : Jerry
 **/

import leetCode.Print;

/**
 * Created by sooglejay on 4/2/16.
 * Heap Sort Steps:
 * 1) build a totally max heap in the array
 * 2) then exchange the first element with the last one in the array
 * 3),re-sort the array with max heap algorithm with index at zero
 * 4) repeat 2-3 steps in the whole,of array,
 *
 * the main idea is Binary Tree

 */
public class HeapSort {

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,5,8,9,6,4,7};
        Print.print(a);
        heapSort(a);
        Print.print("\n  to see : \n");
        Print.print(a);


    }
    /**
     * @param a
     * @param i
     * @return
     */
    public static void maxHeap(int a[], int i) {
        int left = 2 * i + 1;//because index start at zero,so the left son of zero is number one
        int right = 2 * i + 2;
        if (left >= a.length || right >= a.length) return;
        int large = a[left] > a[i] ? left : i;//get the index of  biggest value among index of i,left_son,right_son in array
        large = a[right] > a[large] ? right : large;
        if (large != i) {
            exchange(a, large, i);
            maxHeap(a, large);
        }
    }

    public static void exchange(int A[], int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void buildMaxHeap(int a[]) {
        int length;
        if ((length = a.length) < 1) {
            return;
        }
        for (int i = length / 2; i >= 0; i--) {
            maxHeap(a,i);
        }
    }
    public static void heapSort(int a[]){
        int length;
        if ((length = a.length) < 1) {
            return;
        }
        buildMaxHeap(a);
        for (int i = length-1; i >= 0; i--) {
            exchange(a,0,i);
            maxHeap(a,0);
        }
    }
}
