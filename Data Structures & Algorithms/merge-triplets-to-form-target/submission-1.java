class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //first find the list of potential triplets.

        List<int[]> validTriplets = new LinkedList<>();
        for(int[] triplet : triplets){
            if(target[0] >= triplet[0] && target[1] >= triplet[1] && target[2] >= triplet[2]  ){
                validTriplets.add(triplet);
            }
        }
        if(validTriplets.size()==0)return false;

        int answer[] = validTriplets.get(0);
        for(int i = 1 ; i<validTriplets.size() ; i++){
            answer[0] = Math.max(answer[0] , validTriplets.get(i)[0]);
             answer[1] = Math.max(answer[1] , validTriplets.get(i)[1]);
              answer[2] = Math.max(answer[2] , validTriplets.get(i)[2]);
        }

        
        return 
        target[0] == answer[0] 
        && target[2] == answer[2] 
        && target[1] == answer[1]  
        ;
    }
}
