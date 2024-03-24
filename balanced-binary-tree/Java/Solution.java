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
    public boolean isBalanced(TreeNode root) {
        boolean result;
        if(Dfs(root)[0] == 1)
            result = true;
        else
            result = false;
        return result;
    }
    public int[] Dfs(TreeNode root){
        if(root == null)
            return new int[]{1, 0};
        // int[] left, right
        int[] left = Dfs(root.left);
        int[] right = Dfs(root.right);
        int balanced;
        if((left[0] == 1 && right[0] == 1 && 
           (Math.abs(left[1]-right[1])) <= 1))
            balanced = 1;
        else
            balanced = 0;
        return new int[]{balanced, 1 + Math.max(left[1], right[1])};
    }
}