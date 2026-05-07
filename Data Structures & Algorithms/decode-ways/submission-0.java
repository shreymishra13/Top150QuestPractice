class Solution {
    private int decode(String s, int index , int dp[]) {
       

        if(index == s.length())

            return 1;

        if(s.charAt(index) == '0')

            return 0;

        if(dp[index] != -1)

            return dp[index];
       
        int first = 0;
        if (s.charAt(index) != '0')
            first = decode(s, index + 1 , dp);

int second = 0;
        if (index < s.length() - 1) {
            Integer twoDigits = Integer.valueOf(s.substring(index, index + 2));
            
            if(twoDigits >= 10 && twoDigits <= 26) {
                second = decode(s, index + 2 , dp);
            }
        }

        dp[index] =  first + second;
        return dp[index];
    }
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        // early check for not possible results

        int dp[] = new int[s.length()+1];
        Arrays.fill(dp , -1);

        return decode(s, 0, dp);
    }
}
