class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int currentSum = 0;
        int result = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            result = Math.max(currentSum, result);
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return result;
    }
}