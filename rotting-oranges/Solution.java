import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        // 0: empty cell, 1: orange, 2 rotten orange
        Queue<int[]> queue = new LinkedList<>();

        int time = 0;
        int fresh = 0;

        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];
                for (int[] dir : dirs) {
                    int x = r + dir[0], y = c + dir[1];
                    if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] { x, y });
                        fresh -= 1;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}