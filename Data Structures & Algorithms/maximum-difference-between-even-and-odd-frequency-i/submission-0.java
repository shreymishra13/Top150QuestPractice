class Solution {
    public int maxDifference(String s) {
        //first store the frequency of each character 
        int charFreq[] = new int[26];
        for(char c : s.toCharArray()){
            charFreq[c - 97]++;
        }
        System.out.println(Arrays.toString(charFreq));
        // in the second pass find the maxOdd and minEven
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for(int count : charFreq){
            if(count == 0 )continue;
            if(count % 2==0 ){
                //even
                minEven = Math.min(minEven , count);
            }
            else{
                maxOdd = Math.max(maxOdd , count);
            }
        }
        //return the diff
        System.out.println(maxOdd+" ooo" + minEven);

        return maxOdd - minEven;
    }
}