
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    result = [];

    const dfs = (i, current, totalSum) => {
        // sum equal to target
        if(totalSum === target){
            result.push([...current]); // Push a copy of `current`, call by reference !!!
            return;
        }

        // exceed to target or out of range
        if(i >= (candidates.length) || totalSum > target){
            return;
        }

        current.push(candidates[i]);
        // continue searching with the same element
        dfs(i, current, totalSum + candidates[i]);
        current.pop();

        // search the next element
        dfs(i + 1, current, totalSum);
    }

    dfs(0, [], 0);

    // return result
    return result;
};