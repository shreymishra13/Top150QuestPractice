class Solution {
    private int countBit(int x){
        int count = 0;
        for(int i = 0 ; i<32 ; i++){
            count+= (x&1);
            x>>=1;
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] bitCount = new int[n+1];

        for(int i = 0 ; i<= n ;i++){
            bitCount[i] = countBit(i);
        }
        System.out.println(Arrays.toString(bitCount));
        return bitCount;
    }
}
