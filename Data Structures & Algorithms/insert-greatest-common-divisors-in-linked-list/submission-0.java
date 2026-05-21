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
    private int findGCD(int a , int b){
        int m = Math.max(a , b);
        int n = Math.min(a,b);

        while(n != 0){
            int rem = m%n;
            m = n;
            n = rem;
            
        }
        return m ;

    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null)return head;

        ListNode curr = head;

        while(curr.next != null){
            ListNode next = curr.next;
            int gcd = findGCD(curr.val , next.val);
            ListNode newNode = new ListNode(gcd , next);
            curr.next = newNode;
            curr = next;
        }

        return head;
     
    }
}