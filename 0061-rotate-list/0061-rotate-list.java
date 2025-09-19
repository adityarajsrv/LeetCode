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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int length = length(head);
        k = k % length;

        for(int i=0; i<k; i++){
            ListNode current = head;
            while(current.next.next!=null){
                current = current.next;
            }
            ListNode last = current.next;
            current.next = null;
            last.next = head;
            head = last;
        }
        return head;
    }

    private int length(ListNode head){
        int result = 0;
        ListNode current = head;
        while(current!=null){
            result++;
            current = current.next;
        }
        return result;
    }
}