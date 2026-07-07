class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftPro  = 1;
        int rightPro = 1;
        int ans = nums[0];


        for(int i = 0 ; i<n ; i++){
            leftPro = leftPro == 0 ? 1 : leftPro;
            rightPro = rightPro == 0 ? 1 : rightPro;

            leftPro *= nums[i];
            rightPro *= nums[n-i-1];

            ans = Math.max(ans , Math.max(leftPro , rightPro));
        }
        return ans;
    }
}
