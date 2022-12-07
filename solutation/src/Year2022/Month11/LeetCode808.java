package Year2022.Month11;

/**
 * https://leetcode.cn/problems/soup-servings/
 *
 * @author xuchenglong
 */
public class LeetCode808 {

    public static void main(String[] args) {
        System.out.println(0.62500 == soupServings(50));
        System.out.println(0.71875 == soupServings(100));
    }

    public static double soupServings(int n) {
        return 0d;
    }

    public static double soupServings1(int a, int b, double d) {
        a -= 100;
        if (a <= 0) {
            return d / 100 * 4;
        } else {
            return soupServings1(a, b, d / 100 * 4);
        }
    }

}
