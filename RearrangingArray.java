Problem Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/?envType=daily-question&envId=2024-02-14

class RearrangingArray {
    public int[] rearrangeArray(int[] nums) {
        int n= nums.length;
        int[] result = new int[n];
       
        int posIndex=0;
        int negIndex=1;

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result[posIndex]=nums[i];
                posIndex+=2;
            }
            else{
                result[negIndex]=nums[i];
                negIndex+=2;
            }
        }
        return result;
    }
}
