/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    // Time: N! * N^2
    // Space: N! * N

    // Base case: empty array
    if(nums.length === 0){
        return [[]];
    }

    // Calculate every permute
    let perms = permute(nums.slice(1));
    let result = [];

    // Compute perms
    for(const p of perms){
        for(let i = 0; i <= p.length; i++){
            let p_copy = [...p];
            p_copy.splice(i, 0, nums[0]);
            result.push(p_copy);
        }
    }

    return result;
};
