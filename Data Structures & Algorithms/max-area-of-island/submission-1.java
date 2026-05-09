class Solution {
    private static int dx[] = {0 , 0 , -1 , 1};
    private static int dy[] = {-1 , 1 , 0 , 0};
    private int dfs(int grid[][] , int m , int n ,
                    int x , int y , Set<String> visitedSet){

                        //base case 
                        if(visitedSet.contains(x+","+y))return 0;


                        int currArea = 1;
                        visitedSet.add(x+","+y);
                        //add all its neighbor area
                        for(int i = 0 ;i<4 ; i++){
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            //check for current cell
                            if(nx < 0 || ny < 0 ||
                                nx >= m || ny >= n ||
                                grid[nx][ny] == 0 ||
                                visitedSet.contains(nx+","+ny)
                                ){
                                    continue;
                                }
                                currArea += dfs(grid , m , n , nx , ny , visitedSet);
                           
                        }

                        return currArea;



                    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        Set<String> visitedSet = new HashSet<>();
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ;j++){
                if(grid[i][j] == 1){
                   maxArea = Math.max( dfs(grid , m , n , i , j , visitedSet ), maxArea);
                }
            }
        }
        return maxArea;
    }
}
