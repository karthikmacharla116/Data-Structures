Problem Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/

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
class SumRootToLeafNodes {
    public int sumNumbers(TreeNode root) {
      if(root==null) return 0;
        return helper(root,0);
    }
     private int helper(TreeNode root, int sumvalue){
      if(root==null) return 0;
      sumvalue=sumvalue*10+root.val;
      if(root.left==null && root.right==null) return sumvalue;
      return helper(root.left,sumvalue)+helper(root.right,sumvalue);
     }
}
