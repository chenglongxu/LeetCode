public class LeetCode718 {

    class Solution {
        public int findLength(int[] A, int[] B) {
            int AB[][] = new int[A.length][B.length];
            int max = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (A[i] == B[j]) {
                        if (i > 0 && j > 0) {
                            AB[i][j] = AB[i - 1][j - 1] + 1;
                        } else {
                            AB[i][j] = 1;
                        }
                        max = Math.max(AB[i][j], max);
                    }
                }
            }
            return max;
        }
    }

}
