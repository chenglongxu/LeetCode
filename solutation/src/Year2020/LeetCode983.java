package Year2020;

public class LeetCode983 {

    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[] dayCosts = new int[366];
            for (int i = 0; i < days.length; i++) {
                dayCosts[days[i]] = -1;
            }
            for (int i = 1; i < dayCosts.length; i++) {
                if (dayCosts[i] == 0) {
                    dayCosts[i] = dayCosts[i - 1];
                } else {
                    int a1, a7, a30;
                    a1 = dayCosts[i - 1] + costs[0];
                    if (i - 7 >= 1) {
                        a7 = dayCosts[i - 7] + costs[1];
                    } else {
                        a7 = costs[1];
                    }
                    if (i - 30 >= 1) {
                        a30 = dayCosts[i - 30] + costs[2];
                    } else {
                        a30 = costs[2];
                    }
                    dayCosts[i] = Math.min(Math.min(a1, a7), a30);
                }
            }
            return dayCosts[365];
        }
    }

}
