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
  

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        ListNode leftEnding = null;
        ListNode midStarting = null;
        ListNode rightStarting = null;
        ListNode midEnding = null;
        int i = 1;
        ListNode temp = head;
        if (left == 1) {
            midStarting = head;
        } else {
            
            
            while (i < left-1) {
                temp = temp.next;
                i++;
            }
           
            leftEnding = temp;
            midStarting = temp.next;

            temp = midStarting;
            i = left;
           
        }

        while (i < right) {
            i++;
            temp = temp.next;
        }
        midEnding = temp;
        rightStarting = temp.next;

        midEnding.next = null;

        // now reversing the main section
        ListNode prev = null;
        ListNode curr = midStarting;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(leftEnding != null)
        leftEnding.next = midEnding;
        midStarting.next = rightStarting;

        if(left == 1)return prev;
        

        return head;
    }
}