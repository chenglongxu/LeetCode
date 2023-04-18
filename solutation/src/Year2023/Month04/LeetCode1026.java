package Year2023.Month04;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/solutions/
 *
 * @author xuchenglong
 */
public class LeetCode1026 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(new ArrayList<>(), root);
    }

    private static int maxAncestorDiff(List<Integer> parentValList, TreeNode child) {
        if (child == null) {
            return 0;
        }
        int maxValue = 0;
        for (Integer parentVal : parentValList) {
            maxValue = Integer.max(Math.abs(parentVal - child.val), maxValue);
        }
        parentValList.add(child.val);
        int leftVal = maxAncestorDiff(parentValList, child.left);
        int rightVal = maxAncestorDiff(parentValList, child.right);
        parentValList.remove((Object) child.val);
        return Math.max(Integer.max(leftVal, rightVal), maxValue);
    }

}
