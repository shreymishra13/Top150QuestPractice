class Solution {
    private int min(String word1 , String word2 , int i , int j , int dp[][]){

        if(i == word1.length()){
            return word2.length()-j;
        }else if(j == word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j] != -1)return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return min(word1 ,word2 , i+1 , j+1 , dp);
        }else{
            int insertStep = min(word1 , word2 , i , j+1 , dp);
            int deleteStep = min(word1 , word2 , i+1 , j , dp);
            int replaceStep = min(word1 , word2 , i+1 , j+1 , dp);

            return dp[i][j] = Math.min(insertStep , Math.min(deleteStep , replaceStep))+1;
        }
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return min(word1 , word2 , 0 , 0 , dp);
    }
}
