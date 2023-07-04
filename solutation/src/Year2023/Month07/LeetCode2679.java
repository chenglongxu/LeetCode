package Year2023.Month07;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sum-in-a-matrix/
 *
 * @author xuchenglong
 */
public class LeetCode2679 {

    public static void main(String[] args) {
        System.out.println(matrixSum(new int[][]{new int[]{7, 2, 1}, new int[]{6, 4, 2}, new int[]{6, 5, 3}, new int[]{3, 2, 1}}));
    }

    public static int matrixSum(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int returnValue = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int max = 0;
            for (int[] num : nums) {
                max = Integer.max(num[i], max);
            }
            returnValue += max;
        }
        return returnValue;
    }

}
