Problem Link: https://leetcode.com/problems/sort-colors/description/?envType=daily-question&envId=2024-06-12

class SortColors {
    public void sortColors(int[] nums) {
        
        //count sort
        int[] cnt = new int[3]; //red, white, blue

        for(int num: nums) {
            cnt[num]++;
        }

        int index = 0;
        for(int i=0;i<3;i++) {
            while(cnt[i] > 0) {
                nums[index++] = i;
                cnt[i]--;
            }
        }

    }
}

//Bubble sort
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(nums[j] < nums[i]) {
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
        }

    }
}
