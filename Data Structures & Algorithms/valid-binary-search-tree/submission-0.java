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
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;

        boolean isValidLeftSubTree = isValidBST(root.left);
        boolean isValidRightSubTree = isValidBST(root.right);

        boolean isCurrNodeValid = true;

        if(root.right != null && root.right.val <= root.val){
            isCurrNodeValid = false;
        }
        if(root.left != null && root.left.val >= root.val){
            isCurrNodeValid = false;
        }

        return isValidLeftSubTree && isValidRightSubTree && isCurrNodeValid;
       
        
    }
}
