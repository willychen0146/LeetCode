class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1; // two pointer
        int maxProfit = 0;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }
            else{
                l = r; // directly shift l to the minimum position
            }
            r += 1;
        }
        return maxProfit;        
    }
}