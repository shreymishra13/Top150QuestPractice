class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String , List<String>> wordAnagramMap = new HashMap<>();

        for(String word : strs){
            char chars[] = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            wordAnagramMap.putIfAbsent(sortedWord , new LinkedList<>());
            wordAnagramMap.get(sortedWord).add(word);
           
        }


        List<List<String>> anagrams = new LinkedList<>();
        for(String key : wordAnagramMap.keySet()){
            anagrams.add(wordAnagramMap.get(key));
        }
        
        return anagrams;

        


    }
}
