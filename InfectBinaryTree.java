ProblemLink: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/?envType=daily-question&envId=2024-01-10

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
class InfectBinaryTree {
  private int result;

  public int amountOfTime(TreeNode root, int start) {
    search(root, start);
    return result;
  }

  public int search(TreeNode root, int start) {
    if (root == null) return 0;

    int leftDepth = search(root.left, start);
    int rightDepth = search(root.right, start);

    if (root.val == start) {
      result = Math.max(leftDepth, rightDepth);
      return -1;
    } else if (leftDepth >= 0 && rightDepth >= 0) {
      return Math.max(leftDepth, rightDepth) + 1;
    } else {
      result = Math.max(result, Math.abs(leftDepth - rightDepth));
      return Math.min(leftDepth, rightDepth) - 1;
    }
  }
}
