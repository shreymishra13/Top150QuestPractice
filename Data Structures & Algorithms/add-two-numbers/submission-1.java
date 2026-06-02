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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        int carry = 0;
        ListNode sumHead = null;
        ListNode temp = sumHead;

        while (l1 != null && l2 != null) {
            int currSum = carry + l1.val + l2.val;
            int lastDigit = currSum % 10;
            carry = currSum / 10;
            if (sumHead == null) {
                sumHead = new ListNode(lastDigit);
                temp = sumHead;
            } else {
                temp.next = new ListNode(lastDigit);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int currSum = carry + l1.val;
            int lastDigit = currSum % 10;
            carry = currSum / 10;
            temp.next = new ListNode(lastDigit);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int currSum = carry + l2.val;
            int lastDigit = currSum % 10;
            carry = currSum / 10;
            temp.next = new ListNode(lastDigit);
            temp = temp.next;
            l2 = l2.next;
        }

        while (carry != 0) {
            int lastDigit = carry % 10;
            carry /= 10;
            temp.next = new ListNode(lastDigit);
            temp = temp.next;
        }

        return sumHead;
    }
}
