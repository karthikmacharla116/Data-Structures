Problem Link: https://leetcode.com/problems/student-attendance-record-ii/description/?envType=daily-question&envId=2024-05-26

class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        
        // dp[i][j][k] : length i, j number of 'A', k consecutive 'L'
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == 0) continue;
                    // Append 'P'
                    dp[i+1][j][0] = (dp[i+1][j][0] + dp[i][j][k]) % MOD;
                    // Append 'A'
                    if (j < 1) {
                        dp[i+1][j+1][0] = (dp[i+1][j+1][0] + dp[i][j][k]) % MOD;
                    }
                    // Append 'L'
                    if (k < 2) {
                        dp[i+1][j][k+1] = (dp[i+1][j][k+1] + dp[i][j][k]) % MOD;
                    }
                }
            }
        }
        
        int result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }
        
        return result;
    }
