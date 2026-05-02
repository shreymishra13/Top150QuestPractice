class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0 )return 0;

        Stack<Integer> st = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for(String token : tokens){
            if(operators.contains(token)){
                int second = st.pop();
                int first = st.pop();
                if(token.equals("+")){
                    st.push(first+second);
                }else if(token.equals("-")){
                    st.push(first - second);
                }else if(token.equals("*")){    
                    st.push(first * second);
                    
                }else if(token.equals("/")){
                    st.push(first / second);
                }

                
            }else{
                st.add(Integer.valueOf(token));
            }
        }

        return st.peek();
        
        
    }
}
