package Year2022.Month02;

public class LeetCode838 {

    public static void main(String[] args) {
        System.out.println(pushDominoes("RR.L"));
        System.out.println(pushDominoes(".L.R...LR..L..")); //LL.RR.LLRRLL..
    }

    public static String pushDominoes(String dominoes) {
        byte[] bytes = dominoes.getBytes();
        byte[] nBytes = dominoes.getBytes();
        if (bytes.length > 1) {
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == '.') {
                    if ((i - 1 >= 0 && bytes[i - 1] == 'R') && (i + 1 >= bytes.length || bytes[i + 1] != 'L')) {
                        nBytes[i] = 'R';
                    } else if ((i - 1 < 0 || bytes[i - 1] != 'R') && (i + 1 < bytes.length && bytes[i + 1] == 'L')) {
                        nBytes[i] = 'L';
                    }
                }
            }
        }
        String nv = new String(nBytes);
        if (nv.equals(dominoes)) {
            return nv;
        } else {
            return pushDominoes(nv);
        }
    }

}
