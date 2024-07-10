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
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, Integer lowerBound, Integer upperBound){
        if(root == null) return true;

        if(lowerBound != null && lowerBound >= root.val){
            return false;
        }
        if(upperBound != null && upperBound <= root.val){
            return false;
        }
        if(!dfs(root.right, root.val, upperBound)){
            return false;
        }
        if(!dfs(root.left, lowerBound, root.val)){
            return false;
        }
        return true;  
    }
}