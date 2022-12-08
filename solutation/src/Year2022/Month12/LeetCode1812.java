package Year2022.Month12;

/**
 * https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 *
 * @author xuchenglong
 */
public class LeetCode1812 {

    public static void main(String[] args) {
        System.out.println(squareIsWhite("a1"));
        System.out.println(squareIsWhite("h3"));
        System.out.println(squareIsWhite("c7"));
    }

    public static boolean squareIsWhite(String coordinates) {
        char a = coordinates.charAt(0);
        char b = coordinates.charAt(1);
        int sum = a - 'a' + b - 1;
        return sum % 2 == 1;
    }

}
