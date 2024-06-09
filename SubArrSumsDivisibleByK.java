Problem Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/?envType=daily-question&envId=2024-06-09

class SubArrSumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;

        int cnt = 0;

        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        long prefixSum = 0;

        for(int i=0;i<n;i++) {
            prefixSum += nums[i];
            int mod = (int)prefixSum%k;
            if(mod < 0) { //converting -ve remainder to positive remainder
                mod = (mod+k)%k;
            }
            if(map.containsKey(mod)) {
                cnt += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        System.out.println(map);
        return cnt;
    }
}
