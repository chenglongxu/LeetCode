package Year2022.Month11;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 *
 * @author xuchenglong
 */
public class LeetCode1710 {

    public static void main(String[] args) {
        System.out.println(8 == maximumUnits(new int[][]{new int[]{1, 3}, new int[]{2, 2}, new int[]{3, 1}}, 4));
        System.out.println(91 == maximumUnits(new int[][]{new int[]{5, 10}, new int[]{2, 5}, new int[]{4, 7}, new int[]{3, 9}}, 10));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int returnValue = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] < truckSize) {
                returnValue += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                returnValue += truckSize * boxType[1];
                break;
            }
        }
        return returnValue;
    }

}
