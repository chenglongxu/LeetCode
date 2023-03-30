package Year2023.Month03;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/
 *
 * @author xuchenglong
 */
public class LeetCode1637 {

    public static void main(String[] args) {
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        LinkedHashSet<Integer> xSet = new LinkedHashSet<>();
        for (int[] point : points) {
            xSet.add(point[0]);
        }
        List<Integer> xList = xSet.stream().sorted().collect(Collectors.toList());
        int maxDiffer = 0;
        for (int i = 1; i < xList.size(); i++) {
            int currentDiffer = xList.get(i) - xList.get(i - 1);
            maxDiffer = Integer.max(maxDiffer, currentDiffer);
        }
        return maxDiffer;
    }

}
