package Year2021.Month09;

import java.util.*;

public class LeetCode212 {

    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{
                new char[]{'o', 'a', 'a', 'h'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'},
        }, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println(findWords(new char[][]{new char[]{'a', 'b'}, new char[]{'a', 'b'}}, new String[]{"abcb"}));
        System.out.println(findWords(new char[][]{
                new char[]{'a', 'b', 'c'},
                new char[]{'a', 'e', 'd'},
                new char[]{'a', 'f', 'g'}
        }, new String[]{"eaafgdcba"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> returnList = new ArrayList<>();
        Map<String, List<List<Integer>>> map = new HashMap<>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                List<List<Integer>> list = map.computeIfAbsent(String.valueOf(board[x][y]), f -> new ArrayList<>());
                list.add(Arrays.asList(x, y));
            }
        }
        for (String word : words) {
            int[][] usedBoard = new int[board.length][board[0].length];
            List<List<Integer>> list = map.get(String.valueOf(word.charAt(0)));
            if (list != null) {
                for (List<Integer> v : list) {
                    if (contain(board, word, 0, v.get(0), v.get(1), usedBoard)) {
                        returnList.add(word);
                        break;
                    }
                }
            }
        }
        return returnList;
    }

    private static boolean contain(char[][] board, String word, int cursor, int x, int y, int[][] usedBoard) {
        if (usedBoard[x][y] == 1) {
            return false;
        }
        if (board[x][y] == word.charAt(cursor)) {
            if (cursor == word.length() - 1) {
                return true;
            }
            usedBoard[x][y] = 1;
            cursor++;
            if (x - 1 >= 0) {
                if (contain(board, word, cursor, x - 1, y, usedBoard)) {
                    return true;
                }
            }
            if (x + 1 <= board.length - 1) {
                if (contain(board, word, cursor, x + 1, y, usedBoard)) {
                    return true;
                }
            }
            if (y - 1 >= 0) {
                if (contain(board, word, cursor, x, y - 1, usedBoard)) {
                    return true;
                }
            }
            if (y + 1 <= board[0].length - 1) {
                if (contain(board, word, cursor, x, y + 1, usedBoard)) {
                    return true;
                }
            }
            usedBoard[x][y] = 0;
        }
        return false;
    }

}
