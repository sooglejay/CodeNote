import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by sooglejay on 16/1/13.
 * <p/>
 * related sort algorithm
 */
public class Sort {
    public static void main(String[] args) {

        int a[] = new int[]{9, 1, 2, 3, 4, 5, 6};
//        print(chooseSort(a));
//        int a[8] = {3,1,5,7,2,4,9,6};
        //ShellInsertSort(a,8,1); //直接插入排序
        shellSort(a,8);           //希尔插入排序
        print(a,8,8);
    }

    /**
     * 选择排序,时间复杂度是 O(N^2) = N*(N+1)/2
     *
     * @param a
     * @return
     */
    public static int[] chooseSort(int a[]) {
        int min = 0;
        int length = a.length;
        if (length < 1) {
            return a;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[i]) {
                    min = a[j];
                    a[j] = a[i];
                    a[i] = min;
                }
            }
        }
        return a;

    }

    public static int[] insertSort(int[] a) {
        if (a.length < 2) {
            return a;
        }
        for (int j = 1; j < a.length; j++) {
            int i = j - 1;//减去1是因为需要移位的 数字序列永远是在当前操作 下标j的后面一个开始,依次往后到第一个元素,这个序列可能会移位
            int key = a[j];
            while (i >= 0 && a[i] > key)//下面是移位的操作
            {
                a[i + 1] = a[i];//把后面的数字,若满足条件就继续向前移动一位
                i--;
            }
            a[i+1] = key;//这里导论上写成 a[i+1]=key,但其实效果是一样的------->事实证明,这个说法是错误的,因为,这样写有个bug,若KEY 不是最小,就会发现,比如 45789 6,当前key是6,而a[0]=6,645789 显然不符合逻辑,应该是456789
            //我刚刚改过来,这个地方是一个
        }
        return a;
    }

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
