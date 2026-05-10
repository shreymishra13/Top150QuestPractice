class MinStack {
    
    Stack<int[]> st ;
    int minSoFar ;

    public MinStack() {
        st = new Stack<>();
        minSoFar = Integer.MAX_VALUE;

        
    }
    
    public void push(int val) {
        minSoFar = Math.min(minSoFar , val);
        st.push(new int[]{val , minSoFar});
    }
    
    public void pop() {
        if(st.isEmpty())return;
        st.pop();
        
    }
    
    public int top() {
              return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
        
    }
}
