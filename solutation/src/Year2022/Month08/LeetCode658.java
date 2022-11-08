package Year2022.Month08;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode658 {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = k - 1;
        while (end < arr.length - 1) {
            if (arr[end + 1] == arr[start] || (Math.abs(arr[end + 1] - x) < Math.abs(arr[start] - x))) {
                start++;
                end++;
            } else {
                break;
            }
        }
        List<Integer> returnList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            returnList.add(arr[i]);
        }
        return returnList;
    }

}
