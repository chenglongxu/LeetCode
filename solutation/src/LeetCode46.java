import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode46 {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                numList.add(nums[i]);
            }
            return permute(numList);
        }

        private List<List<Integer>> permute(List<Integer> nums) {
            List<List<Integer>> returnList = new ArrayList<>();
            if (nums.size() > 0) {
                for (int i = 0; i < nums.size(); i++) {
                    List<Integer> childNums = remove(nums, i);
                    List<List<Integer>> childList = permute(childNums);
                    if (childList.size()>0) {
                        for (List<Integer> v : childList) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums.get(i));
                            list.addAll(v);
                            returnList.add(list);
                        }
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums.get(i));
                        returnList.add(list);
                    }
                }
            }
            return returnList;
        }

        private List<Integer> remove(List<Integer> nums, int num) {
            List<Integer> childNums = new ArrayList<>();
            for (int i = 0; i < nums.size(); i++) {
                if (i != num) {
                    childNums.add(nums.get(i));
                }
            }
            return childNums;
        }

    }

}
