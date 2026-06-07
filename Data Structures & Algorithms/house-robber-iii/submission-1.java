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
    private int optimizedRob(TreeNode root , Map<TreeNode , Integer> cache){
        if(cache.containsKey(root))return cache.get(root);

        //we have two choices , 
        // if we opt for current node, we have to 
        // skip the immediate children.
        //choosen case;
        int res = root.val;
        if(root.left != null){
            res += optimizedRob(root.left.left ,cache) + optimizedRob(root.left.right ,cache);
        }
        if(root.right != null){
            res += optimizedRob(root.right.left,cache) + optimizedRob(root.right.right,cache);
        }

         cache.put(root,Math.max(res , optimizedRob(root.left,cache)+optimizedRob(root.right,cache)));

        return cache.get(root);
    }
    public int rob(TreeNode root) {
        Map<TreeNode , Integer> cache = new HashMap<>();
        cache.put(null , 0);
        return optimizedRob(root , cache);
      

    }
}