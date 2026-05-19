class Solution {
    private static int[] dx = {0 , 0 , -1 , 1};
    private static int[] dy = {-1 , 1 , 0 , 0};

    private int calculateIslandPerimeter(int[][] grid , int x , int y , boolean isVis[][]){
            //base case 

            if(isVis[x][y])return 0;

        int currPerimeter = 4;
        isVis[x][y] = true;
        for(int i = 0 ; i< 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || ny < 0 || nx >= grid.length 
                      || ny >= grid[0].length 
                      || grid[nx][ny] == 0 )continue;
            currPerimeter--;
            currPerimeter += (calculateIslandPerimeter(grid , nx , ny , isVis));
        }
        return currPerimeter;


    }
    public int islandPerimeter(int[][] grid) {
        
        //Start with any land cell
        // the perimeter of current Cell will be 
        // 4 - valid cell / land cell connected directly to it 
        // in four directions

       for(int i = 0 ; i < grid.length ;i++){
        for(int j = 0 ; j<grid[0].length ;j++){

            if(grid[i][j] == 1){
                return calculateIslandPerimeter(grid , i , j , new boolean[grid.length][grid[0].length] );
            }

        }
       }

       return -1;
        

    }
}