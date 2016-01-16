/**
 * Created by sooglejay on 16/1/16.
 */
public class ShellSort {
    public static void main(String[] args) {

        int a[] = new int[]{9, 1, 2, 3, 1, 5, 6};
//        Print.print(insertSort(a));
//        int a[8] = {3,1,5,7,2,4,9,6};
        ShellInsertSort(a,a.length,1); //直接插入排序

    }

    static void ShellInsertSort(int a[], int n, int dk) {
        for (int i = dk; i < n; i++) {
            if (i > 0 && i - dk >= 0 &&i-dk<n&& a[i] < a[i - dk]) {          //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j = i - dk;
                int x = a[i];           //复制为哨兵，即存储待排序元素
                a[i] = a[i - dk];         //首先后移一个元素
                while (j + dk < a.length &&j>=0&& x < a[j]) {     //查找在有序表的插入位置
                    a[j + dk] = a[j];
                    j -= dk;             //元素后移
                }
                a[j + dk] = x;            //插入到正确位置
            }
        }
        Print.println(a);


    }

    /**
     * 先按增量d（n/2,n为要排序数的个数进行希尔排序
     */
    static void shellSort(int a[], int n) {

        int dk = n / 2;
        while (dk >= 1) {
            ShellInsertSort(a, n, dk);
            dk = dk / 2;
        }
    }
}
