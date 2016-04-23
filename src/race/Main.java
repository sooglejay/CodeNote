/**
 * author : Jerry
 **/
package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test {
}

public class Main {
    public static void main(String args[]) {
//        System.out.print(al("R22C54"));
        Scanner cin = new Scanner(System.in);
        List<String>result = new ArrayList<>();

        String key = cin.next();
        key=key.replace("(","").replace(")","");
        int count = key.length();
        while (count-->0){
            int a = cin.nextInt();
            int b = cin.nextInt();

        }
        for (String s:result){
            System.out.print(s);
        }
    }

    public static String al(String key) {

        char f = key.charAt(0);
        StringBuilder stringBuilder = new StringBuilder();
        int row = 0;
        int col = 0;
        if (f == 'R') {

            Pattern p = Pattern.compile("[0-9\\.]+");
            Matcher m = p.matcher(key);
            int t = 0;
            while (m.find()) {
                if (t == 0) {
                    row = Integer.valueOf(m.group());
                } else {
                    col = Integer.valueOf(m.group());
                }
                t++;

            }
            int i1 = col / 26;
            int i2 = col % 26;
            char ch1 =  (char) (i1 - 1 + 'A');
            char ch2 =  (char) (i2 - 1 + 'A');
            stringBuilder.append("" +ch1);
            stringBuilder.append("" +ch2);

            stringBuilder.append(row);
        } else {

            Pattern p = Pattern.compile("[0-9\\.]+");
            Matcher m = p.matcher(key);
            while (m.find()) {
                row = Integer.valueOf(m.group());
            }
            key = key.replace("" + row, "");

            int t = 0;
            for (int i = key.length() - 1; i >= 0; i--) {
                char ch = key.charAt(i);
                if (t>0) {
                    col += ch - 'A' + (t+1) * 26;
                }else {
                    col += ch - 'A' + t * 26;
                }
                t++;
            }

            stringBuilder.append("R" + row + "C" + col);

        }

        return stringBuilder.toString();
    }
}
