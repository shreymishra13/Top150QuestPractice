class Solution {
    private void set(int[][] matrix){
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for(int i =0 ; i<matrix.length ; i++){
            for(int j = 0 ; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }


        for(int key : rowSet){
            for(int j = 0 ; j<matrix[key].length ; j++){
                matrix[key][j] = 0;
            }
        }

         for(int key : colSet){
            for(int i = 0 ; i<matrix.length ; i++){
                matrix[i][key] = 0;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
         set(matrix);
    }
}
