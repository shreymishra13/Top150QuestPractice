class Solution {
    private int countNumOfWays(int m , int n , int i , int j){

        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i >= m || j >= n)return 0;

        // either I can move down 
        int down = countNumOfWays(m , n , i+1 , j);
        // or move right
        int right = countNumOfWays(m , n , i , j+1);

        return down + right;

    }
    public int uniquePaths(int m, int n) {
        if(m ==1 && n==1)return 1;
        return countNumOfWays(m , n , 0 , 0 );
    }
}
