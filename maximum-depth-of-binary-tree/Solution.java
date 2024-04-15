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

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int maxDepth(TreeNode root) {
        // recursive dfs
        // if(root == null)
        //     return 0;
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // iterative dfs
        // if(root == null)
        //     return 0;
        // int result = 0;
        // Stack<TreeNode> stack_node = new Stack<>();
        // Stack<Integer> stack_depth = new Stack<>();
        // stack_node.push(root);
        // stack_depth.push(1);
        // while(!stack_node.isEmpty()){
        //     TreeNode node = stack_node.pop();
        //     int depth = stack_depth.pop();
        //     if(node != null){
        //         result = Math.max(result, depth);
        //         stack_node.push(node.left);
        //         stack_depth.push(depth + 1);
        //         stack_node.push(node.right);
        //         stack_depth.push(depth + 1);
        //     }
        // }
        // return result;

        // iterative bfs
        if (root == null) // if the tree is empty
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            level++;
        }
        return level;    
    }
}