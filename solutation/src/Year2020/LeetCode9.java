package Year2020;

public class LeetCode9 {

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int[] offsets = new int[matrix.length];
            int minValue = matrix[0][0];
            int maxValue = matrix[matrix.length - 1][matrix.length - 1];
            while (k > 0) {
                int nextValue = maxValue;
                int line = matrix.length - 1;
                for (int i = 0; i < matrix.length; i++) {
                    int offset = offsets[i];
                    if (matrix[i].length > offset) {
                        int value = matrix[i][offset];
                        if (value < nextValue) {
                            nextValue = value;
                            line = i;
                        }
                    }
                }
                offsets[line] = offsets[line] + 1;
                minValue = nextValue;
                k--;
            }
            return minValue;
        }
    }

}
