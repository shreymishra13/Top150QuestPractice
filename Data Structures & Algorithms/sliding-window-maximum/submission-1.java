class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1)return nums;
        if(k == nums.length){
            int max = Arrays.stream(nums).max().getAsInt();
            return new int[]{max};
        }

        SortedMap<Integer, Integer> sorted = new TreeMap<>(Collections.reverseOrder());

        //first adding first k elements
        for(int i = 0 ;i<k ;i++){
            sorted.put(nums[i], sorted.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(sorted.firstKey());
        
        int left =0;
        int right = k-1;
        while(right+1<nums.length){
            //first remove the left and add the right 
            if(sorted.get(nums[left]) == 1){
                sorted.remove(nums[left]);
            }else{
                sorted.put(nums[left], sorted.get(nums[left])-1);
            }
            left++;
            right++;
            
            sorted.put(nums[right], sorted.getOrDefault(nums[right] , 0)+1);
            // System.out.println(answer);
            answer.add(sorted.firstKey());
            
        }
       
       int answerArr[] = new int[answer.size()];
       for(int i = 0 ; i<answer.size() ; i++){
        answerArr[i] = answer.get(i);
       }





        return  answerArr;
    }
}
