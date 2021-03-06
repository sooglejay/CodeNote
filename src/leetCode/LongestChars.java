package leetCode;

import java.util.Date;

/**
 * Created by sooglejay on 16/1/11.
 * Given a string, find the length of the longest substring without repeating characters.
 * For example,
 * the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestChars {
    public static void main(String args[]) {
        System.out.print(longestLengthNumber("aa"));
    }

    public static int longestCharsNumber(String s) {
        long t1 = new Date().getTime();

        int length;
        if ((length = s.length()) < 2) {
            return length;
        }
        char arrayChars[] = s.toCharArray();
        char counter[] = new char[128];
        int aTail = 0, aMax = 0, aCount = 0;
        for (int i = 0; i < length; i++) {
            if (counter[arrayChars[i]] == 0) {
                counter[arrayChars[i]]++;
                if (++aCount > aMax) {
                    aMax = aCount;
                }
            } else {
                while (arrayChars[aTail] != arrayChars[i] && aTail < i && aTail < length) {
                    aCount--;
                    counter[arrayChars[aTail++]]--;
                }
                aTail++;
            }
        }
        long t2 = new Date().getTime();
        System.out.print("消耗时间:" + (t2 - t1));
        return aMax;
    }

    public static int longestCharsNumber2(String s) {
        long t1 = new Date().getTime();
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0;
        int proLocation = 1;
        int aftLocation = 1;
        int[] c = new int['~' - ' ' + 1];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (c[a - ' '] >= proLocation) {
                maxLength = maxLength < aftLocation - proLocation + 1 ? aftLocation - proLocation + 1 : maxLength;
                proLocation = c[a - ' '] + 1;
            }
            System.out.println("i=" + i + "  pro=" + proLocation + "  aft=" + aftLocation + "  c[" + a + "]=" + c[a - ' '] + " " + " max=" + maxLength);
            c[a - ' '] = i + 1;
        }
        maxLength = maxLength < aftLocation - proLocation + 1 ? aftLocation - proLocation + 1 : maxLength;
        long t2 = new Date().getTime();
        System.out.print("消耗时间:" + (t2 - t1));
        return maxLength;
    }


    public static int longestLengthNumber(String s) {

        long t1 = System.currentTimeMillis();
        int length;
        if ((length = s.length()) < 2) {
            return length;
        }
        int max = 0;
        int proLocation = 1;
        int array[] = new int[128];
        char ch;
        int i = 0;
        for (; i < length; i++) {
            ch = s.charAt(i);
            if(array[ch]>=proLocation)
            proLocation = proLocation > array[ch- ' '] ? proLocation : array[ch-' '];
            max = i - proLocation > max ? i - proLocation : max;
            array[ch-' '] = i;
        }
        long t2 = System.currentTimeMillis();
        max = i - proLocation > max ? i - proLocation : max;

        System.out.println("\n消耗时间:" + (t2 - t1));
        return max;
    }

}
