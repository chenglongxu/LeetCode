package Year2022.Month07;

import java.util.HashSet;
import java.util.Set;

public class LeetCode814 {

    public static void main(String[] args) {

    }


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

    public static TreeNode pruneTree(TreeNode root) {
        boolean delete = checkDelete(root);
        if (delete) {
            return null;
        } else {
            return root;
        }
    }

    private static boolean checkDelete(TreeNode treeNode) {
        boolean delete = true;
        if (treeNode == null) {
            return delete;
        }
        boolean leftDelete = checkDelete(treeNode.left);
        if (leftDelete) {
            treeNode.left = null;
        }
        boolean rightDelete = checkDelete(treeNode.right);
        if (rightDelete) {
            treeNode.right = null;
        }
        return leftDelete && rightDelete && treeNode.val == 0;
    }

}
