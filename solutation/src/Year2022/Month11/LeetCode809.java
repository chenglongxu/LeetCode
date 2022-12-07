package Year2022.Month11;

/**
 * https://leetcode.cn/problems/soup-servings/
 *
 * @author xuchenglong
 */
public class LeetCode809 {

    public static void main(String[] args) {
        System.out.println(1 == expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    public static int expressiveWords(String s, String[] words) {
        char[] chars = new char[s.length()];
        int[] counts = new int[s.length()];
        int cursor = -1;
        char before = '`';
        for (int i = 0; i < s.length(); i++) {
            if (before != s.charAt(i)) {
                cursor++;
                before = s.charAt(i);
                chars[cursor] = before;
            }
            counts[cursor] = counts[cursor] + 1;
        }
        for (String word : words) {
            char[] targetChars = new char[s.length()];
            int[] targetCounts = new int[s.length()];
            cursor = -1;
            before = '`';
            for (int i = 0; i < s.length(); i++) {
                if (before != s.charAt(i)) {
                    if (targetCounts[cursor]>counts[cursor]){

                    }
                    cursor++;
                    before = s.charAt(i);
                    targetChars[cursor] = before;
                }
                targetCounts[cursor] = targetCounts[cursor] + 1;
            }
        }
        return 0;
    }

}
