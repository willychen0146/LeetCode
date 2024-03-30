class Solution {
    public int climbStairs(int n) {
        // top down with memory array
        // if(n == 1)
        //     return 1;
        // if(n == 2)
        //     return 2;
        
        // int[] memo = new int[n+1];
        // memo[1] = 1;
        // memo[2] = 2;
        // for(int i = 3; i <= n; i++){
        //     memo[i] = memo[i-1] + memo[i-2];
        // }
        // return memo[n];

        // bottom up with two variable stored
        int one = 1;
        int two = 1;
        for(int i = 0; i < n-1; i++){
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}