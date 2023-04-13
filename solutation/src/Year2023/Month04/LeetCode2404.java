package Year2023.Month04;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/most-frequent-even-element/
 *
 * @author xuchenglong
 */
public class LeetCode2404 {

    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println(mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4}));
        System.out.println(mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                continue;
            }
            numCountMap.put(num, numCountMap.computeIfAbsent(num, f -> 0) + 1);
        }
        int value = -1;
        int count = -1;
        for (Integer key : numCountMap.keySet()) {
            int currentCount = numCountMap.get(key);
            if (currentCount > count || (currentCount == count && key < value)) {
                value = key;
                count = currentCount;
            }
        }
        return value;
    }

}
