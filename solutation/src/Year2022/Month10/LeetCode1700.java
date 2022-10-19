package Year2022.Month10;

public class LeetCode1700 {

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));  //0
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));  //3
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int studentCursor = 0;
        int sandwichCursor = 0;
        int returnCount = students.length;
        int count = 0;
        while (sandwichCursor != sandwiches.length) {
            if (studentCursor >= students.length) {
                studentCursor = 0;
            }
            if (count == sandwiches.length) {
                break;
            }
            if (students[studentCursor] == sandwiches[sandwichCursor]) {
                students[studentCursor] = -1;
                sandwichCursor++;
                returnCount--;
                count = 0;
            } else {
                count++;
            }
            studentCursor++;
        }
        return returnCount;
    }

}
