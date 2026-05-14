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
   
    private ListNode mergeTwoList(ListNode l1 , ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;

        ListNode finalHead = null;
        ListNode temp = null;

        if(l1.val<= l2.val){
            finalHead = l1 ;
            l1 = l1.next;
        }else{
            finalHead = l2 ;
            l2 = l2.next;
        }
         temp = finalHead;

        while(l1 != null  && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1 ;
                l1 = l1.next;
                temp = temp.next;
            }else{
                temp.next = l2 ;
                l2 = l2.next;
                temp = temp.next;

            }
        }
        if(l1 == null){
            temp.next = l2;
        }
        if(l2 == null){
            temp.next = l1;
        }




        return finalHead;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode finalHeadForKLists = null;
        for(int i = 0 ; i< lists.length ;i++){
           finalHeadForKLists =  mergeTwoList(finalHeadForKLists , lists[i]);
                    }

        return finalHeadForKLists ;
    }
}
