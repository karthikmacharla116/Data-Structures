Problem Link: https://leetcode.com/problems/maximum-size-of-a-set-after-removals/description/

class MaxSizeOfSetAfterRemoval {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int common = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num: nums1)
            set1.add(num);
        
        for(int num: nums2)
            set2.add(num);

        for(int num: set1) {
            if(set2.contains(num)) 
                common++;
        }
        //minimum computation      
        return Math.min(n, (Math.min(set1.size()-common, n/2) + Math.min(set2.size()-common,n/2)+common));
    }
}
