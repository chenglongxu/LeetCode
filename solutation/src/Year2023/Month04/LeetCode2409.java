package Year2023.Month04;

/**
 * https://leetcode.cn/problems/count-days-spent-together/
 *
 * @author xuchenglong
 */
public class LeetCode2409 {

    public static void main(String[] args) {
        System.out.println(countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println(countDaysTogether("10-01", "10-31", "11-01", "12-31"));
        System.out.println(countDaysTogether("09-01", "10-19", "06-19", "10-20"));
        System.out.println(countDaysTogether("08-02", "08-02", "08-02", "08-02"));
    }

    static int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceDay = getDay(arriveAlice);
        int leaveAliceDay = getDay(leaveAlice);
        int arriveBobDay = getDay(arriveBob);
        int leaveBobDay = getDay(leaveBob);
        return Integer.max(Integer.min(leaveAliceDay, leaveBobDay) - Integer.max(arriveAliceDay, arriveBobDay) + 1, 0);
    }

    public static int getDay(String time) {
        String[] arriveAlices = time.split("-");
        int returnDay = Integer.parseInt(arriveAlices[1]);
        for (int i = 0; i < Integer.parseInt(arriveAlices[0]) - 1; i++) {
            returnDay += months[i];
        }
        return returnDay;
    }

    public static int calculateDayOfYear(String day, int[] prefixSum) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return prefixSum[month - 1] + date;
    }

}
