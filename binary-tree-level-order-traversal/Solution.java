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

import java.util.ArrayList;
import java.util.Queue;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // bfs
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            var layer = new ArrayList<Integer>();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                if(node == null) continue;
                layer.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(layer);
        }
        
        return result;
    }
}