package Year2023.Month02;

/**
 * https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 *
 * @author xuchenglong
 */
public class LeetCode1234 {

    public static void main(String[] args) {
        System.out.println(balancedString("QWER") == 0);
        System.out.println(balancedString("QQWE") == 0);
        System.out.println(balancedString("QQQW") == 0);
        System.out.println(balancedString("QQQQ") == 0);
    }

    public static int balancedString(String s) {
        int qNumber = 0;
        int wNumber = 0;
        int eNumber = 0;
        int rNumber = 0;
        char[] ss = s.toCharArray();
        for (char c : ss) {
            if ('Q' == c) {
                qNumber++;
            } else if ('W' == c) {
                qNumber++;
            } else if ('E' == c) {
                qNumber++;
            } else if ('R' == c) {
                qNumber++;
            }
        }
        int qDifference = qNumber - s.length() / 4;
        int wDifference = wNumber - s.length() / 4;
        int eDifference = eNumber - s.length() / 4;
        int rDifference = rNumber - s.length() / 4;
        return 0;
    }

}
