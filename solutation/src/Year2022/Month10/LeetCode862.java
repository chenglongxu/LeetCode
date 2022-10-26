package Year2022.Month10;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode862 {

    public static void main(String[] args) {
//        System.out.println(1 == shortestSubarray(new int[]{1}, 1));
//        System.out.println(-1 == shortestSubarray(new int[]{1, 2}, 4));
//        System.out.println(3 == shortestSubarray(new int[]{2, -1, 2}, 3));
        System.out.println(3 == shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
    }

    public static int shortestSubarray(int[] nums, int k) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int returnValue = nums.length + 1;
        for (int i = 0; i <= nums.length; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= k) {
                returnValue = Integer.min(returnValue, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return returnValue < nums.length + 1 ? returnValue : -1;
    }

}
