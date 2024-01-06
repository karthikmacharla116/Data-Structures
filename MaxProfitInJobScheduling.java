Problem Link:https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/?envType=daily-question&envId=2024-01-06

class Job {
    int start, end, profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class MaxProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int currentProfit = jobs[i].profit;
            int latestNonConflict = findLatestNonConflict(jobs, i);
            if (latestNonConflict != -1) {
                currentProfit += dp[latestNonConflict];
            }
            dp[i] = Math.max(currentProfit, dp[i - 1]);
        }

        return dp[n - 1];
    }

    private static int findLatestNonConflict(Job[] jobs, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (jobs[i].end <= jobs[index].start) {
                return i;
            }
        }
        return -1;
    }
}
