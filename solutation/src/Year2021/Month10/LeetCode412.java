package Year2021.Month10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LeetCode412 {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));
    }

    /**
     * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
     * answer[i] == "Fizz" 如果 i 是 3 的倍数。
     * answer[i] == "Buzz" 如果 i 是 5 的倍数。
     * answer[i] == i 如果上述条件全不满足。
     *
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> returnList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                returnList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                returnList.add("Fizz");
            } else if (i % 5 == 0) {
                returnList.add("Buzz");
            } else {
                returnList.add(String.valueOf(i));
            }
        }
        return returnList;
    }

}
