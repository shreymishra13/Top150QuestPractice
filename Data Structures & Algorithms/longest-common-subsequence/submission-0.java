class Solution {
    private int longest(String text1 , String text2 , int i , int j , int dp[][]){
        //base case
        if(i == text1.length() || j == text2.length())return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int answer = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + longest(text1 , text2 , i+1 , j+1, dp);

        }
        return dp[i][j] = Math.max(longest(text1 , text2 , i+1 , j , dp) , longest(text1 , text2 , i, j+1 , dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        return longest(text1 , text2 , 0 , 0 , dp);
    }
}
