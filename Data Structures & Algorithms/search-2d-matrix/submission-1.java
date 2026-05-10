class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //first find the correct row 
        int topRow = 0;
        int bottomRow = matrix.length-1;
        int m = matrix.length;
        int n = matrix[0].length;

        int finalRow=0;
        while(topRow <= bottomRow){
            int midRow = topRow+(bottomRow - topRow)/2;
            if(matrix[midRow][0] <= target && matrix[midRow][n-1] >= target){
                //found our row 
                finalRow = midRow;
                break;
            }
            else if(matrix[midRow][n-1] < target){
                topRow = midRow +1;
            }
            else{
                bottomRow = midRow-1;
            }
        }
        System.out.println(finalRow);
        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[finalRow][mid] == target)return true;
            else if(matrix[finalRow][mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return false;
        
        
        
        
        
        //and then find the correct column
    }
}
