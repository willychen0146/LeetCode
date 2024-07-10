class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];

        // compute prefix
        int prefix = 1;
        for(int i = 0; i < nums.length; i++){
            results[i] = prefix;
            prefix *= nums[i];
        }

        // compute postfix
        int postfix = 1;
        for(int i = nums.length-1; i >= 0; i--){
            results[i] *= postfix;
            postfix *= nums[i];            
        }

        return results;
    }
}