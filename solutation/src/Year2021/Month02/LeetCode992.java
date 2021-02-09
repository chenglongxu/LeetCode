package Year2021.Month02;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
 */
public class LeetCode992 {

    public static void main(String args[]) {
        System.out.println(Solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(Solution.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 3));
    }

    static class Solution {
        public static int subarraysWithKDistinct(int[] A, int K) {
            int value = 0;
            int i = 0;
            int j = 0;
            Map<Integer, Integer> map = new HashMap<>();
            while (true) {
                boolean add = true;
                if (map.size() < K) {
                    if (add) {
                        map.put(A[j], map.computeIfAbsent(A[j], v -> 0) + 1);
                        if (++j >= A.length) {
                            break;
                        }
                    } else {
                        remove(map, A, i);
                        i++;
                        add = !add;
                    }
                } else if (map.size() == K) {
                    value++;
                    if (add) {
                        map.put(A[j], map.computeIfAbsent(A[j], v -> 0) + 1);
                        if (++j >= A.length) {
                            break;
                        }

                    } else {
                        remove(map, A, j--);
                    }
                } else {

                    if (++i > A.length - K) {
                        break;
                    }
                }
            }
            return value;
        }

        private static void remove(Map<Integer, Integer> map, int[] A, int i) {
            int iCount = map.get(A[i]);
            if (--iCount == 0) {
                map.remove(A[i]);
            } else {
                map.put(A[i], iCount);
            }
        }

    }

}
