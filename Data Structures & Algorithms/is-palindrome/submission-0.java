class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() <= 1)return true;

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if((c >= 'a' && c<='z') || (c >='0' && c<='9') || (c >= 'A' && c <= 'Z')){
                sb.append(Character.toLowerCase(c));
            }
        }
      

        String str = sb.toString();
        

        return str.equals( sb.reverse().toString());
        
    }
}
