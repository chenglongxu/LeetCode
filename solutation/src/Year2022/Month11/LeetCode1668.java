package Year2022.Month11;

public class LeetCode1668 {

    public static void main(String[] args) {
        System.out.println(2 == maxRepeating("ababc", "ab"));
        System.out.println(1 == maxRepeating("ababc", "ba"));
        System.out.println(0 == maxRepeating("ababc", "ac"));
    }

    public static int maxRepeating(String sequence, String word) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            i++;
            sb.append(word);
            if (!sequence.contains(sb.toString())) {
                return i - 1;
            }
        }
    }

}
