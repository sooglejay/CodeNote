/**
 * author : Jerry
 **/
package algorithm.sort;

/**
 * Created by sooglejay on 16/8/3.
 */
public class HeapSort {
    public static void main(String[] args) {

        int data[] = new int[]{4, 3, 10, 5, 2, 9, 8, 6, 2, 1, 2, 3};
        heapSort(data);
        for (int a : data) {
            System.out.print(a + "  ");
        }
    }

    public static void heapSort(int data[]) {

        int temp = 0;
        int heap_size = data.length;
        maxHeap(data);
        for (int i = data.length - 1; i >= 0; i--) {
            temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            heap_size--;
            //fix bug : 之所以是从0开始重新维护最大堆性质,而不用再次调用maxHeap
            //原因就是,我们在最开始已经调用了maxHeap,接下来只是把第一个和最后一个元素
            //的位置调换一下,也就是说,第一个元素由于是最大的,我们需要把它放到后面去.
            //但是调换了首尾元素后,有可能破坏了最大堆性质,并且,破坏的永远只是根元素的最大堆性质
            //所以,维护最大堆性质时,我们永远也只需要传第一个元素的下标即可.
            buildMaxHeap(data, heap_size, 0);
        }
    }

    public static void buildMaxHeap(int data[], int heap_size, int i) {
        int left = 2 * i + 1;
        int right = left + 1;
        int large = i;

        if (left < heap_size && data[large] < data[left]) {
            large = left;
        }
        if (right < heap_size && data[large] < data[right]) {
            large = right;
        }
        if (large != i) {
            int temp = data[i];
            data[i] = data[large];
            data[large] = temp;
            buildMaxHeap(data, heap_size, large);
        }
    }

    public static void maxHeap(int data[]) {
        for (int i = data.length / 2; i >= 0; i--) {
            buildMaxHeap(data, data.length, i);
        }

    }
}
