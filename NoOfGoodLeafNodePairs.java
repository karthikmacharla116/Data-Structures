Problem Link: https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/?envType=daily-question&envId=2024-07-18

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
class NoOfGoodLeafNodePairs {
    public int countPairs(TreeNode root, int distance) {
        int[] count = new int[1];  // Use an array to store the count so it can be updated inside DFS
        dfs(root, distance, count);
        return count[0];
    }
    
    // Return an array of distances to leaf nodes from the current node
    private int[] dfs(TreeNode node, int distance, int[] count) {
        if (node == null) return new int[0];
        
        if (node.left == null && node.right == null) {
            // Leaf node
            return new int[] {1};
        }
        
        int[] leftDistances = dfs(node.left, distance, count);
        int[] rightDistances = dfs(node.right, distance, count);
        
        // Count valid pairs
        for (int l : leftDistances) {
            for (int r : rightDistances) {
                if (l + r <= distance) {
                    count[0]++;
                }
            }
        }
        
        // Prepare distances array for the current node
        int[] distances = new int[leftDistances.length + rightDistances.length];
        int index = 0;
        for (int l : leftDistances) {
            if (l + 1 <= distance) {
                distances[index++] = l + 1;
            }
        }
        for (int r : rightDistances) {
            if (r + 1 <= distance) {
                distances[index++] = r + 1;
            }
        }
        
        return Arrays.copyOf(distances, index);
    }
}
