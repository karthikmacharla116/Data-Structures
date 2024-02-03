Problem Link: https://leetcode.com/problems/partition-array-for-maximum-sum/?envType=daily-question&envId=2024-02-03

class MaxSumAfterPartition {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxInWindow = 0;

            for (int j = 1; j <= k && i - j >= 0; j++) {
                maxInWindow = Math.max(maxInWindow, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + maxInWindow * j);
            }
        }

        return dp[n];
    }        
}
