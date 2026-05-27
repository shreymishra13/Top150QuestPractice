class Solution {
    private boolean checkPalindrome(String s){
        if(s == null)return false;
        if(s.length() <= 1)return true;

        int left = 0;
        int right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))return false;
            left++;
            right--;
        }
        return true;

    }
    public boolean validPalindrome(String s) {
        if(s == null)return false;
        if(s.length() <= 1)return true;

        if(checkPalindrome(s))return true;

        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                //found our first non-matching element
                // check each of them separately by removing 
                // the left and right element

                return checkPalindrome(s.substring(0,left)+s.substring(left+1)) ||
                        checkPalindrome(s.substring(0,right) + s.substring(right+1));   
            }
            left++;
            right--;
        }
        return false;
    }
}