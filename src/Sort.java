import leetCode.Print;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by sooglejay on 16/1/13.
 * <p/>
 * related sort algorithm
 */
public class Sort {
    public static void main(String[] args) {

        int a[] = new int[]{1,2,3,5,8,9,6,4,7};
        Print.print(a);
        heapSort(a);
        Print.print("\n  to see : \n");
        Print.print(a);

//        leetCode.Print.print(insertSort(a));
//        int a[8] = {3,1,5,7,2,4,9,6};

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
            a[i + 1] = key;//这里导论上写成 a[i+1]=key,但其实效果是一样的------->事实证明,这个说法是错误的,因为,这样写有个bug,若KEY 不是最小,就会发现,比如 45789 6,当前key是6,而a[0]=6,645789 显然不符合逻辑,应该是456789
            //我刚刚改过来,这个地方是一个
        }
        return a;
    }


    public static int[] heapSort(int a[]) {
        int length;
        if ((length = a.length) < 1) {
            return a;
        }
        a=buildMaxHeap(a);
        for (int i = length - 1; i > 0; i--) {
            exchange(a,0,i);
            a=maxHeap(a,0);
        }
        return a;
    }

    /**
     * build a max heap
     * @param a
     * @return
     */
    public static int[] buildMaxHeap(int a[]) {

        int length;
        if ((length = a.length) < 1) {
            return a;
        }
        for (int i = length / 2; i >= 0; i--) {
            a = maxHeap(a, i);
        }
        return a;
    }

    /**
     * Recursion to cause a max
     * @param a
     * @param i
     * @return
     */
    public static int[] maxHeap(int a[], int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left >= a.length || right >= a.length) {
            return a;
        }
        int large;
        if (a[i] < a[left]) {
            large = left;
        } else large = i;
        if (a[large] < a[right]) {
            large = right;
        }
        if (large != i) {
            a = exchange(a, i, large);
            return maxHeap(a, large);
        } else return a;
    }

    public static int[] exchange(int A[], int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
        return A;
    }

}
