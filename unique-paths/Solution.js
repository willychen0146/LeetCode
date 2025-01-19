/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    // DP (Top-Down)
    // const dp = Array(m).fill().map(() => Array(n).fill(-1));

    // function dfs(i, j){
    //     // Base case
    //     if(i >= m || j >= n) return 0; // out of bound
    //     if(i === m-1 && j === n-1) return 1; // final position

    //     // If already computed this cell, return it
    //     if(dp[i][j] !== -1) return dp[i][j];
        
    //     // Calculate paths by going right and down
    //     dp[i][j] = dfs(i+1, j) + dfs(i, j+1);
    //     return dp[i][j];
    // }

    // return dfs(0, 0);

    // DP (Space optimize)
    let row = new Array(n).fill(1);

    for (let i = 0; i < m - 1; i++) {
        const newRow = new Array(n).fill(1);
        for (let j = n - 2; j >= 0; j--) {
            newRow[j] = newRow[j + 1] + row[j];
        }
        row = newRow;
    }
    return row[0];
};
