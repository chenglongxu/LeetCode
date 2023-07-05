package Year2023.Month07;

/**
 * https://leetcode.cn/problems/k-items-with-the-maximum-sum/
 *
 * @author xuchenglong
 */
public class LeetCode2600 {

    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(3, 2, 0, 2));
        System.out.println(kItemsWithMaximumSum(3, 2, 0, 4));
    }

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k < numOnes) {
            return k;
        }
        if (k < numOnes + numZeros) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }

}
