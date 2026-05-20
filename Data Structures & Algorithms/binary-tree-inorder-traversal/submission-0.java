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
    private void inorder(TreeNode root , List<Integer> inorderList){
        if(root == null)return ;

        inorder(root.left , inorderList);
        inorderList.add(root.val);
        inorder(root.right , inorderList);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)return new LinkedList<>();
        List<Integer> inorderList = new LinkedList<>();
        inorder(root , inorderList);
        return inorderList;
    }
}