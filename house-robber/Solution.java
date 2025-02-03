class Solution {
    public int rob(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        cache[1] = Math.max(nums[0], nums[1]); // Choose one

        for (int i = 2; i < nums.length; i++) {
            cache[i] = Math.max(cache[i - 1], cache[i - 2] + nums[i]); // Choose -1 or -2 + current
        }

        return cache[nums.length - 1];
    }
}