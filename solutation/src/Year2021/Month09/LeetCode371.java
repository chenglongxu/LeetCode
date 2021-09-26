package Year2021.Month09;

public class LeetCode371 {

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(2, 3));
    }

    public static int getSum(int a, int b) {
        int or = a ^ b;
        int and = a & b;
        while (and != 0) {
            a = or;
            b = and << 1;
            or = a ^ b;
            and = a & b;
        }
        return or;
    }

}
