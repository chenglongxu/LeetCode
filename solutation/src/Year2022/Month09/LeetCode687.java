package Year2022.Month09;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode687 {

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
        TreeNode t31 = new TreeNode(4, null, null);
        TreeNode t32 = new TreeNode(4, null, null);
        TreeNode t34 = new TreeNode(5, null, null);
        TreeNode t21 = new TreeNode(4, t31, t32);
        TreeNode t22 = new TreeNode(5, null, t34);
        TreeNode root = new TreeNode(1, t21, t22);
        System.out.println(longestUnivaluePath(root));
    }

    static Map<Integer, Integer> countMap = new HashMap<>();

    public static int longestUnivaluePath(TreeNode root) {
        countNode(root, null);
        int max = 0;
        for (Integer value : countMap.values()) {
            max = Integer.max(value, max);
        }
        return Integer.max(max - 1, 0);
    }

    public static int countNode(TreeNode node, Integer value) {
        int count = 0;
        if (node != null) {
            if (value == null) {
                value = node.val;
            }
            if (node.val == value) {
                count++;
                int left = countNode(node.left, value);
                int right = countNode(node.right, value);
                Integer currentCount = countMap.computeIfAbsent(value, f -> 0);
                countMap.put(value, Integer.max(currentCount, count + left + right));
                return Integer.max(count + left, count + right);
            } else {
                count++;
                int left = countNode(node.left, node.val);
                int right = countNode(node.right, node.val);
                Integer currentCount = countMap.computeIfAbsent(value, f -> 0);
                countMap.put(value, Integer.max(currentCount, count + left + right));
                return 0;
            }
        }
        return count;
    }

}
