package Year2020;

import java.util.ArrayList;
import java.util.List;

public class LeetCode542 {


    public int[][] updateMatrix(int[][] matrix) {
        List<Node> toPaintNodeList = new ArrayList<>();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    matrix[x][y] = -1;
                    toPaintNodeList.add(new Node(x, y));
                }
            }
        }
        int i = 0;
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        while (toPaintNodeList.size() > 0) {
            List<Node> nextToPatinNodeList = new ArrayList<>();
            for (Node v : toPaintNodeList) {
                int x = v.x;
                int y = v.y;
                boolean find = false;
                if (x + 1 < maxX) {
                    if (matrix[x + 1][y] == i) {
                        find = true;
                    }
                }
                if (x - 1 >= 0) {
                    if (matrix[x - 1][y] == i) {
                        find = true;
                    }
                }
                if (y + 1 < maxY) {
                    if (matrix[x][y + 1] == i) {
                        find = true;
                    }
                }
                if (y - 1 >= 0) {
                    if (matrix[x][y - 1] == i) {
                        find = true;
                    }
                }
                if (find) {
                    matrix[x][y] = i + 1;
                } else {
                    nextToPatinNodeList.add(v);
                }
            }
            i++;
            toPaintNodeList = nextToPatinNodeList;
        }
        return matrix;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
