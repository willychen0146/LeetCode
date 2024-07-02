import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int l = i + 1;
            int r = nums.length - 1;

            while(l < r){
                int threeSum = nums[i] + nums[l] + nums[r];
                if(threeSum > 0) r--;
                else if(threeSum < 0) l++;
                else{
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while(nums[l] == nums[l-1] && l < r) l++;
                }
            }
        }
        return result;
    }
}