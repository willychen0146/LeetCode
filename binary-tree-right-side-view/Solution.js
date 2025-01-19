/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    const result = [];

    // bfs
    const q = new Queue();
    q.push(root);
    while(!q.isEmpty()){
        let rightSide = null;
        const len = q.size();

        for(let i = 0; i < len; i++){
            const node = q.pop();
            if(node){
                rightSide = node;
                q.push(node.left);
                q.push(node.right);
            }
        }
        if(rightSide){
            result.push(rightSide.val);
        }
    }

    return result;
};
