class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() <=1 || k >= s.length())return s.length();

        int left = 0;
        int right = 0;

        char distinctChar = s.charAt(right);
        int maxLength = 0;
        int temp = k;
        while(right < s.length()){
            char currChar = s.charAt(right);
            if(distinctChar == currChar){
                right++;
            }else {
                if(temp > 0){
                    temp--;
                    right++;

                }else{
                    maxLength = Math.max(right-left , maxLength);
                    while(distinctChar == s.charAt(left)){
                        left++;
                    }
                    right = left;
                    distinctChar = s.charAt(left);
                    temp = k;
                }
            }
        }

        return Math.max(right-left , maxLength);
       
        
    }
}
