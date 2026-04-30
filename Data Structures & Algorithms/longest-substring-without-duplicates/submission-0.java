class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1)return 1;

        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;

        while(right < s.length() && left <= right){
            char currChar = s.charAt(right);
            if(set.contains(currChar)){
                maxLength = Math.max(right-left , maxLength);
                
                while(set.contains(currChar)){
                    char leftChar = s.charAt(left);
                    set.remove(leftChar);
                    left++;
                }

            }else{
                set.add(currChar);
                right++;
            }
        }

        return Math.max(right-left , maxLength);
        
    }
}
