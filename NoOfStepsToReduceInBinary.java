Problem Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/?envType=daily-question&envId=2024-05-29

class NoOfStepsToReduceInBinary {
    public int numSteps(String s) {
        int cnt=0;

        int carry = 0;
        for(int i=s.length()-1;i>=1;i--) {
            if((s.charAt(i)-'0' + carry) %2  == 1) {
                cnt += 2;
                carry = 1;
            } else {
                cnt++;
            }
        }
        return cnt+carry;
    }
}
