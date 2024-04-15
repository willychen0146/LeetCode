import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        // // method 1: HashMap
        // HashMap<Integer, Integer> count = new HashMap<>();
        // for(int i=0; i < nums.length; i++){
        //     count.put(nums[i], 1+count.getOrDefault(nums[i], 0));
        //     if(count.get(nums[i]) > nums.length/2)
        //         return nums[i];
        // }
        // return -1;

        // method 2: The Boyer Moore String Search Algorithm 
        int count = 0;
        int current = 0;
        for(int i=0; i < nums.length; i++){
            if(count == 0)
                current = nums[i];
            if(current == nums[i])
                count++;
            else
                count--;
        }
        return current;
    }
}