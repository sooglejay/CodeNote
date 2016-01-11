import java.util.Scanner;

/**
 * Created by sooglejay on 16/1/11.
 */
public class StringProblem {
    public static void main(String args[]) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        String nA[] = new String[N];
        String mA[] = new String[M];
        generateStringArray(N, scanner, 0, nA);
        generateStringArray(M, scanner, 0, mA);
        function(nA,mA,N,M);

    }

    private static void generateStringArray(int n, Scanner scanner, int temp, String[] nArray) {
        while (scanner.hasNext()) {
            nArray[temp] = scanner.next();
            temp++;
            if (temp >= n) {
                break;
            }
        }
    }

    public static void function(String[] nA, String[] mA, int N, int M) {
        int count[] = new int[M];
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                int temp = 0;
                for (int k = 0; k < mA[m].length(); k++) {
                    if (nA[n].contains(mA[m].charAt(k) + "")) {
                        temp++;
                        if (temp > 0 && temp>=mA[m].length() - 1) {
                            count[m]++;
                            break;
                        }
                    }

                }

            }

        }
        for (int p = 0; p < M; p++) {
            System.out.println(count[p]);
        }
    }
}
