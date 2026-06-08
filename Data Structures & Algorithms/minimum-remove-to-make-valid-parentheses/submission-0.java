class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> st = new Stack<>();
        Set<Integer> removableParenthesis = new HashSet<>();
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == '(')st.push(i);
            else if(s.charAt(i) == ')'){
                if(!st.isEmpty())st.pop();
                else removableParenthesis.add(i);
            }
        }

        while(!st.isEmpty())removableParenthesis.add(st.pop());
        System.out.println(removableParenthesis);
        StringBuilder res = new StringBuilder();

        for(int i =0 ; i<s.length();i++){
            if(removableParenthesis.contains(i))continue;
            res.append(s.charAt(i));
          
        }
        return res.toString();
    }
}