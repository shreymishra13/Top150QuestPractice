class Solution {
   
    public String simplifyPath(String path) {
    
        if(path.length() <=1)return "/";
        Stack<Character> st = new Stack<>();
        

        for(int i = 0 ; i<path.length();){
            if(path.charAt(i) == '/'){
                if(st.isEmpty() || st.peek() != '/'){
                    st.push('/');
                }
                i++;

            }else{
                int j = i;
                while(j<path.length() && path.charAt(j) != '/'){
                    j++;
                }
                String currSubPath = path.substring(i , j);
                if(currSubPath.equals(".")){
                    st.pop();
                }else if(currSubPath.equals("..")){
                    st.pop();
                    while(!st.isEmpty() && st.peek() != '/')st.pop();
                }else{
                    for(char c : currSubPath.toCharArray()){
                        st.push(c);
                    }
                }
                i= j;
            }
        }

        // System.out.println(st);
        String simplifiedPath = "";
        if(st.isEmpty())return "/";
        while(!st.isEmpty()){
            simplifiedPath = st.pop() + simplifiedPath;
        }
        if(simplifiedPath.length() > 1 && simplifiedPath.charAt(simplifiedPath.length()-1) =='/'){
            return simplifiedPath.substring(0 , simplifiedPath.length()-1);
        }
        
       

        return simplifiedPath;
        
    }
}