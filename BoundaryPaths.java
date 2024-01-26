Problem Link: https://leetcode.com/problems/out-of-boundary-paths/description/?envType=daily-question&envId=2024-01-26

class BoundaryPaths {
  
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dp = new int[m][n];
        int[][] next = new int[m][n];
        dp[startRow][startColumn] = 1;

        int paths = 0;

        for (int move = 1; move <= maxMove; move++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];

                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                            paths = (paths + dp[i][j]) % MOD;
                        } else {
                            next[ni][nj] = (next[ni][nj] + dp[i][j]) % MOD;
                        }
                    }
                }
            }

            int[][] temp = dp;
            dp = next;
            next = temp;
            for (int i = 0; i < m; i++) {
                Arrays.fill(next[i], 0);
            }
        }

        return paths;
    }
}
