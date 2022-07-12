package Year2022.Month07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode1252 {

    public static void main(String[] args) {
        System.out.println(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        System.out.println(oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }

    public static int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] indice : indices) {
            for (int i = 0; i < n; i++) {
                matrix[indice[0]][i] += 1;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][indice[1]] += 1;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

}
