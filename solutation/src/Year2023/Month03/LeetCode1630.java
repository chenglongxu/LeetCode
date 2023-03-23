package Year2023.Month03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/arithmetic-subarrays/
 *
 * @author xuchenglong
 */
public class LeetCode1630 {

    public static void main(String[] args) {
        System.out.println(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
        System.out.println(checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, new int[]{0, 1, 6, 4, 8, 7}, new int[]{4, 4, 9, 7, 9, 10}));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> returnList = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];
            if (end < start) {
                returnList.add(false);
                continue;
            }
            int[] newNums = new int[end - start + 1];
            if (end + 1 - start >= 0) {
                System.arraycopy(nums, start, newNums, 0, end + 1 - start);
            }
            int[] newSortNums = Arrays.stream(newNums).sorted().toArray();
            int differ = newSortNums[1] - newSortNums[0];
            for (int j = 1; j < newSortNums.length; j++) {
                if (newSortNums[j] - newSortNums[j - 1] != differ) {
                    returnList.add(false);
                    break;
                }
                if (j == newSortNums.length - 1) {
                    returnList.add(true);
                }
            }
        }
        return returnList;
    }

}
