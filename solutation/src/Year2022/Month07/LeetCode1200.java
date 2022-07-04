package Year2022.Month07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode1200 {

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> currentList = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

        int min = currentList.get(currentList.size() - 1) - currentList.get(0);
        for (int i = 0; i < currentList.size() - 1; i++) {
            int left = currentList.get(i);
            int right = currentList.get(i + 1);
            if (right - left < min) {
                returnList = new ArrayList<>();
                returnList.add(Arrays.asList(left, right));
                min = right - left;
            } else if (right - left == min) {
                returnList.add(Arrays.asList(left, right));
            }
        }
        return returnList;
    }

}
