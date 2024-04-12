Problem Link: https://leetcode.com/problems/trapping-rain-water/


//Space: O(n)
class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        
        int water = 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        //Maximum left heights for every index 
        left[0] = height[0];
        for(int i=1;i<n;i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        //similarly for right
        right[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        
        for(int i=0;i<n;i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }
        return water;
    }
}


//Optimized
class TrappingRainWater {
    public int trap(int[] height) {
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;
        
        //Two Pointers
        int start = 0;
        int end = height.length-1;
        
        while(start<end) {
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);
            
            if(leftMax < rightMax) {
                water += (leftMax - height[start]);
                start++;
            } else {
                water += (rightMax - height[end]);
                end--;
            }
            
        }
        
        return water;
    }
}
