/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    // setting initial state
    let start = 0;
    let end = nums.length - 1;

    // binary search
    while(end >= start){
        // Calculate the mid index
        let mid = Math.floor((start + end) / 2);
        let currentValue = nums[mid];

        // has found
        if (currentValue === target) {
            return mid;
        }

        // Check which side is sorted
        if (nums[start] <= currentValue) { // Left half is sorted
            if (target >= nums[start] && target < currentValue) {
                end = mid - 1; // Target is in the left half
            } else {
                start = mid + 1; // Target is in the right half
            }
        } else { // Right half is sorted
            if (target > currentValue && target <= nums[end]) {
                start = mid + 1; // Target is in the right half
            } else {
                end = mid - 1; // Target is in the left half
            }
        }
    }

    // not find
    return -1;
    
};
