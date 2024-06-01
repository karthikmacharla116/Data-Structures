Problem Link: https://leetcode.com/problems/score-of-a-string/description/?envType=daily-question&envId=2024-06-01

class ScoreOfString {
    public int scoreOfString(String s) {
        int sum = 0;
        for(int i=1;i<s.length();i++) 
            sum += Math.abs(s.charAt(i-1) - s.charAt(i));
        return sum;
    }
}
