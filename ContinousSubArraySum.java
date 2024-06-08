Problem Link: https://leetcode.com/problems/continuous-subarray-sum/description/?envType=daily-question&envId=2024-06-08

class ContinousSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;

        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        int prefixSum = 0;
        for(int i=0; i<n;i++) {
            prefixSum = (prefixSum + nums[i])%k;
            if(map.containsKey(prefixSum)) {
                if(i - map.get(prefixSum) >= 2)
                    return true;
            } else {
                map.put(prefixSum, i);
            }
        }
        return false;
    }
}
