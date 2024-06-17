Problem Link: https://leetcode.com/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-06-17

Note:- Similar to 2-sum problem

class SumOfSqrNums {
    public boolean judgeSquareSum(int c) {
        //two pointers
        long a = 0;
        long b = (long)Math.ceil(Math.sqrt(c));

        while(a<=b) {
            long res = a*a + b*b;
            if(res == c)
                return true;
            else if (res < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}
