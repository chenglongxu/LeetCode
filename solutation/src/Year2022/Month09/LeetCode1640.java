package Year2022.Month09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode1640 {

    public static void main(String[] args) {
        System.out.println(canFormArray(new int[]{15, 88}, new int[][]{new int[]{15}, new int[]{88}}));
        System.out.println(canFormArray(new int[]{49, 18, 16}, new int[][]{new int[]{16, 18, 49}}));
        System.out.println(canFormArray(new int[]{91, 4, 64, 78}, new int[][]{new int[]{78}, new int[]{4, 64}, new int[]{91}}));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int[] map = new int[101];
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                map[arr[i]] = -1;
            } else {
                map[arr[i]] = arr[i + 1];
            }
        }
        for (int[] piece : pieces) {
            for (int i = 0; i < piece.length; i++) {
                if (map[piece[i]] == 0) {
                    return false;
                }
                if (i != piece.length - 1) {
                    if (map[piece[i]] != piece[i + 1]) {
                        return false;
                    }
                }
                map[piece[i]] = 0;
            }
        }
        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
