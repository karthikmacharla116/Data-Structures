Problem Link: https://leetcode.com/problems/find-the-pivot-integer/description/?envType=daily-question&envId=2024-03-13

class PivotInteger {
    public int pivotInteger(int n) {

        //two pointers
        int leftValue = 1, rightValue=n;
        int leftSum = leftValue;
        int rightSum = rightValue;

        if(n==1) return n;
        
        while(leftValue < rightValue) {
            if(leftSum < rightSum) {
                leftValue++;
                leftSum += leftValue;
            } else {
                rightValue--;
                rightSum += rightValue;
            }

            if(leftSum == rightSum && leftValue == rightValue)
                return leftValue;
        }
        return -1; 
    }
}
