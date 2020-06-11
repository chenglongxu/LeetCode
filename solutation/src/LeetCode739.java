public class LeetCode739 {

    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int nextDay = 1;
            int[] returnValue = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                if (i > 0 && T[i] < T[i - 1]) {
                    nextDay = Math.min(i + 1, T.length - 1);
                }
                while (T[nextDay] <= T[i]) {
                    nextDay++;
                    if (nextDay == T.length) {
                        break;
                    }
                }
                if (nextDay == T.length) {
                    nextDay = Math.min(i + 2, T.length - 1);
                    returnValue[i] = 0;
                } else {
                    returnValue[i] = nextDay - i;
                }
            }
            return returnValue;
        }
    }

}
