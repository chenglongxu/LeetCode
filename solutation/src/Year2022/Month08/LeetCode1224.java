package Year2022.Month08;

import java.util.*;

public class LeetCode1224 {

    public static void main(String[] args) {
        System.out.println(maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
        System.out.println(maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5}));
        System.out.println(maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2}));
        System.out.println(maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}));
        System.out.println(maxEqualFreq(new int[]{1, 2}));
        System.out.println(maxEqualFreq(new int[]{1, 1}));
        System.out.println(maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3}));
    }

    public static int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.computeIfAbsent(num, f -> 0) + 1);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (Integer value : numMap.values()) {
                countMap.put(value, countMap.computeIfAbsent(value, f -> 0) + 1);
            }
            if ((countMap.containsKey(1) || countMap.containsValue(1)) && countMap.keySet().size() == 1) {
                return i + 1;
            }
            if (countMap.keySet().size() == 2) {
                if (countMap.containsKey(1) && countMap.get(1) == 1) {
                    return i + 1;
                }
                if (new ArrayList<>(countMap.keySet()).get(0) - new ArrayList<>(countMap.keySet()).get(1) == 1) {
                    if (new ArrayList<>(countMap.values()).get(0) == 1) {
                        return i + 1;
                    }
                }
                if (new ArrayList<>(countMap.keySet()).get(0) - new ArrayList<>(countMap.keySet()).get(1) == -1) {
                    if (new ArrayList<>(countMap.values()).get(1) == 1) {
                        return i + 1;
                    }
                }
            }
            int count = numMap.get(nums[i]);
            if (count == 1) {
                numMap.remove(nums[i]);
            } else {
                numMap.put(nums[i], count - 1);
            }
        }
        return 1;
    }

}
