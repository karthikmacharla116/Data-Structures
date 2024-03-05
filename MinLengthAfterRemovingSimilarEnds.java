Problem Link: https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/?envType=daily-question&envId=2024-03-05

class MinLengthAfterRemovingSimilarEnds {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right && s.charAt(left) == s.charAt(right)) {
            char c = s.charAt(left);

            //expanding left, right
            while(left<right && s.charAt(left) == c)
                left++;
            
            while(left<=right && s.charAt(right) == c)
                right--;
        }

        return right-left+1;
    }
}
