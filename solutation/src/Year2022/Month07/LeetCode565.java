package Year2022.Month07;

import java.util.HashSet;
import java.util.Set;

public class LeetCode565 {

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    public static int arrayNesting(int[] nums) {
        int maxSize = 0;
        Set<Integer> usedSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i < maxSize) {
                break;
            }
            if (!usedSet.contains(i)) {
                usedSet.add(i);
                int size = 1;
                int nextCursor = nums[i];
                while (!usedSet.contains(nextCursor)) {
                    usedSet.add(nums[i]);
                    nextCursor = nums[nextCursor];
                    size++;
                }
                maxSize = Integer.max(size, maxSize);
            }
        }
        return maxSize;
    }

}
