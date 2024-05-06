Problem Link: https://leetcode.com/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-05-06

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
class RemoveNodesInLinkedList {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);

        int maximum = head.val;
        ListNode prev = head;
        ListNode current = prev.next;
        while(current != null) {
            maximum = Math.max(maximum, current.val);

            if(current.val < maximum) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = node.next;

        while(current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }
}
