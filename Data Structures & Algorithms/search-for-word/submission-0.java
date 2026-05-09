class Solution {
    
    public boolean exist(char[][] board, String word) {
        //first find all the possible. starting point/cell from the grid
        // and run the dfs in each of them
        int m = board.length;
        int n = board[0].length;
       
        for(int i = 0 ;i<m ; i++){
            for(int j = 0 ;j<n ;j++){
                if(Character.toUpperCase(board[i][j]) == Character.toUpperCase(word.charAt(0))){
                    Set<String> visitedSet = new HashSet<>();
                 if( dfs(board , word , 0 , visitedSet , i, j ))return true;
                }
            }
        }
       
        return false;
    }
  private boolean dfs(char[][] board,

                        String word,

                        int index,

                        Set<String> visitedSet,

                        int x,

                        int y) {

        // matched whole word

        if (index == word.length()) {

            return true;

        }

        // invalid cases

        if (x < 0 || y < 0 ||

            x >= board.length ||

            y >= board[0].length ||

            visitedSet.contains(x + "," + y) ||

            board[x][y] != word.charAt(index)) {

            return false;

        }

        visitedSet.add(x + "," + y);

        int[] dx = {0, 0, -1, 1};

        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];

            int ny = y + dy[i];

            if (dfs(board, word, index + 1,

                    visitedSet, nx, ny)) {

                return true;

            }

        }

        // backtrack

        visitedSet.remove(x + "," + y);

        return false;

    }
}
