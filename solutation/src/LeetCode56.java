import java.util.ArrayList;
import java.util.List;

public class LeetCode56 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> returnList = new ArrayList<>();
            if (intervals.length > 0) {
                returnList.add(intervals[0]);
                for (int i = 1; i < intervals.length; i++) {
                    List<int[]> tmpList = new ArrayList<>();
                    int[] source = intervals[i];
                    for (int[] v : returnList) {
                        int[] mergeResoult = merge(source, v);
                        if (mergeResoult == null) {
                            tmpList.add(v);
                        } else {
                            source = mergeResoult;
                        }
                    }
                    tmpList.add(source);
                    returnList = tmpList;
                }
                return returnList.toArray(new int[0][0]);
            } else {
                return intervals;
            }
        }

        private int[] merge(int[] a, int[] b) {
            if (b[0] > a[1] || b[1] < a[0]) {
                return null;
            } else {
                int[] returnVal = new int[2];
                returnVal[0] = Integer.min(a[0], b[0]);
                returnVal[1] = Integer.max(a[1], b[1]);
                return returnVal;
            }
        }

    }

}
