Problem Link: https://leetcode.com/problems/implement-queue-using-stacks/description/?envType=daily-question&envId=2024-01-29

class MyQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int x) {
        stackPush.push(x);
    }

    public int pop() {
        if (stackPop.isEmpty()) {
            transferElements();
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.isEmpty()) {
            transferElements();
        }
        return stackPop.peek();
    }

    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    private void transferElements() {
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
