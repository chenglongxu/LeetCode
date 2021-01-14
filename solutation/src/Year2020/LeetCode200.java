package Year2020;

import java.util.*;

public class LeetCode200 {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int islands = 0;
            if (grid.length > 0) {
                int maxX = grid.length;
                int maxY = grid[0].length;
                Set<String> landSet = new HashSet<>();

                for (int x = 0; x < grid.length; x++) {
                    for (int y = 0; y < grid[0].length; y++) {
                        if ('1' == grid[x][y]) {
                            landSet.add(x + "-" + y);
                        }
                    }
                }
                while (landSet.size() > 0) {
                    islands++;
                    removeLand(landSet, landSet.iterator().next(), maxX, maxY);
                }
            }
            return islands;
        }

        private void removeLand(Set<String> landSet, String node, int maxX, int maxY) {
            landSet.remove(node);
            int x = Integer.parseInt(node.substring(0, node.indexOf("-")));
            int y = Integer.parseInt(node.substring(node.indexOf("-") + 1));
            if (x - 1 >= 0) {
                String nextNode = (x - 1) + "-" + y;
                if (landSet.remove(nextNode)) {
                    removeLand(landSet, nextNode, maxX, maxY);
                }
            }
            if (x + 1 < maxX) {
                String nextNode = (x + 1) + "-" + y;
                if (landSet.remove(nextNode)) {
                    removeLand(landSet, nextNode, maxX, maxY);
                }
            }
            if (y - 1 >= 0) {
                String nextNode = x + "-" + (y - 1);
                if (landSet.remove(nextNode)) {
                    removeLand(landSet, nextNode, maxX, maxY);
                }
            }
            if (y + 1 < maxY) {
                String nextNode = x + "-" + (y + 1);
                if (landSet.remove(nextNode)) {
                    removeLand(landSet, nextNode, maxX, maxY);
                }
            }
        }


    }

}
