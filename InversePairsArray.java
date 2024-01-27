Problem Link: https://leetcode.com/problems/k-inverse-pairs-array/description/?envType=daily-question&envId=2024-01-27

class InversePairsArray {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        
        dp[0][0] = 1;  // Base case
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            
            for (int j = 0; j <= k; j++) {
                sum = (sum + dp[i - 1][j]) % MOD;
                
                if (j >= i) {
                    sum = (sum - dp[i - 1][j - i] + MOD) % MOD;
                }
                
                dp[i][j] = sum;
            }
        }
        
        return dp[n][k];
    }
}
