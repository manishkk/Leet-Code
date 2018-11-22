class Solution {
    public int numIslands(char[][] grid) {

        if(grid == null) return 0;
        int isNumberOfIsland = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    //count the islands
                    ++isNumberOfIsland;
                    //make all neighbors zeros
                    changeLandToWater(grid, i, j);
                }
            }
        }
        return isNumberOfIsland;
    }

    public void changeLandToWater(char[][] grid,int i,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') 
            return;
        
        //base conditions: (It will breake the recursive when below conditions are met)
        //1)row < 0 (Check row is -1)
        //2)row > row.length (Check row is more than length)  
        //3)col < 0 (Check column is -1)
        //4)col > col.length (Check column is more than length)
        //5)if grid[row][col] is '0'; (Check grid possition is water)
        grid[i][j] = '0';
        changeLandToWater(grid, i-1, j); //Down
        changeLandToWater(grid, i+1, j); //up
        changeLandToWater(grid, i, j-1); //left
        changeLandToWater(grid, i, j+1); //right
    }
}



