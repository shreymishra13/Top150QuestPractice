class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;

        int prePro[] = new int[size];
        prePro[0]= nums[0];
        int postPro[] = new int[size];
        postPro[size-1] = nums[size-1];

        for(int i = 1 ; i<size ;i++){
            prePro[i] = prePro[i-1] * nums[i];
        }

        for(int j = size-2 ; j>=0 ; j--){
            postPro[j] = postPro[j+1]*nums[j];
        }

        int[] prodArr = new int[size];
        prodArr[0] = postPro[1];
        prodArr[size-1] = prePro[size-2];
        for(int i = 1 ;i<size-1; i++){
            prodArr[i] = prePro[i-1] * postPro[i+1];
        }

        return prodArr;



       
    }
}  
