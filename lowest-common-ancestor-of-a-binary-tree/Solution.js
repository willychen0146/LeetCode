/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    // Base case: if the tree is empty or we find one of the nodes
    if (root == null || root == p || root == q) {
        return root;
    }
    // Search for p and q in the left and right subtrees
    let l = lowestCommonAncestor(root.left, p, q);
    let r = lowestCommonAncestor(root.right, p, q);

    // If p and q are found in different subtrees, the current root is their LCA
    if(l && r){
        return root;
    }
    // Otherwise, return the non-null result (either left or right)
    return l || r;
};
