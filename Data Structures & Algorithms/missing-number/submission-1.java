class Solution {
    public int missingNumber(int[] nums) {
      int n = nums.length;
    //   int sum = 0;
    //   for(int num : nums){
    //     sum += num;
    //   }  
    //   int sumFromFormula = (n*(n+1)) / 2 ;

    //   return sumFromFormula - sum;

        int xor = n;
        for(int i = 0 ; i<n; i++){
            xor ^= i;
            xor ^= nums[i];
        }
        return xor;

    }
}
