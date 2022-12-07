package Year2022.Month12;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 *
 * @author xuchenglong
 */
public class LeetCode1775 {

    public static void main(String[] args) {
//        System.out.println(3 == minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
//        System.out.println(-1 == minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));
//        System.out.println(3 == minOperations(new int[]{6, 6}, new int[]{1}));
        System.out.println(0 == minOperations(new int[]{2, 3}, new int[]{5}));
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        for (int i : nums1) {
            sum1 += i;
        }
        int sum2 = 0;
        for (int i : nums2) {
            sum2 += i;
        }
        if (sum1 == sum2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (sum1 > sum2) {
                map.put(i - 1, map.computeIfAbsent(i - 1, f -> 0) + 1);
            } else {
                map.put(6 - i, map.computeIfAbsent(6 - i, f -> 0) + 1);
            }
        }
        for (int i : nums2) {
            if (sum1 < sum2) {
                map.put(i - 1, map.computeIfAbsent(i - 1, f -> 0) + 1);
            } else {
                map.put(6 - i, map.computeIfAbsent(6 - i, f -> 0) + 1);
            }
        }
        int differ = sum1 > sum2 ? sum1 - sum2 : sum2 - sum1;
        int returnValue = 0;
        for (int i = 5; i > 0; i--) {
            while (map.get(i) != null && map.get(i) > 0) {
                differ -= i;
                map.put(i, map.get(i) - 1);
                returnValue++;
                if (differ <= 0) {
                    return returnValue;
                }
            }
        }
        return -1;
    }

}
