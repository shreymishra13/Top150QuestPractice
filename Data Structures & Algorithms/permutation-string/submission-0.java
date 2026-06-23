class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // for window of size s1 in s2 check 
        // if the count of elements are equal if yes return true 
        // return false;

        if(s1.length() > s2.length())return false;

        int countInS1[] = new int[26];
        int countInS2[] = new int[26];

        for(char c : s1.toCharArray()){
            countInS1[c-'a']++;
        }
        int left = 0;
        int right = 0;

        while(right < s1.length()){
            countInS2[s2.charAt(right)-'a']++;
            right++;
        }
        if(compareArr(countInS1 , countInS2))return true;

        while(right < s2.length()){
            countInS2[s2.charAt(left)-'a']--;
            countInS2[s2.charAt(right)-'a']++;

             if(compareArr(countInS1 , countInS2))return true;
             left++;
             right++;
            
        }

       

       

        return false;
     }
     private boolean compareArr(int a[] , int b[]){
        for(int i = 0 ;i<26; i++){
            if(a[i] != b[i])return false;
        }
        return true;
     }
}
