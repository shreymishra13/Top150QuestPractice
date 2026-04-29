class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs){
            sb.append(word.length()).append(":;:").append(word);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> wordList = new LinkedList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiter = str.indexOf(":;:", i);
            int length = Integer.parseInt(str.substring(i, delimiter));
            i = delimiter + 3;
            String word = str.substring(i, i + length);
            wordList.add(word);
            i += length;
        }
        return wordList;
    }
}