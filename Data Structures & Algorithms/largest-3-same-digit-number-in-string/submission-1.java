class Solution {
    private boolean isValidSub(String s){
        return s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2);
    }
    public String largestGoodInteger(String num) {
        if(num.length() < 3)return "";
        String answer = "";

        for(int i = 0 ; i<=num.length()-3 ; i++){
            String subString = num.substring(i , i+3);
            if(isValidSub(subString)){
                if(answer.equals("")){
                    answer = subString;
                }else{
                    if(Integer.valueOf(answer) < Integer.valueOf(subString)){
                        answer = subString;
                    }


                }
            }
        }
        return answer;
        
        
    }
}