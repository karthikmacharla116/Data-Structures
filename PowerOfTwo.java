Problem Link: https://leetcode.com/problems/power-of-two/description/?envType=daily-question&envId=2024-02-19

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
