class MyStack {
    Queue<Integer> firstQ;
    Queue<Integer> secondQ;
    boolean isFirstTurn;

    public MyStack() {
        firstQ = new LinkedList<>();
        secondQ = new LinkedList<>();
        isFirstTurn = true;

    }
    
    public void push(int x) {
        if(isFirstTurn){
            firstQ.add(x);
        }else{
            secondQ.add(x);
        }
        
    }
    
    public int pop() {

        if(isFirstTurn){
            while(firstQ.size()>1){
                secondQ.add(firstQ.remove());

            }
            isFirstTurn = false;
            return firstQ.remove();
        }else{
             while(secondQ.size()>1){
                firstQ.add(secondQ.remove());

            }
            isFirstTurn = true;
            return secondQ.remove();

        }
        
    }
    
    public int top() {
         if(isFirstTurn){
            while(firstQ.size()>1){
                secondQ.add(firstQ.remove());

            }
            isFirstTurn = false;
            int top =  firstQ.remove();
            secondQ.add(top);
            return top;
        }else{
             while(secondQ.size()>1){
                firstQ.add(secondQ.remove());

            }
            isFirstTurn = true;
            int top =  secondQ.remove();
            firstQ.add(top);
            return top;

        }
    }
    
    public boolean empty() {
        if(isFirstTurn)return firstQ.isEmpty();
        return secondQ.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */