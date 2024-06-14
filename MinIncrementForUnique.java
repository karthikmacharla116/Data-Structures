Problem Link: https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/?envType=daily-question&envId=2024-06-14

class MinIncrementForUnique {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;

        int minIncrement = 0;

        Arrays.sort(nums);

        for(int i=0;i<n-1;i++) {
            if(nums[i] >= nums[i+1]) {
                int diff = nums[i] - nums[i+1];
                nums[i+1] += (diff+1);
                minIncrement += (diff+1);
            } 
        }

        return minIncrement;
    }
}
