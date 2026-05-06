class Solution {
    private void generate(int openLeft , 
                          int closeLeft , 
                          String currParentheses , List<String> allValidParentheses){
                        
        if(openLeft == 0 && closeLeft == 0){
            allValidParentheses.add(new String(currParentheses));
            return;
        }



        //we can choose open or close
        if(openLeft != 0)
        generate(openLeft -1 , closeLeft , currParentheses+"(" , allValidParentheses);

        if(closeLeft > openLeft){
            generate(openLeft , closeLeft-1 , currParentheses+")" , allValidParentheses);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> allValidParentheses = new LinkedList<>();
        generate(n , n , "" , allValidParentheses);
        return allValidParentheses;
    }
}
