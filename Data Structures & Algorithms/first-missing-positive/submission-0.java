class Solution {
    public int firstMissingPositive(int[] nums) {

       Set<Integer> positiveSet = new HashSet<>();
       for(int num : nums){
            if(num >0)
            positiveSet.add(num);

       }

       for(int i = 1 ; i<Integer.MAX_VALUE; i++){

            if(!positiveSet.contains(i))return i;

       }
       return 0;
        
    }
}