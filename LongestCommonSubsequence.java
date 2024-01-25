Problem Link: https://leetcode.com/problems/longest-common-subsequence/?envType=daily-question&envId=2024-01-25

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0; 
            for (int j = 1; j <= n; j++) {
                int current = dp[j]; // Storing the value for the previous row (i-1, j)
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = current;
            }
        }

        return dp[n];
    }
}
