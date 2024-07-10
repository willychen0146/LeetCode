class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length]; // all initiate as false
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j] ){
                    isIsland(grid, visited, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    public void isIsland(char[][] grid, boolean visited[][], int x, int y){
        if(x > grid.length-1 || y > grid[0].length-1 || x < 0 || y < 0 || grid[x][y] == '0' || visited[x][y]) return;
        visited[x][y] = true;
        isIsland(grid, visited, x+1, y);
        isIsland(grid, visited, x, y+1);
        isIsland(grid, visited, x-1, y);
        isIsland(grid, visited, x, y-1);
    }
}