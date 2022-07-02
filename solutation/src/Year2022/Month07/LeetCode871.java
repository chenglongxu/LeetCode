package Year2022.Month07;

import java.util.*;

public class LeetCode871 {

    public static void main(String[] args) {
        System.out.println(minRefuelStops(1, 1, new int[][]{}));
        System.out.println(minRefuelStops(100, 1, new int[][]{new int[]{10, 100}}));
        System.out.println(minRefuelStops(100, 10, new int[][]{new int[]{10, 60}, new int[]{20, 30}, new int[]{30, 30}, new int[]{60, 40}}));
        System.out.println(minRefuelStops(100, 25, new int[][]{new int[]{25, 25}, new int[]{50, 25}, new int[]{75, 25}}));
        System.out.println(minRefuelStops(1000, 83, new int[][]{new int[]{47, 220}, new int[]{65, 1}, new int[]{98, 113}, new int[]{126, 196}, new int[]{186, 218}, new int[]{320, 205},
                new int[]{686, 317}, new int[]{707, 325}, new int[]{754, 104}, new int[]{781, 105}}));
        System.out.println(minRefuelStops(100, 1, new int[][]{new int[]{10, 100}}));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        List<Integer> fuelList = new ArrayList<>();
        int count = 0;
        int totalFuel = startFuel;
        for (int[] station : stations) {
            while (fuelList.size() > 0 && totalFuel < station[0]) {
                totalFuel += fuelList.get(fuelList.size() - 1);
                fuelList.remove(fuelList.size() - 1);
                count++;
            }
            if (totalFuel >= station[0]) {
                fuelList.add(station[1]);
                Collections.sort(fuelList);
            } else {
                return -1;
            }
        }
        while (fuelList.size() > 0 && totalFuel < target) {
            totalFuel += fuelList.get(fuelList.size() - 1);
            fuelList.remove(fuelList.size() - 1);
            count++;
        }
        if (totalFuel >= target) {
            return count;
        }
        return -1;
    }

}
