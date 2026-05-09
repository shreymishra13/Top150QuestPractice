class Solution {
    private static int[] dx = {0 , -1 , 1 , 0};
    private static int[] dy = {-1 , 0 , 0 , 1};
    private void dfs(char[][]grid , int m , int n , int x , int y , Set<String> visitedSet){

        //base case
        if(visitedSet.contains(x+","+y))return;

        visitedSet.add(x+","+y);
        //visit all it's neighbor
        for(int i = 0 ; i<4 ;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <0 || nx >= m || ny <0 || ny>=n 
                     || grid[nx][ny] == '0' || visitedSet.contains(nx+","+ny)){
                continue;
            }
            dfs(grid , m , n , nx , ny , visitedSet);
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int m  = grid.length ;
        int n = grid[0].length;

        Set<String> visitedSet = new HashSet<>();

        for(int i = 0 ;i<m ; i++){
            for(int j = 0 ; j< n ; j++){
                if(grid[i][j] == '0' || visitedSet.contains(i+","+j)){
                    continue;
                }
                //valid land
                //call dfs
                count++;
                dfs(grid , m , n , i , j , visitedSet);
            }
        }

        return count;

        
        
    }
}
