Problem Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/description/

class BitWiseAndInRange {
    public int rangeBitwiseAnd(int left, int right) {
        
        while(right > left) {
            right = right & right-1; //last set bit removal 
        }
        return right;
    }
}
