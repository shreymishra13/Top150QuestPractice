class Solution {
    public int lastStoneWeight(int[] stones) {
       List<Integer> stonesList = new LinkedList<>();
       for(int stone : stones){
            stonesList.add(stone);
       }
       while(stonesList.size()>1){
            Collections.sort(stonesList);
            System.out.println(stonesList);
           int last = stonesList.get(stonesList.size()-1);
           int secondLast = stonesList.get(stonesList.size()-2);
           if(last == secondLast){
                stonesList.remove(stonesList.size()-1);
                stonesList.remove(stonesList.size()-1);
           }else{
                stonesList.set(stonesList.size()-2 , Math.abs(last - secondLast));
                stonesList.remove(stonesList.size()-1);
           }
           System.out.println(stonesList);
       }

       if(stonesList.size()== 0)return 0;
       return stonesList.get(0);
       
    }
}
