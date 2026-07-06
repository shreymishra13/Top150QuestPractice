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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(root.val < key){
           root.right =  deleteNode(root.right , key);
        }else if (root.val > key){
            root.left = deleteNode(root.left , key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null)return root.left;

            // find InOrder successor
            TreeNode inOrderSucc = root.right;
            while(inOrderSucc.left != null){
                inOrderSucc = inOrderSucc.left;
            }

            inOrderSucc.left= root.left;
            TreeNode res = root.right ;
            
            root = null;
            return res;
            

        }

        return root;
    }
}