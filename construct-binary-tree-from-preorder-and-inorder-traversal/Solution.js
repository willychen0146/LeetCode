/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    // Depth First Search (Time: O(N^2), Space: O(N^2))
    // // Base case
    // if(!preorder.length || ! inorder.length) return null;

    // // Build the tree
    // const root = new TreeNode(preorder[0]);
    // const mid = inorder.indexOf(preorder[0]);

    // root.left = buildTree(
    //     preorder.slice(1, mid + 1),
    //     inorder.slice(0, mid)
    // )
    // root.right = buildTree(
    //     preorder.slice(mid + 1, preorder.length),
    //     inorder.slice(mid + 1, preorder.length)
    // )

    // return root;

    // HashMap (Time: O(N), Space: O(N))
    let pre_idx = 0;
    let indices = new Map();
    
    inorder.forEach((val, i) => indices.set(val, i));
    
    function dfs(l, r) {
        if (l > r) return null;
        let root_val = preorder[pre_idx++];
        let root = new TreeNode(root_val);
        let mid = indices.get(root_val);
        root.left = dfs(l, mid - 1);
        root.right = dfs(mid + 1, r);
        return root;
    }
    
    return dfs(0, inorder.length - 1);
};
