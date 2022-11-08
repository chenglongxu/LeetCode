package Year2022.Month10;

/**
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 *
 * @author xuchenglong
 */
public class LeetCode1684 {

    public static void main(String[] args) {
        System.out.println(2 == countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println(7 == countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(4 == countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));

    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int returnValue = 0;
        for (String word : words) {
            boolean consistent = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowed.contains(String.valueOf(word.charAt(i)))) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                returnValue++;
            }
        }
        return returnValue;
    }

}
