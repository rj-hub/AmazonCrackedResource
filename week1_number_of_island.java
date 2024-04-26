class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < rows;  i++){
            for(int j = 0; j < cols; j++) {
                if(Objects.equals(grid[i][j],'1')) {
                    count++;
                    dpf(grid,i,j);
                }
            }
        }
        return count;
    }

    void dpf(char[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(x<0 || x>=rows || y<0 || y>=cols || Objects.equals(grid[x][y],'0'))
            return;
        
        grid[x][y] = '0';

        dpf(grid,x+1,y);
        dpf(grid,x-1,y);
        dpf(grid,x,y+1);
        dpf(grid,x,y-1);
    }
}
