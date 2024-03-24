import java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // method 1: use extra memory
        // ArrayList<TreeNode> nodeListp = new ArrayList<>();
        // ArrayList<TreeNode> nodeListq = new ArrayList<>();
        // BinarySearchTree(root, nodeListp, p);
        // BinarySearchTree(root, nodeListq, q);
        // int pointer = Math.min(nodeListp.size()-1, nodeListq.size()-1);
        // while(pointer > 0){
        //     if(nodeListp.get(pointer).val == nodeListq.get(pointer).val){
        //         return nodeListp.get(pointer);
        //     }
        //     else
        //         pointer--;
        // }
        // return root;

        // method 2: detect the split point directly, time: O(logn), space:O(1)
        TreeNode current = root;
        while(current != null){
            if(p.val > current.val && q.val > current.val)
                current = current.right;
            else if(p.val < current.val && q.val < current.val)
                current = current.left;
            else
                return current;
        }
        return null;
    }
    // public void BinarySearchTree(TreeNode root, ArrayList<TreeNode> nodeList, TreeNode x){
    //     if(root == null)
    //         return;
    //     nodeList.add(root);
    //     if(x.val == root.val)
    //         return;
    //     if(x.val > root.val)
    //         BinarySearchTree(root.right, nodeList, x);
    //     if(x.val < root.val)
    //         BinarySearchTree(root.left, nodeList, x); 
    // }
    // public void TraverseTree(TreeNode root, ArrayList<TreeNode> nodeList){
    //     if(root == null){
    //         return;
    //     }
    //     nodeList.add(root);
    //     TraverseTree(root.left, nodeList);
    //     TraverseTree(root.right, nodeList);
    //     return;
    // }
}