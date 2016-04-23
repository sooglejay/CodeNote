/**
 * author : Jerry
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import static sun.security.pkcs11.wrapper.Functions.toBinaryString;

/**
 * Created by sooglejay on 4/6/16.
 */
public class Main {
    public static void main(String[] args) {
//        te();
//        System.out.print("" + getIpAddressBinaryStr("1.2.3.4"));
        String string = "allow 1.2.3.4/30";
        string = string.replace("allow ", "");
        String ipStr = string.split("\\/")[0];
        System.out.print("" + getIpAddressBinaryStr(ipStr));

    }

    public static void te() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
//        int M = scanner.nextInt();
        List<Integer> allowList = new ArrayList<>();
        while (0 < N--) {
            String string = scanner.next();
            string = string.replace("allow ", "");
            String ipStr = string.split("\\/")[0];
            System.out.print("" + getIpAddressBinaryStr(ipStr));
        }


    }


    public static String getIpAddressBinaryStr(String ip) {
        StringBuilder ipAddressBinaryStr = new StringBuilder();
        String array[] = ip.split("\\.");
        int ip1 = Integer.valueOf(array[0] + "");
        int ip2 = Integer.valueOf(array[1] + "");
        int ip3 = Integer.valueOf(array[2]);
        int ip4 = Integer.valueOf(array[3]);
        ipAddressBinaryStr.append(addZero(toBinaryString(ip1)));
        ipAddressBinaryStr.append(addZero(toBinaryString(ip2)));
        ipAddressBinaryStr.append(addZero(toBinaryString(ip3)));
        ipAddressBinaryStr.append(addZero(toBinaryString(ip4)));
        return ipAddressBinaryStr.toString();
    }

    public static String addZero(String string) {
        int length = 8 - string.length();
        StringBuilder zero = new StringBuilder();
        while (length > 0) {
            zero.append("0");
            length--;
        }
        return zero.toString() + string;
    }
}
