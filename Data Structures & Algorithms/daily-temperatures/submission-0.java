class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1)return new int[]{0};
        
        Stack<Integer> st = new Stack<>();
        int[] warmerDaysInFuture = new int[temperatures.length];


        for(int j = temperatures.length- 1 ; j>= 0 ;j-- ){
            if(st.isEmpty()){
                warmerDaysInFuture[j]=0;
                st.push(j);

            }else{
                if(temperatures[st.peek()]>temperatures[j]){
                    warmerDaysInFuture[j]=1;
                    st.push(j);
                }else{
                    
                    while(!st.isEmpty() && temperatures[st.peek()]<= temperatures[j]){
                        st.pop();
                        
                    }
                    if(st.isEmpty()){
                        warmerDaysInFuture[j]=0;
                        st.push(j);
                    }else{
                        warmerDaysInFuture[j]=st.peek() - j;
                        st.push(j);
                    }
                }
            }
        }
        return warmerDaysInFuture;
    }
}
