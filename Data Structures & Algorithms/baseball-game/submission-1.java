class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String operation : operations){
            if(operation.equals("+")){
                int first = st.pop();
                int second = st.peek();
                int third = first + second;
                st.push(first);

                st.push(third);

            }else if(operation.equals("D")){
                st.push(2*st.peek());

            }else if(operation.equals("C")){
                st.pop();
            }else{
                st.push(Integer.valueOf(operation));
            }
        }
        System.out.println(st);
        int totalPoints = 0;
        while(!st.isEmpty()){
            totalPoints += (st.pop());
        }
        return totalPoints;
    }
}