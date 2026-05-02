class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)return true;
        if(s.length() % 2 != 0)return false;

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '[' || c == '{' || c=='('){
                st.push(c);
            }else{
                if(st.isEmpty())return false;
                char poppedChar = st.pop();

                if(
                    c == '}' && poppedChar =='{' ||
                    c == ']' && poppedChar =='[' ||
                    c == ')' && poppedChar =='('
                  ){
                    continue;
                  }
                  else{
                    return false;
                  }


            
            }
        }

        return st.isEmpty();
        
    }
}
