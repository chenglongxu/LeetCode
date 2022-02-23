package Year2022.Month02;

public class LeetCode917 {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));//dc-ba
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));//j-Ih-gfE-dCba
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));//Qedo1ct-eeLg=ntse-T!
    }

    public static String reverseOnlyLetters(String s) {
        if (s != null && s.length() > 1) {
            int i = 0;
            int j = s.length() - 1;
            byte[] bytes = s.getBytes();
            while (i < j) {
                if (!Character.isLetter(bytes[i])) {
                    i++;
                    continue;
                }
                if (!Character.isLetter(bytes[j])) {
                    j--;
                    continue;
                }
                byte tmp = bytes[i];
                bytes[i] = bytes[j];
                bytes[j] = tmp;
                i++;
                j--;
            }
            return new String(bytes);
        }
        return s;
    }

}
