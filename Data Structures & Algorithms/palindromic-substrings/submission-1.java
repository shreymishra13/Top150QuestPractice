class Solution {
    private boolean isPalindrome(String s){
        // System.out.println(s);
        if(s== null || s.length() <= 1)return true;

        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left ) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        //get all the substrings
        if(s == null)return 0;
        if(s.length() <= 1)return 1;
        int n = s.length();
        int count = 0 ;
        for(int i =0 ; i<n ;i++){
            for(int j = i+1 ;j<=n ; j++){
                if(isPalindrome(s.substring(i , j)))count++;
            }
        }
        return count;
    }
}
