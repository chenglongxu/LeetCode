package Year2023.Month04;

/**
 * https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/description/
 *
 * @author xuchenglong
 */
public class LeetCode1147 {

    public static void main(String[] args) {
        System.out.println(longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(longestDecomposition("merchant"));
        System.out.println(longestDecomposition("antaprezatepzapreanta"));
        System.out.println(longestDecomposition("aaa"));
    }

    public static int longestDecomposition(String text) {
        int returnValue = 0;
        char[] chars = text.toCharArray();
        int leftCursor = 0;
        int rightCursor = text.length() - 1;
        StringBuilder lsb = new StringBuilder();
        String rs = "";
        while (leftCursor < rightCursor) {
            lsb.append(chars[leftCursor]);
            rs = chars[rightCursor] + rs;
            leftCursor++;
            rightCursor--;
            if (lsb.toString().equals(rs)) {
                returnValue += 2;
                lsb = new StringBuilder();
                rs = "";
            }
        }
        if (!rs.equals("") || leftCursor == rightCursor) {
            returnValue++;
        }
        return returnValue;
    }

}
