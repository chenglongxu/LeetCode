package Year2022.Month07;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode648 {

    public static void main(String[] args) {
        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] sens = sentence.split(" ");
        dictionary.sort(Comparator.comparing(String::length));
        StringBuilder sb = new StringBuilder();
        for (String sen : sens) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            boolean contain = false;
            for (String dic : dictionary) {
                if (sen.startsWith(dic)) {
                    sb.append(dic);
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                sb.append(sen);
            }
        }
        return sb.toString();
    }

}
