package Year2023.Month04;

/**
 * https://leetcode.cn/problems/partition-array-for-maximum-sum/
 *
 * @author xuchenglong
 */
public class LeetCode1403 {

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] pre = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            int currentMax = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                pre[i] = Integer.max(pre[i], pre[j] + currentMax * (i - j));
                if (j > 0) {
                    currentMax = Integer.max(currentMax, arr[j - 1]);
                }
            }
        }
        return pre[arr.length];
    }

}
