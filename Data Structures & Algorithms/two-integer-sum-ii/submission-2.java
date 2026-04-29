class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        if(numbers.length == 2)return new int[]{1,2};

        int left = 0;
        int right = numbers.length-1;

        while(numbers[left] + numbers[right] != target){
            if(numbers[left] + numbers[right] < target){
                left++;
            }
            else{
                right--;
            }
        }

        return new int[]{left+1, right+1};

    }
}
