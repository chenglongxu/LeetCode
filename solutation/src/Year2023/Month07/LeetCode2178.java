package Year2023.Month07;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
 *
 * @author xuchenglong
 */
public class LeetCode2178 {

    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(12));
        System.out.println(maximumEvenSplit(7));
        System.out.println(maximumEvenSplit(28));
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> returnList = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return new ArrayList<>();
        }
        long a = 2L;
        while (true) {
            if (finalSum >= a) {
                finalSum = finalSum - a;
                returnList.add(a);
                a += 2;
            } else {
                returnList.remove(returnList.size() - 1);
                returnList.add(finalSum + a - 2);
                return returnList;
            }
        }
    }

}
