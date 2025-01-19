
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    // One path solution (iterate only once)
    let l = 0;
    let r = nums.length - 1;
    let i = 0;

    const swap = (a, b) =>{
        const temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    while(i <= r){
        if(nums[i] == 0){
            swap(i, l);
            l++;
        }
        else if(nums[i] == 2){
            swap(i, r);
            r--;
            i--;
        }
        i++;
    }
    
};