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
class Solution {
    public ListNode reverseList(ListNode head) {
        // Iteration ver. - time: O(n), space: O(1)
        ListNode pre = null;
        ListNode current = head;
        while(current != null){
            ListNode nxt = current.next;
            current.next = pre;
            pre = current;
            current = nxt;
        }
        return pre;

    //     // recursive ver. - time: O(n), space: O(n)
    //     if(head == null)
    //         return null;
    //     ListNode newHead = head;
    //     if(head.next != null){
    //         newHead = reverseList(head.next);
    //         head.next.next = head;
    //     }
    //     head.next = null;
    //     return newHead;
    }
}