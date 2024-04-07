Problem Link: https://leetcode.com/problems/valid-parenthesis-string/description/?envType=daily-question&envId=2024-04-07

class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else { // ch == ')'
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.peek() <= starStack.peek()) {
                openStack.pop();
                starStack.pop();
            } else {
                break;
            }
        }

        return openStack.isEmpty();
    }
}
