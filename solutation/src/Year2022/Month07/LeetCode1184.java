package Year2022.Month07;

public class LeetCode1184 {

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
        System.out.println(distanceBetweenBusStops(new int[]{6, 47, 48, 31, 10, 27, 46, 33, 52, 33, 38, 25, 32, 45, 36, 3, 0, 33, 22, 53, 8, 13, 18, 1, 44, 41, 14, 5, 38, 25, 48}, 22, 0));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = start;
        int al = 0;
        int bl = 0;
        boolean a = true;
        do {
            if (a) {
                al += distance[i];
            } else {
                bl += distance[i];
            }
            i++;
            if (i >= distance.length) {
                i = 0;
            }
            if (i == destination) {
                a = false;
            }
        } while (i != start);
        return Integer.min(al, bl);
    }

}
