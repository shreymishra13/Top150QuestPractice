class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word2 == null || word2.length()==0)return word1;
        if(word1 == null || word1.length()==0)return word2;
        StringBuilder sb = new StringBuilder();
        int i =0 ;
        int j = 0 ;
        boolean isFirstTurn = true;

        while(i<word1.length() && j<word2.length()){
            if(isFirstTurn){
                sb.append(word1.charAt(i));
                i++;
                
            }else{
                sb.append(word2.charAt(j));
                j++;
            }
            isFirstTurn = !isFirstTurn;

        }

        if(i<word1.length()){
            sb.append(word1.substring(i));
        }
        if(j<word2.length()){
            sb.append(word2.substring(j));
        }
        return sb.toString();

    }
}