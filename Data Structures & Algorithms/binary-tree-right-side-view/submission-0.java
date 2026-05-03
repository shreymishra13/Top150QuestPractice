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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> rightSideViewElements = new ArrayList<>();


        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode == null){
                if(q.isEmpty()){
                    return rightSideViewElements;
                }else{
                    q.add(null);

                }

            }else{
                if(q.peek() == null){
                    //found our rightmost element;
                    rightSideViewElements.add(currNode.val);

                }
                if(currNode.left != null)q.add(currNode.left);
                if(currNode.right != null)q.add(currNode.right);
            }
        }



       return rightSideViewElements;
        
    }
}
