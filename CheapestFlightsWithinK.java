Problem Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/?envType=daily-question&envId=2024-02-23

class CheapestFlightsWithinK {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1 << 29;
        int[][] dp = new int[k + 2][n];

        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
            }
        }

        int result = INF;
        for (int i = 1; i <= k + 1; i++) {
            result = Math.min(result, dp[i][dst]);
        }

        return result == INF ? -1 : result;
    }
}
