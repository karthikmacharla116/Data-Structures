Problem Link: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/?envType=daily-question&envId=2024-05-07

Optimized but not efficient:
class Solution {
    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = node.next;

        while(current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        
        head = reverse(head);
        //update the values
        int result = 0;
        int quotient = 0;

        ListNode node = head;
        while(node != null) {
            int val = node.val;
            result = val*2 + quotient;

            node.val = result%10;
            result = result/10;
            quotient = result;

            node = node.next;
        }

        head = reverse(head);
        if(quotient > 0) {
            ListNode temp = new ListNode(quotient);
            temp.next = head;
            return temp;
        }
        return head;
    }
}


Using Stack:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class DoubleValuesLinkedList {
    public ListNode doubleIt(ListNode head) {
        Stack<Integer> stack = new Stack();

        ListNode node = head;
        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }

        //iterate through stack and create new List
        int carry = 0;
        
        ListNode newTail = null;

        while(!stack.isEmpty() || carry !=0) {
            int value = !stack.isEmpty()?stack.pop()*2:0;
            newTail = new ListNode(carry + value%10, newTail);
            carry = value/10;
        }
        return newTail;

    }
}
