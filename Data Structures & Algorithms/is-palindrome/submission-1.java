class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()<= 1)return true;


        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(
                (c >= 'a' && c <= 'z') || 
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9') 
            ){
                sb.append(c);
            }
        }

        String original = sb.toString().toUpperCase();
        String reversed = sb.reverse().toString().toUpperCase();




        return original.equals(reversed);
        
    }
}
