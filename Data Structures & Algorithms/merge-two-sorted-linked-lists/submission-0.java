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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode mergedListHead = null;
        ListNode currNode = null;
        if (list1.val <= list2.val) {
            mergedListHead = list1;
            currNode = list1;
            list1 = list1.next;

        } else {
            mergedListHead = list2;
            currNode = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currNode.next = list1 ;
                list1 = list1.next;
                currNode = currNode.next;
            } else {
                currNode.next = list2 ;
                list2 = list2.next;
                currNode = currNode.next;    
            }
        }

        if(list1 != null){
            currNode.next = list1;
        }
        if(list2 != null){
            currNode.next = list2;
        }

        return mergedListHead;
    }
}