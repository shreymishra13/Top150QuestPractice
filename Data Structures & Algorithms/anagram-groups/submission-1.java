class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         if(strs.length == 0)return new LinkedList<>();

        Map<String, List<String>> wordAnagramsMap = new HashMap<>();

        for(String word : strs){
            if(word.length() == 0){
                 wordAnagramsMap.putIfAbsent("" , new LinkedList<>());
                 

            }
            char arr[] = word.toCharArray();
            Arrays.sort(arr);
            String sortedWord = new String(arr);
            wordAnagramsMap.putIfAbsent(sortedWord , new LinkedList<>());
            wordAnagramsMap.get(sortedWord).add(word);

        }
        List<List<String>> groupedAnagrams = new LinkedList<>();


        for(String key : wordAnagramsMap.keySet()){
            groupedAnagrams.add((wordAnagramsMap.get(key)));
        }
        
        return groupedAnagrams;
        
    }
}
