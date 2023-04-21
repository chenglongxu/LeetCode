package Year2023.Month04;

/**
 * https://leetcode.cn/problems/smallest-even-multiple/solutions/
 *
 * @author xuchenglong
 */
public class LeetCode2413 {

    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(6));
    }

    public static int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }

}
