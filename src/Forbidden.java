/**
 * author : Jerry
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sun.security.pkcs11.wrapper.Functions.toBinaryString;

/**
 * Created by sooglejay on 4/6/16.
 */
public class Forbidden {
    public static void main(String[] args) {
        te();
    }

    public static void te() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<String> allowList = new ArrayList<>();
        List<String> denyList = new ArrayList<>();
        List<String> ipList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        while (0 < N--) {
            String string = scanner.next();
            StringBuilder ipWithMask = new StringBuilder();
            if (string.equals("allow")) {
                ipWithMask.append(scanner.next());
                String array[] = ipWithMask.toString().split("\\/");
                StringBuilder allowBinarry = new StringBuilder();

                String ipString = getIpAddressBinaryStr(array[0]);
                if (array.length == 1) {
                    allowBinarry.append(ipString);
                } else {
                    int maskLength = Integer.valueOf(array[1]);
                    String networkString = networkString(ipString,maskLength);
                   allowBinarry.append(networkString);
                }
                allowList.add(allowBinarry.toString());

            }else {
                ipWithMask.append(scanner.next());
                String array[] = ipWithMask.toString().split("\\/");
                StringBuilder denyBinnry = new StringBuilder();

                String ipString = getIpAddressBinaryStr(array[0]);
                if (array.length == 1) {
                    denyBinnry.append(ipString);
                } else {
                    int maskLength = Integer.valueOf(array[1]);
                    String networkString = networkString(ipString,maskLength);
                    denyBinnry.append(networkString);
                }
                denyList.add(denyBinnry.toString());
            }
        }


        while (0<M--){
            String ipString = scanner.next();
            ipList.add(ipString);
        }
        for (String ipString :ipList){
            for (String ipDeny:denyList){
                if (getIpAddressBinaryStr(ipString).contains(ipDeny)){
                    resultList.add("NO");
                    break;
                }
            }
             for (String ipDeny:allowList){
                if (getIpAddressBinaryStr(ipString).contains(ipDeny)){
                    resultList.add("YES");
                    break;
                }
            }

        }

        for(String result:resultList){
            System.out.println(result);
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

    public static String addMaskZero(int bitCount, boolean addZero) {
        StringBuilder stringBuilder = new StringBuilder();
        while (0 < bitCount--) {
            stringBuilder.append(!addZero?"1":"0");
        }

        int length = stringBuilder.toString().length();
        for (int i = length; i <32; i++) {
            stringBuilder.append(addZero?"0":"1");
        }
        return stringBuilder.toString();
    }

    public static String networkString(String ip1,int bitCount){
        StringBuilder stringBuilder = new StringBuilder();
        if (bitCount==0){
            stringBuilder.append(addMaskZero(32,true));
            return stringBuilder.toString();
        }
        else {
            int i=0;
            for (;i<bitCount;i++){
                if (i<ip1.length()){
                    stringBuilder.append(ip1.charAt(i));
                }
            }

        }
        return stringBuilder.toString();
    }
}
