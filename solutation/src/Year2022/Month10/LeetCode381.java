package Year2022.Month10;

import java.util.ArrayList;
import java.util.List;

public class LeetCode381 {

    public static void main(String[] args) {
        System.out.println(1 == shortestBridge(new int[][]{new int[]{0, 1}, new int[]{1, 0}}));
        System.out.println(2 == shortestBridge(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}}));
        System.out.println(1 == shortestBridge(new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}}));
    }

    public static int shortestBridge(int[][] grid) {
        List<int[]> a = findArea(grid);
        List<int[]> b = findArea(grid);
        int min = grid.length * 2;
        for (int[] ints : a) {
            for (int[] ints1 : b) {
                min = Integer.min(Math.abs(ints[0] - ints1[0]) + Math.abs(ints[1] - ints1[1]) - 1, min);
            }
        }
        return min;
    }

    private static List<int[]> findArea(int[][] grid) {
        List<int[]> area = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                find(area, grid, i, j);
                if (area.size() > 0) {
                    return area;
                }
            }
        }
        return area;
    }

    private static void find(List<int[]> area, int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid.length) {
            if (grid[i][j] == 1) {
                int[] point = new int[2];
                point[0] = i;
                point[1] = j;
                area.add(point);
                grid[i][j] = -1;
                find(area, grid, i + 1, j);
                find(area, grid, i - 1, j);
                find(area, grid, i, j + 1);
                find(area, grid, i, j - 1);
            }
        }
    }

}
