/**
 * author : Jerry
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sooglejay on 4/6/16.
 */
public class Course {
    public static void main(String[] args) {
        te();
    }

    public static void te() {
        Scanner scanner = new Scanner(System.in);
        int testCasesCount = scanner.nextInt();
        List<Integer> resultList = new ArrayList<>();

        List<Integer> charactersList = new ArrayList<>();
        while (0 < testCasesCount--) {
            charactersList.clear();

            int N = scanner.nextInt();
            int P = scanner.nextInt();
            int W = scanner.nextInt();
            int H = scanner.nextInt();

            for (int i = 0; i < N; i++) {
                charactersList.add(scanner.nextInt());
            }
            resultList.add(al(N, P, W, H, charactersList));

        }
        for (Integer result : resultList) {
            System.out.println(result);
        }
    }

    public static int al(int n, int p, int w, int h, List<Integer> charactersList) {
        return (int)Math.sqrt((p*w*h)/sum(charactersList));
    }

    public static int sum(List<Integer> integerList) {
        int result = 0;
        for (Integer integer : integerList) {
            result = result+integer;
        }
        return result;
    }
}
