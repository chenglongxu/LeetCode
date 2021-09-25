package Year2021.Month09;

import java.util.*;

public class LeetCode36 {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                new char[]{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                new char[]{'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                new char[]{'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                new char[]{'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                new char[]{'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                new char[]{'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        }));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> cSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!cSet.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> cSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!cSet.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!check(i * 3, j * 3, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check(int x, int y, char[][] board) {
        Set<Character> cSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] != '.') {
                    if (!cSet.add(board[x + i][y + j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
