package leetcode.leetcode_650_700;

import leetcode.util.TreeNode;

public class Lc669_Trime_a_BST {
    /**
     * if value is less than L , go right
     * if value is large than R, go left
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
