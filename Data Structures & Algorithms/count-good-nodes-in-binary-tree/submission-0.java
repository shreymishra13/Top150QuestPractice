/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int countGoodNodes(TreeNode root , int maxTillNow){
        if(root == null)return 0;

       
        int left = countGoodNodes(root.left , Math.max(maxTillNow , root.val));
        int right = countGoodNodes(root.right , Math.max(maxTillNow , root.val));

        if(root.val >= maxTillNow){
            return left + right + 1;
        }
        return left + right;
        

    
    }
    public int goodNodes(TreeNode root) {
       return countGoodNodes(root , Integer.MIN_VALUE);
        
    }
}
