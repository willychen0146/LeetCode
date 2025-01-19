/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function(nums) {
    // If the total sum is odd, it can't be split into two equal subsets
    const totalSum = nums.reduce((sum, num) => sum + num, 0);
    if (totalSum % 2 !== 0) {
        return false;
    }

    // Create a set
    let dp = new Set();
    dp.add(0);
    const target = totalSum / 2;

    for (let i = nums.length - 1; i >= 0; i--) {
        const nextDP = new Set();
        for (const t of dp) {
            if (t + nums[i] === target) {
                return true;
            }
            nextDP.add(t + nums[i]);
            nextDP.add(t);
        }
        dp = nextDP;
    }
    return false;
};
