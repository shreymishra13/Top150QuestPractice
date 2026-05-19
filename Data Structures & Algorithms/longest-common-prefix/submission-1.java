class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)return strs[0];
        String temp = strs[0];

        for(int i = 1; i<strs.length ; i++){
            //now compare two words
            StringBuilder sb = new StringBuilder();
            for(int k = 0 ; k<Math.min(temp.length(), strs[i].length()) ; k++ ){
                if(temp.charAt(k) == strs[i].charAt(k)){
                    sb.append(temp.charAt(k));
                }else{

                    break;
                }

            
            }
            temp = sb.toString();
        }

        return temp;
    }
}