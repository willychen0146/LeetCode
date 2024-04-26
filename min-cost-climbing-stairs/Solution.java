class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] newCost = new int[cost.length + 1];
        for (int i = 0; i < cost.length; i++) {
            newCost[i] = cost[i];
        }
        newCost[newCost.length - 1] = 0;

        for(int i = newCost.length - 3; i >= 0; i--){
            newCost[i] += Math.min(newCost[i + 1], newCost[i + 2]);
        }
        
        return Math.min(newCost[0], newCost[1]);
    }
}