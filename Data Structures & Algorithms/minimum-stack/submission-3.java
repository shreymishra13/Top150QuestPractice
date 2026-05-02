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
    if (st.isEmpty()) return;

    st.pop();

    if (!st.isEmpty()) {
        minSoFar = st.peek()[1];
    } else {
        minSoFar = Integer.MAX_VALUE;
    }
}
    
    public int top() {
              return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
        
    }
}
