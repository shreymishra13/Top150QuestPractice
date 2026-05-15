class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      List<int[]> cars =  new LinkedList<>();
      for(int i = 0 ; i<position.length ;i++){
        cars.add(new int[]{position[i] ,speed[i] });

      } 
       Collections.sort(cars , (a , b)->{
        return b[0] - a[0];
      });
        for(int[] car : cars)System.out.println(Arrays.toString(car));
   
        Stack<int[]> st = new Stack<>();
        st.add(cars.get(0));
        System.out.println(st);
        int i = 1;
        while( i < position.length){
            int[] currCar = cars.get(i);
            int[] topCar = st.peek();

            //check the condition
            double firstCarTime = (double)(target-currCar[0])/currCar[1] ;
            double secondCarTime = (double)(target - topCar[0]) /  topCar[1] * 1.0;
           
            if(firstCarTime > secondCarTime){
                st.push(currCar);
            }
            i++;
        }
        return st.size();
    }
}
