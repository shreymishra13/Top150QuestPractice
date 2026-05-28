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
    private void post(TreeNode root , List<Integer> values){
        if(root == null)return ;
        post(root.left , values);
        post(root.right , values);
        values.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> answer = new LinkedList<>();
        post(root , answer);


        return answer;
    }
}