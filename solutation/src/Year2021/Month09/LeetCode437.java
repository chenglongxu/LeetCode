package Year2021.Month09;

import java.util.Arrays;
import java.util.List;

public class LeetCode437 {

    public static class TreeNode {
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
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, node5);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node1 = new TreeNode(1, null, node2);
        System.out.println(pathSum(node1, 3));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (root.val == targetSum) {
            count++;
        }
        count += pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        count += pathExtends(root.left, targetSum - root.val) + pathExtends(root.right, targetSum - root.val);
        return count;
    }

    private static int pathExtends(TreeNode root, int targetSum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (root.val == targetSum) {
            count++;
        }
        count += pathExtends(root.left, targetSum - root.val) + pathExtends(root.right, targetSum - root.val);
        return count;
    }

}
