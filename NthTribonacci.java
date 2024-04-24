Problem Link: https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=daily-question&envId=2024-04-24

class NthTribonacci {
    public int tribonacci(int n) {
        if(n<3) {
            if(n<1)
                return n;
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1]+ dp[i-2]+dp[i-3];
        }
        return dp[n];
    }

}
