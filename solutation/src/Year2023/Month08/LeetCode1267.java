package Year2023.Month08;

/**
 * <a href="https://leetcode.cn/problems/count-servers-that-communicate/">...</a>
 */
public class LeetCode1267 {

    public static void main(String[] args) {
        System.out.println(countServers(new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
        System.out.println(countServers(new int[][]{new int[]{1, 0}, new int[]{1, 1}}));
        System.out.println(countServers(new int[][]{new int[]{1, 1, 0, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 1, 0}, new int[]{0, 0, 0, 1}}));
    }

    public static int countServers(int[][] grid) {
        int[] xInts = new int[grid.length];
        int[] yInts = new int[grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                xInts[x] += grid[x][y];
                yInts[y] += grid[x][y];
            }
        }
        int returnCount = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1 && (xInts[x] > 1 || yInts[y] > 1)) {
                    returnCount++;
                }
            }
        }
        return returnCount;
    }

}
