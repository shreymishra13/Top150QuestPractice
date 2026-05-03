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
    private void inOrderTraversal(TreeNode root, List<Integer> inorder){
        if(root == null)return;
        inOrderTraversal(root.left, inorder);
        inorder.add(root.val);
        inOrderTraversal(root.right, inorder);

    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();

        inOrderTraversal(root, inOrder);

        return inOrder.get(k-1);
    }
}
