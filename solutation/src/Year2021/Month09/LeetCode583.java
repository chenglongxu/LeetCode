package Year2021.Month09;

import java.util.HashSet;
import java.util.Set;

public class LeetCode583 {

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] ints = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char x = word1.charAt(i - 1);
                char y = word2.charAt(j - 1);
                if (x == y) {
                    ints[i][j] = ints[i - 1][j - 1] + 1;
                } else {
                    ints[i][j] = Math.max(ints[i - 1][j], ints[i][j - 1]);
                }
            }
        }
        return m + n - 2 * ints[m][n];
    }

}
