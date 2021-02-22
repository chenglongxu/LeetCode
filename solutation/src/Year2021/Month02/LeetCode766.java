package Year2021.Month02;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class LeetCode766 {

    public static void main(String args[]) {
        System.out.println(Solution.isToeplitzMatrix(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 1, 2, 3}, new int[]{9, 5, 1, 2}}));
    }

    static class Solution {
        public static boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i > 0 && j > 0) {
                        if (matrix[i][j] != matrix[i - 1][j - 1]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

}
