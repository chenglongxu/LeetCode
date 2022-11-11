package Year2022.Month11;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1620 {

    public static void main(String[] args) {
        System.out.println(bestCoordinate(new int[][]{new int[]{1, 2, 5}, new int[]{2, 1, 7}, new int[]{3, 1, 9}}, 2));
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        Map<String, Double> pointMap = new HashMap<>();
        for (int[] tower : towers) {
            initMap(pointMap, tower, radius);
        }
        double q = 0;
        int[] returnValue = null;
        for (String key : pointMap.keySet()) {
            if (returnValue == null) {
                returnValue = new int[2];
                returnValue[0] = Integer.valueOf(key.split("_")[0]);
                returnValue[1] = Integer.valueOf(key.split("_")[1]);
                q = pointMap.get(key);
            } else if (q >= pointMap.get(key)) {
                int[] newValue = new int[2];
                newValue[0] = Integer.valueOf(key.split("_")[0]);
                newValue[1] = Integer.valueOf(key.split("_")[1]);
                if (newValue[0] <= returnValue[0] && newValue[1] < returnValue[1]) {
                    q = pointMap.get(key);
                    returnValue = newValue;
                }
            }
        }
        return returnValue;
    }

    private static void initMap(Map<String, Double> pointMap, int[] tower, int radius) {
        int x = tower[0];
        int y = tower[1];
        int q = tower[2];
        for (int i = 0; i <= radius; i++) {
            for (int j = 0; j <= radius; j++) {
                if (i + j <= radius) {
                    addPoint(q, x + i, y, i + j, pointMap);
                    if (i != 0) {
                        addPoint(q, x - i, y, i + j, pointMap);
                    }
                    addPoint(q, x, y + j, i + j, pointMap);
                    if (j != 0) {
                        addPoint(q, x, y - j, i + j, pointMap);
                    }
                }
            }
        }
    }

    private static void addPoint(int q, int x, int y, int distance, Map<String, Double> pointMap) {
        if (x >= 0 && y >= 0) {
            Double currentQ = pointMap.computeIfAbsent(x + "_" + y, f -> 0d);
            currentQ += q / (1 + distance);
            pointMap.put(x + "_" + y, currentQ);
        }
    }

}
