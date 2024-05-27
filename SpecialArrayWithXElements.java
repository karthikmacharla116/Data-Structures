Problem Link: https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/?envType=daily-question&envId=2024-05-27

class SpecialArrayWithXElements {
    public int specialArray(int[] nums) {
        int n = nums.length;

        int[] freq = new int[n+1];
        for(int num: nums)
            freq[Math.min(n,num)]++;
        
        System.out.println(Arrays.toString(freq));
        int specials = 0;
        for(int i=n;i>=1;i--) {
            specials += freq[i];
            if(specials == i)
                return specials;
        }
        return -1;
    }
}
