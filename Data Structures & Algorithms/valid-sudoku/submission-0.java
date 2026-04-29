class Solution {
    private boolean isValidRow(char[][] board , int row ){
        Set<Character> set = new HashSet<>();
        for(int j = 0 ; j<9 ;j++){
            if(board[row][j] != '.' && set.contains(board[row][j])){
                return false;
            }
            set.add(board[row][j]);
        }

        return true;
    }
    private boolean isValidCol(char[][] board , int col ){
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i<9 ;i++){
            if(board[i][col] != '.' && set.contains(board[i][col])){
                return false;
            }
            set.add(board[i][col]);
        }

        return true;
    }
    private boolean isValidSubMatrix(char[][]board, int row , int col){
        Set<Character> set = new HashSet<>();
        for(int i = row ; i<row+3 ;i++){
            for(int j = col ; j<col+3 ; j++){
                 if(board[i][j] != '.' && set.contains(board[i][j])){
                    return false;
                 }
                set.add(board[i][j]);
            }
            
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        boolean allRowsCheck = true;
        boolean allColCheck = true;
        boolean allSubMatricesCheck = true;

        for(int i = 0 ; i<9 ;i++){
            allRowsCheck = isValidRow(board , i);
            if(!allRowsCheck)return false;
        }

         for(int j = 0 ; j<9 ;j++){
            allColCheck = isValidCol(board , j);
            if(!allColCheck)return false;
        }

        for(int i= 0 ;i<9 ;i+=3){
            for(int j = 0 ; j<9 ;j+= 3){
                allSubMatricesCheck = isValidSubMatrix(board , i , j);
                if(!allSubMatricesCheck)return false;
            }
        }
        return true;

    }
}
