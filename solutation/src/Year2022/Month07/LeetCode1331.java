package Year2022.Month07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1331 {

    public static void main(String[] args) {
        System.out.println(arrayRankTransform(new int[]{40, 10, 20, 30}));
    }

    public static int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> sortMap = new HashMap<>();
        int j = 1;
        for (int i : Arrays.stream(arr).sorted().toArray()) {
            if (!sortMap.containsKey(i)) {
                sortMap.put(i, j);
                j++;
            }
        }
        int[] returnArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            returnArr[i] = sortMap.get(arr[i]);
        }
        return returnArr;
    }

}
