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
        System.out.print(longestCharsNumber("abaac"));
    }

    public static int longestCharsNumber(String s) {
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
        return aMax;
    }

}
