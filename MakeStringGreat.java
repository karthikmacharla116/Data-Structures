Problem Link: https://leetcode.com/problems/make-the-string-great/description/?envType=daily-question&envId=2024-04-05

Approach 1: Using Stack
class MakeStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));

        for(int i=1;i<s.length();i++) {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && Character.toLowerCase(stack.peek()) != Character.toLowerCase(ch)) {
                stack.push(ch);
            } else if(!stack.isEmpty()) {
                if(Character.isLowerCase(ch)) { 
                    if(Character.isUpperCase(stack.peek())) {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else if(Character.isLowerCase(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

Appraoch 2: Optimized
class MakeStringGreat {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (sb.length() > 0 && Math.abs(sb.charAt(sb.length() - 1) - ch) == 32) {
                // Check if the current character cancels the last character in the string
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Otherwise, append the current character to the string
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
