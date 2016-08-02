/**
 * author : Jerry
 **/
package algorithm.sort.Tasks;

/**
 * Created by sooglejay on 16/8/1.
 */
public class Sort2_3_7 {
    public static void main(String[] args) {
        int data[] = new int[]{3, 2,7,8,1, 6,0, 4, 5, 6};
        System.out.print(test(data, 1));
    }

    public static boolean test(int data[], int sum) {
        int length = data.length;
        if (length < 1) {
            return false;
        }
        Merge(data, 0, length - 1);
        int S_[] = new int[length];

        //fix bug
        //if two elements must are different index of the array,then the code below is need
        int special = 0;
        int speData = 0;

        for (int i = 0; i < length; i++) {
            S_[i] = sum - data[i];
            if (S_[i] == data[i]) {

                //special code
                special += 1;
                speData = data[i];
            }
        }
        Merge(S_, 0, length - 1);

        int sK = 1;
        int tempS = S_[0];
        for (int i = 0; i < length; i++) {
            if (tempS != S_[i]) {
                S_[sK++] = S_[i];
            }
        }
        int sD = 1;
        int tempD = data[0];
        for (int i = 0; i < data.length; i++) {
            if (tempD != data[i]) {
                data[sD++] = data[i];
            }
        }

        int really = sD + sK;

        sD = 0;
        sK = 0;
        int m = 0;
        for (; m < really; m++) {
            if (sD == length || sK == length) {
                break;
            }
            if (S_[sK] > data[sD]) {
                sD++;
            } else if (S_[sK] < data[sD]) {
                sK++;
            } else {

                //special code
                if (special == 1 && speData == S_[sK]) {
                    continue;
                }


                return true;
            }
        }
        if (m == really) {
            return false;
        }
        return false;


    }

    public static void Merge(int A[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            Merge(A, p, q);
            Merge(A, q + 1, r);
            MergeSort(A, p, q, r);
        }
    }

    public static void MergeSort(int A[], int m, int s, int r) {
        int n1 = s - m + 1;
        int n2 = r - s;
        int L[] = new int[n1];
        int R[] = new int[n2];
        int i = 0;
        int j = 0;
        for (; i < n1; i++) {
            L[i] = A[m + i];
        }
        for (; j < n2; j++) {
            R[j] = A[j + s + 1];
        }
        i = j = 0;
        int k = m;
        while (k <= r) {
            if (i == n1 || j == n2) {
                break;
            }
            if (L[i] < R[j]) {
                A[k] = L[i];
                k++;
                i++;
            } else {
                A[k] = R[j];
                k++;
                j++;
            }
        }
        while (i < n1) {
            A[k++] = L[i++];
        }
        while (j < n2) {
            A[k++] = R[j++];
        }

    }
}
