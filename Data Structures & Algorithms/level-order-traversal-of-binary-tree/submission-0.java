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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<List<Integer>> levelOrderTraversal = new LinkedList<>();
        List<Integer> currLevel = new LinkedList<>();

        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode == null){
                if(q.isEmpty()){
                    levelOrderTraversal.add(currLevel);
                    return levelOrderTraversal;
                }else{
                    levelOrderTraversal.add(currLevel);
                    currLevel = new LinkedList<>();
                    q.add(null);
                }

            }else{
                currLevel.add(currNode.val);
                if(currNode.left != null)q.add(currNode.left);
                if(currNode.right != null)q.add(currNode.right);

            }

        }

        return new LinkedList<>();
        
    }
}
