class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n+1];
        for(int i = 0; i <= n; i++){
            output[i] = bitSum(i);
        }
        return output;
    }

    public int bitSum(int n){
        int result = 0;
        while(n != 0){
            n &= n-1;
            result++;
        }
        return result;
    }
}