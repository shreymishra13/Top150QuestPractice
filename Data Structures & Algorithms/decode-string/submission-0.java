class Solution {
    public String decodeString(String s) {
        if(s.length()== 1)return s;

        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<s.length()){
            char currChar = s.charAt(i);
            if(currChar != ']'){
                
                st.push(currChar);
                i++;

            }else{
            String currWord = "";
            while(st.peek() != '['){
                currWord = st.pop() + currWord;
            }
            //remove the opening bracket now - '['
            st.pop();
            //now get the number
            String number = "";
            while(!st.isEmpty() && st.peek()>= '0' && st.peek()<='9'){
                number = st.pop()+number;
            }
            int num = Integer.parseInt(number);
            for(int k = 0 ;k < num ;k++){
                for(char c : currWord.toCharArray()){
                    st.push(c);
                }
            }
            i++;
            }
        }

        String decodedString ="";

        while(!st.isEmpty()){
            decodedString = st.pop()+decodedString;

        }
        return decodedString;
        
    }
}