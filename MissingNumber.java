Problem Link: https://leetcode.com/problems/missing-number/description/?envType=daily-question&envId=2024-02-20

class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;

        int actualSum=0;
        for(int i=0;i<n;i++)
            actualSum += nums[i];
        
        return sum-actualSum;
    }
}


//Using Cyclic sort
/*
class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length) {
            if(nums[i]<nums.length && nums[i] != i) {
                int swap = nums[i];
                nums[i] = nums[swap];
                nums[swap] = swap;
            } else {
                i++;
            }
        }

        for(int j=0;j<nums.length;j++) {
            if(nums[j] != j)
                return j;
        }
        return nums.length;
    }
}
*/
