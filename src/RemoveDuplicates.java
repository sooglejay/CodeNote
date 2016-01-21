/**
 * Created by sooglejay on 16/1/12.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.print(isAnagram("aabcdeaaa","aa"));

    }

    /***
     * 使用两个下标,i,j,i做遍历,j做新数组长度
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n;
        if ((n = nums.length) < 1) {
            return n;
        }
        int j = 0;
        int num = 0;
        for (int i = 1; i < n; i++) {
            if (nums[j] == nums[i]) {
                num++;
                if (num < 2) {//超过两个就不管了,
                    nums[++j] = nums[i];
                }
            } else {//把剩下的都往前面搬
                nums[++j] = nums[i];
                num = 0;
            }
        }
        return j + 1;
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        Print.println("array :S\n");

        for (char c : s.toCharArray()) {
            table[c - 'a']++;
            Print.println(c+"");
        }
           Print.println("array :T\n");
           for (char c : t.toCharArray()) {
               Print.println(c+"");
               table[c - 'a']--;
               if (table[c - 'a'] < 0) return false;
           }
           return true;

    }
}
