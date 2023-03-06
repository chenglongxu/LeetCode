package Year2023.Month03;

/**
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/solutions/
 *
 * @author xuchenglong
 */
public class LeetCode1653 {

    public static void main(String[] args) {
        System.out.println(2 == minimumDeletions("aababbab"));
        System.out.println(2 == minimumDeletions("bbaaaaabb"));
        System.out.println(0 == minimumDeletions("b"));
    }

    public static int minimumDeletions(String s) {
        int rightA = 0;
        int leftB = 0;
        char[] ss = s.toCharArray();
        for (char c : ss) {
            if (c == 'a') {
                rightA++;
            }
        }
        int returnValue = rightA;
        for (char c : ss) {
            if (c == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            returnValue = Integer.min(returnValue, rightA + leftB);
        }
        return returnValue;
    }

}
