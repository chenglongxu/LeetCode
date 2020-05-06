import javax.xml.stream.XMLInputFactory;
import java.util.ArrayList;
import java.util.List;

public class LeetCode33 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{3, 1}, 3));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int start = 0;
            int end = nums.length - 1;
            int mid;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                //前半部分有序,注意此处用小于等于
                if (nums[start] <= nums[mid]) {
                    //target在前半部分
                    if (target >= nums[start] && target < nums[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (target <= nums[end] && target > nums[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

            }
            return -1;
        }
    }

}
