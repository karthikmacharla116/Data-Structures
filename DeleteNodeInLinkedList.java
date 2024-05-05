Problem Link: https://leetcode.com/problems/delete-node-in-a-linked-list/description/?envType=daily-question&envId=2024-05-05

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        ListNode next = node.next;

        while(next != null) {
            node.val = next.val;
            prev = node;
            node = next;
            next = next.next;
        }
        prev.next = null;
    }

}
