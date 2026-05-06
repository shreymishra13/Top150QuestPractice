class Solution {
    public void islandsAndTreasure(int[][] grid) {
       //first find out all the tresure points and then start BFS from them

        int m = grid.length;
        int n = grid[0].length;
       Queue<int[]> q = new LinkedList<>();
       for(int i = 0 ;i<m ;i++){
        for(int j = 0 ; j<n ;j++){
            if(grid[i][j] == 0){
                q.add(new int[]{i,j});
            }
        }
       }
        int dx[] = {0 , -1 , 0 , 1};
        int dy[] = {1 , 0 , -1 , 0};
       while(!q.isEmpty()){
            int[] currCell = q.poll();
            int x = currCell[0];
            int y = currCell[1];

            for(int i = 0 ; i<4 ; i++){
                int nx = x+dx[i];
                int ny = y + dy[i];

                if( nx<0 ||
                    ny<0 ||
                    nx >= m ||
                    ny >= n ||
                    (grid[nx][ny] >= -1 && grid[nx][ny] != 2147483647)
                  ){
                    continue;
                  }
                
                grid[nx][ny] = grid[x][y]+1;
                q.add(new int[]{nx , ny});
            }
            
            

       }


    }
}
