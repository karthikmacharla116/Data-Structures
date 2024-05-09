Problem Link: https://leetcode.com/problems/maximize-happiness-of-selected-children/description/?envType=daily-question&envId=2024-05-09

class MaximumHappinessSum {
    public long maximumHappinessSum(int[] happiness, int k) {
        int length = happiness.length;
        Arrays.sort(happiness);
        
        long ans = 0;

        for(int i=0;i<k;i++) {
            int val = happiness[length-1-i];
            ans += (val-i)>=0?(val - i):0;
        }
        return ans;
    }
}
