class Solution {
    private void canReach(int[][]heights ,int i , int j , Set<String>ocean , boolean isVis[][]){
        //base case
        if(isVis[i][j])return;

        //we can go to four sides
        isVis[i][j] = true;
        ocean.add(i+","+j);
        //add all its neighbor
        int dx[] = { 0 , 0 , -1 , 1};
        int dy[] = {1 , -1 , 0 , 0 };

        for(int k = 0 ; k<4 ;k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || ny < 0 || nx >= heights.length || ny >= heights[0].length || heights[nx][ny] < heights[i][j]){
                continue;
            }
            canReach(heights , nx , ny , ocean , isVis);

        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();
        int m = heights.length;
        int n = heights[0].length;

        // first add the cell which can reach pacific
        boolean isVis[][] = new boolean[m][n];
       
       //first row 
       for(int i = 0 ; i<n ; i++){
        canReach(heights , 0 , i , pacific , isVis);
       }
       for(int i = 0 ; i<m ; i++){
        canReach(heights , i , 0 , pacific , isVis);
       }

       //now for atlantic

       isVis = new boolean[m][n];
       
       //first row 
       for(int i = 0 ; i<n ; i++){
        canReach(heights , m-1 , i , atlantic , isVis);
       }
       for(int i = 0 ; i<m ; i++){
        canReach(heights , i , n-1 , atlantic , isVis);
       }

       System.out.println(pacific);
       System.out.println(atlantic);
       List<List<Integer>> answer = new LinkedList<>();
       for(String cell : pacific){
            if(atlantic.contains(cell)){
                String parts[] = cell.split(",");
                List<Integer> currCell = new LinkedList<>();
                currCell.add(Integer.parseInt(parts[0]));
                currCell.add(Integer.parseInt(parts[1]));
                answer.add(currCell);
            }
       }

       return answer;




    }
}
