package Year2021.Month09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode447 {

    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}}));
        System.out.println(numberOfBoomerangs(new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}}));
        System.out.println(numberOfBoomerangs(new int[][]{new int[]{0, 0}}));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int[] point : points) {
            Map<Double, Integer> lengthMap = new HashMap<>();
            for (int[] ints : points) {
                Double length = Math.pow((ints[0] - point[0]), 2) + Math.pow((ints[1] - point[1]), 2);
                Integer currentCount = lengthMap.computeIfAbsent(length, f -> 0);
                count += currentCount;
                lengthMap.put(length, ++currentCount);
            }
        }
        return count * 2;
    }

}
