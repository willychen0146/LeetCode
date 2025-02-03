class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>(); // [index, temperature]
        int[] res = new int[temperatures.length];

        // Iterate through the array
        for(int i = 0; i < temperatures.length; i++){
            // Current element
            int temp = temperatures[i];
            // If stack is not empty and find a temperature is warmer than the top element in the stack
            while(!stack.isEmpty() && temp > stack.peek()[1]){
                // Pop the element that be found
                int[] pair = stack.pop();
                // This result is calculated by the difference between two index
                res[pair[0]] = i - pair[0]; // Current - the position smaller than current
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return res;   
    }
}