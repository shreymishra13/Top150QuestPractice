class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        if(n==0)return new int[]{};
        int answer[] = new int[2*n];
        for(int i = 0 ; i<2*n ; i++){
            
            answer[i] = nums[i%n];

        }
        return answer;
    }
}