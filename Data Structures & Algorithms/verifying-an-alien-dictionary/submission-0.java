class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charPosMap = new HashMap<>();

        int k=0 ;
        for(char o : order.toCharArray()){
            charPosMap.put(o,k);
            k++;
        }
        String[] originalWords = words.clone();
        Arrays.sort(words , (a , b)->{
            for(int i =0 ; i<Math.min(a.length(), b.length());i++){
                if(a.charAt(i) != b.charAt(i)){
                    return charPosMap.get(a.charAt(i)) - charPosMap.get(b.charAt(i));
                }
            }
            return a.length()-b.length();
        });

        return Arrays.equals(words , originalWords);
    }
}