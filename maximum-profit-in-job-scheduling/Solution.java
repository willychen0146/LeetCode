class Solution {
    class Job {
        int start, end, profit;
        
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        // Sort jobs based on start time
        Arrays.sort(jobs, (a, b) -> a.start - b.start);
        
        // Cache for memoization
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        
        return dfs(jobs, 0, cache);
    }

    private int dfs(Job[] jobs, int index, int[] cache) {
        if (index >= jobs.length) {
            return 0;
        }
        
        if (cache[index] != -1) {
            return cache[index];
        }
        
        // Option 1: Skip the current job
        int skipProfit = dfs(jobs, index + 1, cache);
        
        // Option 2: Take the current job and find the next non-overlapping job
        int takeProfit = jobs[index].profit;
        int nextIndex = findNextJob(jobs, index);
        if (nextIndex != -1) {
            takeProfit += dfs(jobs, nextIndex, cache);
        }
        
        // Cache the result
        cache[index] = Math.max(skipProfit, takeProfit);
        return cache[index];
    }
    
    private int findNextJob(Job[] jobs, int index) {
        int low = index + 1;
        int high = jobs.length - 1;
        int result = -1;
        
        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].start >= jobs[index].end) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
}