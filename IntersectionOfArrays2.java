Problem Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/?envType=daily-question&envId=2024-07-02

// Optimized
class IntersectionOfArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> intersection = new ArrayList<>();
        
        //two pointers
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[intersection.size()];
        for (int k = 0; k < intersection.size(); k++) {
            result[k] = intersection.get(k);
        }
        
        return result;
    }
}

//
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //m>n?nums2:nums1
        Map<Integer, Integer> freqMap = computeMap(nums1);

        List<Integer> list = new ArrayList();
        //iterate through num2
        for(int i=0;i<nums2.length;i++) {
            int cnt = freqMap.getOrDefault(nums2[i],0);
            if(cnt > 0) {
                list.add(nums2[i]);
                freqMap.put(nums2[i], freqMap.get(nums2[i]) - 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    Map<Integer, Integer> computeMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        return map;
    }

}
