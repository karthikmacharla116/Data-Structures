Problem Link: https://leetcode.com/problems/house-robber/description/?envType=daily-question&envId=2024-01-21

class HouseRobber {
    public int rob(int[] nums) {
        //edge case
        if(nums.length<2)
            return nums[0];
        
        int h1 = nums[0];
        int h2 = Math.max(h1, nums[1]);
        int temp;
        for(int i=2;i<nums.length;i++) {
            temp =  Math.max(h1+nums[i], h2);
            h1 = h2;
            h2 = temp;
        }
        return h2;
    }
}
