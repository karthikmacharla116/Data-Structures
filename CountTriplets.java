Problem Link: https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/?envType=daily-question&envId=2024-05-30

//Optimized
class CountTriplets {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        
        //prefix sum of arr xors
        int[] prefix = new int[n+1];
        for(int p=0;p<n;p++) 
            prefix[p+1] = prefix[p]^arr[p];
        
        for(int i=0;i<n;i++) {
            for(int k=i+1;k<=n;k++) {
                if(prefix[i] == prefix[k])
                    cnt += k-(i+1); // length - 1 : (k-(i+1)) + 1 - 1
            }
        }

        return  cnt;
    }
}

//Brute force
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        for(int i=0;i<n;i++) {
            int xora = 0;
            for(int j=i+1;j<n;j++) {
                xora = xora^arr[j-1];
                int xorb = 0;
                for(int k=j;k<n;k++) {
                    xorb = xorb^arr[k];
                    if(xora == xorb)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}
