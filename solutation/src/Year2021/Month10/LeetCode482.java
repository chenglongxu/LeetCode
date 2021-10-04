package Year2021.Month10;

import java.util.Locale;

public class LeetCode482 {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase(Locale.ROOT);
        StringBuilder nsb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '-'){
                nsb.append(s.charAt(i));
            }
        }
        s = nsb.toString();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int firstLength = s.length()%k;
        if (firstLength>0){
            sb.append(s.substring(start,firstLength));
            start+=firstLength;
        }
        while (start<s.length()){
            if (start>0) {
                sb.append("-");
            }
            sb.append(s.substring(start,start+k));
            start+=k;
        }
        return sb.toString();
    }

}
