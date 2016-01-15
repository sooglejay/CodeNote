/**
 * Created by sooglejay on 16/1/15.
 */
public class Print {



    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            println(a[i]);
        }
    }

    public static void print(int a) {
        System.out.print(a);
    }

    public static void println(int a) {
        System.out.println(a);
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void print(String string) {
        System.out.print(string);
    }


    static void ShellInsertSort(int a[], int n, int dk)
    {
        for(int i= dk; i<n; ++i){
            if(a[i] < a[i-dk]){          //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j = i-dk;
                int x = a[i];           //复制为哨兵，即存储待排序元素
                a[i] = a[i-dk];         //首先后移一个元素
                while(j+dk<a.length&&x < a[j]){     //查找在有序表的插入位置
                    a[j+dk] = a[j];
                    j -= dk;             //元素后移
                }
                a[j+dk] = x;            //插入到正确位置
            }
            print(a, n,i );
        }

    }

    /**
     * 先按增量d（n/2,n为要排序数的个数进行希尔排序
     *
     */
    static void shellSort(int a[], int n){

        int dk = n/2;
        while( dk >= 1  ){
            ShellInsertSort(a, n, dk);
            dk = dk/2;
        }
    }
    static void print(int a[], int n ,int i){
        print(i+":");
        for(int j= 0; j<8; j++){
            print(a[j] +" ");
        }
        println("");

    }

}
