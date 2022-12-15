package Year2022.Month12;

/**
 * https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 *
 * @author xuchenglong
 */
public class LeetCode1945 {

    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
        System.out.println(getLucky("leetcode", 2));
    }

    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (byte b : s.getBytes()) {
            sb.append(b - 'a' + 1);
        }
        while (k > 0) {
            long l = 0;
            for (byte b : sb.toString().getBytes()) {
                l += b - '0';
            }
            sb = new StringBuilder().append(l);
            k--;
        }
        return Integer.parseInt(sb.toString());
    }

}
