Problem Link: https://leetcode.com/problems/merge-in-between-linked-lists/description/?envType=daily-question&envId=2024-03-20

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
class MergeBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        //find the ath, bth node
        ListNode startNode = list1;
        ListNode endNode = list1;
        
        for(int i=0;i<b;i++) {
            if(i == a-1)
                startNode = endNode;
            endNode = endNode.next;
        }

        startNode.next = list2;

        ListNode temp = list2;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = endNode.next;

        return list1;
    }

}
