Problem Link: https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/?envType=daily-question&envId=2024-05-20

class SubsetXORSum {
    public int subsetXORSum(int[] nums) {
        int sum=0;
        int n = nums.length;
        for(int mask = 0; mask <(1<<n);mask++) {
            int xor = 0;
            for(int i=0;i<n;i++) {
                if((mask & (1<<i)) != 0)
                    xor ^= nums[i];
            }
            sum += xor;
        }
        return sum;

    }
}
