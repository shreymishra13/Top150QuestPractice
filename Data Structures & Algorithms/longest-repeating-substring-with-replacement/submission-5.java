class Solution {
    private int getMaxCount(Map<Character, Integer> charCountMap){
        
        int count = 0;
        for(Character c : charCountMap.keySet()){
            count  = Math.max(count , charCountMap.get(c));
        }
        return count;
    }
    public int characterReplacement(String s, int k) {
        if(s.length() <= k)return s.length();

        int left= 0;
        int right = 0;

        Map<Character, Integer> charCountMap = new HashMap<>();
        int res = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            charCountMap.put(c , charCountMap.getOrDefault(c , 0)+1);

            //calculate the mostFreqof Each element
            int maxCount = getMaxCount(charCountMap);
            int windowLen = right - left + 1;
            
            while(windowLen - maxCount > k){
                char c2 = s.charAt(left);
                charCountMap.put(c2 , charCountMap.get(c2)-1);
                maxCount = getMaxCount(charCountMap);
                windowLen--;
                left++;


            }
            res = Math.max(res , windowLen);
            right++;


        }
        return res;
        
    }
}
