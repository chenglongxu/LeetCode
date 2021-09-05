package Year2021.Month09;

public class LeetCode671 {

    private class TreeNode {
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
        System.out.println(findSecondMinimumValue(null));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        int[] values = new int[2];
        values[0] = -1;
        values[1] = -1;
        checkTreeNode(root, values);
        return values[1];
    }

    private static void checkTreeNode(TreeNode root, int[] values) {
        if (root == null) {
            return;
        }
        if (values[1] == -1 || values[1] > root.val) {
            if (values[0] == -1 || values[0] > root.val) {
                values[1] = values[0];
                values[0] = root.val;
                checkTreeNode(root.left, values);
                checkTreeNode(root.right, values);
            } else if (root.val != values[0]) {
                values[1] = root.val;
            } else {
                checkTreeNode(root.left, values);
                checkTreeNode(root.right, values);
            }
        }
    }

}
