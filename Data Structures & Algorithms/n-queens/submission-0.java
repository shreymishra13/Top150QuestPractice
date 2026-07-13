class Solution {
     List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
       answer = new LinkedList<>();
        if(n == 1){
            answer.add(Arrays.asList("Q"));
            return answer;
        }

        //first create the empty board of N x N  size
        char[][] board = createEmptyBoard(n);

        backtrack(board, 0 );

       
        
       
        return answer ;
        
    }
    private void backtrack(char[][] board , int row){
        if(row == board.length){
            List<String> currBoard = new ArrayList<>();
            for(char[] r : board){
                currBoard.add(new String(r));
            }
            answer.add(currBoard);
            return;

        }

        for(int i = 0 ;i< board.length ;i++){
            if(canPlace(board, row , i)){
                board[row][i] = 'Q';
                 backtrack(board , row+1);
                 board[row][i] = '.';
            }
        }



    }

   private boolean canPlace(char[][] board, int row, int col) {

    int n = board.length;

    // Check column
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 'Q') {
            return false;
        }
    }

    // Top-left diagonal
    for (int i = row - 1, j = col - 1;
         i >= 0 && j >= 0;
         i--, j--) {

        if (board[i][j] == 'Q') {
            return false;
        }
    }

    // Top-right diagonal
    for (int i = row - 1, j = col + 1;
         i >= 0 && j < n;
         i--, j++) {

        if (board[i][j] == 'Q') {
            return false;
        }
    }

    return true;
}

    private char[][] createEmptyBoard(int n){
        char [][] emptyBoard = new char[n][n];
        for(int i = 0 ;i<n ;i++){
            for(int j = 0 ; j<n ; j++){
                emptyBoard[i][j] = '.';
            }
        }

        return emptyBoard;
    }


   

   
}
