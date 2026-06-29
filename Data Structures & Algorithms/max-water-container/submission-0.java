class Solution {
    public int maxArea(int[] heights) {
       int left = 0;
       int right = heights.length-1;
       int maxArea = -1;

       while(left <right){
            //calculate the water in current 
            int width = right - left;
            int height = Math.min(heights[left] , heights[right]);
            maxArea = Math.max(maxArea , width*height);
            if(heights[left] < heights[right]){
                left++;
            }
            else {
                right--;
            }
       } 

       return maxArea;
    }
}
