/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    const result = [];
    const subset = [];
    
    const dfs = (i) => {
        // Base case
        if(i >= nums.length){
            result.push([...subset]);
            return;
        }

        // Include nums[i]
        subset.push(nums[i]);
        dfs(i + 1);

        // Not to include nums[i]
        subset.pop();
        dfs(i + 1);
    }
    dfs(0);

    return result;
};
