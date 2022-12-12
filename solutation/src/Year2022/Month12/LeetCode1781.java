package Year2022.Month12;

/**
 * https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/
 *
 * @author xuchenglong
 */
public class LeetCode1781 {

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }

    public static int beautySum(String s) {
        int returnValue = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int[] counts = new int[26];
                int max = 0;
                int min = s.length();
                for (int k = i; k <= j; k++) {
                    int count = counts[ss[k] - 'a'] + 1;
                    counts[ss[k] - 'a'] = count;
                }
                for (int count : counts) {
                    if (count > max) {
                        max = count;
                    }
                    if (count != 0 && count < min) {
                        min = count;
                    }
                }
                returnValue += max - min;
            }
        }
        return returnValue;
    }

}
