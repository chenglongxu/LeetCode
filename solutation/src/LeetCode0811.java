import java.util.ArrayList;
import java.util.List;

public class LeetCode0811 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.waysToChange(10));
    }

    static class Solution {
        public int waysToChange(int n) {
            return count(n, 25);
        }

        int count(int n, int m) {
            int count = 0;
            int nextM = 0;
            if (m == 25) {
                nextM = 10;
            } else if (m == 10) {
                nextM = 5;
            } else if (m == 5) {
                nextM = 1;
            }
            if (n >= m) {
                int way = n / m;
                if (nextM != 0) {
                    for (int i = 0; i <= way; i++) {
                        int nextN = n - i * m;
                        if (nextN > 0) {
                            count += count(n - i * m, nextM);
                        } else {
                            count++;
                        }
                    }
                } else {
                    count++;
                }
            } else {
                if (nextM != 0) {
                    count += count(n, nextM);
                }
            }
            return count;
        }
    }

}
