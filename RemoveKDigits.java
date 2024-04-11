Problem Link: https://leetcode.com/problems/remove-k-digits/

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            
            while(k > 0 && !stack.isEmpty() && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            
            stack.push(digit);
        }
        
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        int start = 0;
        while(start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        
        return (start == sb.length()) ? "0" : sb.substring(start);
    }
}
