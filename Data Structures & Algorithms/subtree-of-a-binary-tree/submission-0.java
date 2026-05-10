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
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || q == null && p!= null)return false;
        if(p == null && q == null)return true;
        if(p.val != q.val)return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right , q.right);

        return left && right ;


        
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)return true;
        if(root == null)return false;

        return isSameTree(root, subRoot) || isSameTree(root.left , subRoot) || isSameTree(root.right, subRoot);
    }
}
