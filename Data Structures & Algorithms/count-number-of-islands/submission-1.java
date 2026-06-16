class Solution {
    public int numIslands(char[][] grid) {
        
        //first find all the starting potential points to run
        //BFS/DFS 
        // for every new start position count the num 
        // that is our starting point

        Queue<int[]> allPotentialIslands = new LinkedList<>();

        for(int i = 0 ;i<grid.length ;i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    allPotentialIslands.add(new int[]{i,j});
                }
            }
        }

        //edge if there is no island 
        if(allPotentialIslands.isEmpty())return 0;
        int countOfIslands = 0;

        boolean isVis[][]= new boolean[grid.length][grid[0].length];

        while(!allPotentialIslands.isEmpty()){
            int currIsland[] = allPotentialIslands.remove();
            if(isVis[currIsland[0]][currIsland[1]])continue;
            countOfIslands++;
            dfs(grid , currIsland[0] , currIsland[1] , isVis);
        }

        return countOfIslands;

        //now running the BFS ;

    }
    private static int[] dx = {0, 0 , -1 , 1};
    private static int[] dy = {-1 , 1 , 0 , 0};
    private void dfs(char[][] grid , int i , int j , boolean isVis[][]){
        //base case

        if(
            i>= grid.length || j >= grid[0].length ||
            i<0 || j<0
            || isVis[i][j] || grid[i][j] == '0'

          )return ;

          isVis[i][j] = true;

        //   visit all its connected component

        for(int k = 0 ; k<4 ;k++){
            int ni = i + dx[k];
            int nj = j + dy[k];

            if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length ||
                isVis[ni][nj] || grid[ni][nj] =='0'
            )continue;
            dfs(grid, ni , nj , isVis);

        }

    }
}
