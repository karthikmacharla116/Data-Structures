Problem Link: https://leetcode.com/problems/first-missing-positive/description/?envType=daily-question&envId=2024-03-26

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        int index=0;
        while(index<nums.length) {
            int correct = nums[index] - 1;
            if(nums[index]<nums.length && nums[index]>0 && nums[index] != nums[correct]) {
                int swap = nums[index];
                nums[index] = nums[correct];
                nums[correct] = swap;
            } else {
                index++;
            }
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
}
