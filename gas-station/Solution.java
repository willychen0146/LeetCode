class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Can not afford the cost
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;
        int res = 0;
        int total = 0;

        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }
}