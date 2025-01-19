/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    let left = 0;
    let right = matrix[0].length;
    let top = 0;
    let bottom = matrix.length;
    const result = [];

    // spiral loop
    while(left !== right && top !== bottom){
        // get all the i from left -> right
        for(let i = left; i < right; i++){
            result.push(matrix[top][i]);
        }
        top++;

        // get all the i from top -> bottom
        for(let i = top; i < bottom; i++){
            result.push(matrix[i][right - 1]);
        }
        right--;

        // prevent one col or one row issue
        if(top >= bottom || left >= right){
            break;
        }

        // get all the i from right -> left
        for(let i = right - 1; i >= left; i--){
            result.push(matrix[bottom - 1][i]);
        }
        bottom--;

        // get all the i from bottom -> top
        for(let i = bottom - 1; i >= top; i--){
            result.push(matrix[i][left]);
        }
        left++;
    }
    return result;
};
