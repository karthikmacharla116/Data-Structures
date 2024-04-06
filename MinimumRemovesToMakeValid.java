Problem Link: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/?envType=daily-question&envId=2024-04-06

class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(ch);
                sb.append(ch);
            } else if(ch == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }

        while(!stack.isEmpty()) {
            int lastIndex= sb.lastIndexOf("(");
            sb.deleteCharAt(lastIndex);
            stack.pop();
        }
        return sb.toString();
    }
}

Optimized:
class Solution {
    public String minRemoveToMakeValid(String s) {

        int leftBraces = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                leftBraces++;
            } else if(ch == ')') {
                if(leftBraces==0)
                    continue;
                leftBraces--;
            }
            sb.append(ch);
        }

        while(leftBraces>0) {
            int lastIndex= sb.lastIndexOf("(");
            sb.deleteCharAt(lastIndex);
            leftBraces--;
        }
        return sb.toString();
    }
}
