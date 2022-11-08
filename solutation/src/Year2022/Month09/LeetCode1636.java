package Year2022.Month09;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode1636 {

    public static void main(String[] args) {
        System.out.println(frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
        System.out.println(frequencySort(new int[]{2, 3, 1, 3, 2}));
        System.out.println(frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}));
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.computeIfAbsent(num, f -> 0);
            map.put(num, ++count);
        }
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        for (Integer key : map.keySet()) {
            Integer count = map.get(key);
            countMap.computeIfAbsent(count, f -> new ArrayList<>()).add(key);
        }
        int[] returnNums = new int[nums.length];
        int cursor = 0;
        for (Integer count : countMap.keySet().stream().sorted().collect(Collectors.toList())) {
            List<Integer> sortList = countMap.get(count).stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < sortList.size(); i++) {
                for (int j = 0; j < count; j++) {
                    returnNums[cursor] = sortList.get(sortList.size() - i - 1);
                    cursor++;
                }
            }
        }
        return returnNums;
    }

}
