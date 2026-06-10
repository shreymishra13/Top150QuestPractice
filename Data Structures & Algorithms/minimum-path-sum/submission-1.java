class Solution {
    private int minPath(int[][] grid , int i , int j , int[][] cache){
        //base case
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }


        if(i>=grid.length || j>=grid[0].length)return Integer.MAX_VALUE;
        if(cache[i][j] != -1)return cache[i][j];


        // two choices
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(i<grid.length){
            down = minPath(grid , i+1 , j, cache);
        }
        if(j<grid[0].length){
            right = minPath(grid , i , j+1, cache);
        }

        return cache[i][j]= Math.min(down , right)+grid[i][j];



    }
    public int minPathSum(int[][] grid) {
        int [][] cache = new int[grid.length][grid[0].length];
        for(int row[] : cache){
            Arrays.fill(row , -1);
        }
        return minPath(grid , 0 , 0 ,cache);
    }
}