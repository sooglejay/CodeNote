package leetCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class J1 {


    public static void main(String[] arg) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = simpleDateFormat.parse("2012-03-01");
//        long timeStemp = date.getTime();
//        System.out.println(timeStemp);

        int price[] = new int[]{0,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int r = test(price, 7);
        System.out.print(r);
    }


    public static int test(int price[], int n) {

        if (n == 0)
            return 0;
        int result = 0;
        for (int i = 1; i <=n; i++) {
            result = Math.max(result, price[i] + test(price, n - i));
        }
        return result;

    }

}
