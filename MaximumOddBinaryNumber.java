Problem Link: https://leetcode.com/problems/maximum-odd-binary-number/?envType=daily-question&envId=2024-03-01

class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int zeros = 0;
        int ones = 0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '1')
                ones++;
            else
                zeros++;
        }

        //
        StringBuilder result = new StringBuilder();
        for(int i=0; i<ones-1;i++)
            result.append("1");
        for(int i=0; i<zeros;i++)
            result.append("0");
        result.append("1");
        return result.toString();        
    }
}
