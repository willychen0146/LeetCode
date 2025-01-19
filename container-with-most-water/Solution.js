/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let l = 0;
    let r = height.length - 1;
    let maxArea = 0;

    while(r > l){
        maxArea = Math.max((r - l) * Math.min(height[l], height[r]), maxArea);
        if(height[r] > height[l]){
            l++;
        }
        else{
            r--;
        }
    }
    return maxArea;
};
