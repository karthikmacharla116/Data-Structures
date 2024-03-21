Problem Link: https://leetcode.com/problems/reverse-linked-list/?envType=daily-question&envId=2024-03-21

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
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        ListNode nextNode = null;
        while (node != null) {
            nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
        
    }
}
