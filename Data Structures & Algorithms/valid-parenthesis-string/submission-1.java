class Solution {

    private boolean solve(String s, int idx, int open , Boolean cache[][]) {

    if(open < 0) return false;

    if(idx == s.length())
        return open == 0;

    if(cache[idx][open] != null)return cache[idx][open];

    char ch = s.charAt(idx);

    if(ch == '(')
        return solve(s, idx+1, open+1 , cache);

    if(ch == ')')
        return solve(s, idx+1, open-1 , cache);

    return cache[idx][open] = solve(s, idx+1, open+1 , cache) ||   // *
           solve(s, idx+1, open-1 , cache) ||   // *
           solve(s, idx+1, open , cache);       // empty
}
    public boolean checkValidString(String s) {
        Boolean cache[][] = new Boolean[s.length()][s.length()];
        
        return solve(s , 0 , 0 , cache);
    }
}
