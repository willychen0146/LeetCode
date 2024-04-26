class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int total = (1+len)*len/2;
        for(int i = 0; i < len; i++){
            total -= nums[i];
        }
        if(total == 0)
            return 0;
        return total;
    }
}