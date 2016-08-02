/**
 * author : Jerry
 **/
package algorithm.sort.Test;

/**
 * Created by sooglejay on 16/8/2.
 */
public class Del {
    public static void main(String[] args) {
        int data[] = new int[]{2, 2, 3, 1};
//        int A[] = mergeMaxLengthSubArray(data, 0, data.length - 1);
        data = fastSort(data, 0, data.length - 1);
        for (int a : data) {
            System.out.print(a + " ");
        }
    }

    public static void BubbleSort(int data[]) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = data.length - 1; j > i; j--) {
                if (data[j] < data[i]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public static void InsertSort(int data[]) {
        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            int key = data[i];
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    public static void mergeSort(int data[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(data, p, q);
            mergeSort(data, q + 1, r);
            merge(data, p, q, r);
        }

    }

    public static void merge(int data[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;
        int L[] = new int[n1];
        int R[] = new int[n2];
        int i = 0, j = 0, k = p;
        for (; i < n1; i++) {
            L[i] = data[i + p];
        }
        for (; j < n2; j++) {
            R[j] = data[j + q + 1];
        }
        i = j = 0;
        while (k < r) {
            if (L[i] < R[j]) {
                data[k++] = L[i++];
            } else {
                data[k++] = R[j++];
            }
            if (i == n1 || j == n2) {
                break;
            }
        }
        while (i < n1) {
            data[k++] = L[i++];
        }
        while (j < n2) {
            data[k++] = R[j++];
        }

    }

    public static int[] mergeMaxLengthSubArray(int data[], int low, int high) {
        int left, right, sum;
        if (low == high) {
            sum = data[low];
            right = left = low;
            return new int[]{left, right, sum};
        }

        int mid = (low + high) / 2;
        int lA[] = mergeMaxLengthSubArray(data, low, mid);
        int rA[] = mergeMaxLengthSubArray(data, mid + 1, high);
        int mA[] = maxLengthSubArray(data, low, mid, high);
        if (lA[2] > rA[2] && lA[2] > mA[2]) {
            return lA;
        } else if (rA[2] > lA[2] && rA[2] > mA[2]) {
            return rA;
        } else {
            return mA;
        }

    }

    public static int[] maxLengthSubArray(int data[], int low, int mid, int high) {

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        int leftI = 0;
        int rightI = 0;

        int sum = 0;
        int index = mid;
        while (index >= low) {
            sum = sum + data[index];
            if (sum > 0 && sum > leftSum) {
                leftSum = sum;
                leftI = index;
            }
            index--;
        }

        sum = 0;
        index = mid + 1;
        while (index <= high) {
            sum = sum + data[index];
            if (sum > 0 && sum > rightSum) {
                rightSum = sum;
                rightI = index;
            }
            index++;
        }
        return new int[]{leftI, rightI, (leftSum + rightSum)};

    }


    public static int[] fastSort(int data[], int low, int high) {
        if (low >= high) {
            return data;
        }
        int start = data[low];
        int i = low, j = high;
        int temp;
        while (i < j) {
            //fix bug   >= not >
            while (data[j] >= start && i < j) {
                j--;
            }
            //fix bug   >= not >
            while (data[i] <= start && i < j) {
                i++;
            }
            if (i < j) {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        data[low] = data[i];
        data[i] = start;

        fastSort(data, low, i);
        fastSort(data, i + 1, high);
        return data;

    }

}
