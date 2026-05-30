class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length ;
        int newM = n;
        int newN = m;

        int[][] transposedMatrix = new int[newM][newN];

        int x = 0;
        int y = 0;

        for(int i = 0 ;i<m ;i++){
            for(int j = 0 ;j<n ;j++){
                transposedMatrix[x][y] = matrix[i][j];
                x++;
            }
            x= 0;
            y++;
        }
        return transposedMatrix;
    }
}