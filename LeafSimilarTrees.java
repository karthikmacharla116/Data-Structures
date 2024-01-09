Problem Link: https://leetcode.com/problems/leaf-similar-trees/description/?envType=daily-question&envId=2024-01-09

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
class LeafSimilarTrees {
    private void leafSeq(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null)
                list.add(root.val);
            leafSeq(root.left, list);
            leafSeq(root.right, list);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList();
        List<Integer> list2 = new LinkedList();
        leafSeq(root1, list1);
        leafSeq(root2, list2);
        System.out.println(list1);
        System.out.println(list2);

        return list1.equals(list2);
    }
}
