class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair of (index, height)

        // Iterate through the list of height
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];

                // Potential update the maxArea
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            // Update the stack
            stack.push(new int[] { start, heights[i] });
        }

        // Compute the element remain in the stack
        for (int[] element : stack) {
            int index = element[0];
            int height = element[1];

            // Potential update the maxArea
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}