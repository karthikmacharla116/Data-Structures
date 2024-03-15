Problem Link: https://leetcode.com/problems/product-of-array-except-self/description/?envType=daily-question&envId=2024-03-15

class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixArr = new int[n];

        for(int i=0;i<n;i++) {
            if(i == 0)
                prefixArr[0] = 1;
            else {
                //pre-computed prefix product
                prefixArr[i] = prefixArr[i-1]*nums[i-1];
            }
        }
        int product = 1;
        for(int j=n-1;j>=0;j--) {
            
            if(j == n-1)
                prefixArr[n-1] = prefixArr[n-1]*product;
            else {
                product = product*nums[j+1];
                prefixArr[j] = prefixArr[j]*product;
            }
        }
        return prefixArr;
    }
}
