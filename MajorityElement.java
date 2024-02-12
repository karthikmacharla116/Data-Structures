Problem Link: https://leetcode.com/problems/majority-element/?envType=daily-question&envId=2024-02-12

class MajorityElement {
    public int majorityElement(int[] nums) {
        //Moore's Voting Algorithm        
        int majority = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(majority == nums[i]) {
                count++;
            } else if(count == 0) {
                majority = nums[i];
                count++;
            }else {
                count--; 
            }
        }
        return majority;
    }
}
