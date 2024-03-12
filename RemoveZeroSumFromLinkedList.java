Problem Link: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/?envType=daily-question&envId=2024-03-12

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
class RemoveZeroSumFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null)
        return head;
        ListNode current=head;
        int sum=0;
        while(current!=null) 
        {
            sum+=current.val;
            if(sum==0) 
            {
                head=current.next;
                return removeZeroSumSublists(head);
            }
            current=current.next;
        }
        head.next=removeZeroSumSublists(head.next);
        return head;
    }
}
