Problem Link: https://leetcode.com/problems/range-sum-of-bst/description/?envType=daily-question&envId=2024-01-08

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return recursion(root, low, high);
    }

    private int recursion(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        if(root.val < low)
            return recursion(root.right, low, high);
        if(root.val > high)
            return recursion(root.left, low, high);
        return root.val + recursion(root.left, low, high) + recursion(root.right, low, high);
    }
}
