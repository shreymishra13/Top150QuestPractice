class Solution {
    public static Map<Integer , String> numCharMap ;
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() ==0)return new ArrayList<>();

        //first Map the keys;
       numCharMap = new HashMap<>();
        numCharMap.put(2 , "abc");
        numCharMap.put(3 , "def");
        numCharMap.put(4 , "ghi");
        numCharMap.put(5 , "jkl");
        numCharMap.put(6 , "mno");
        numCharMap.put(7 , "pqrs");
        numCharMap.put(8 , "tuv");
        numCharMap.put(9 , "wxyz");

        List<String> resultCombinations = new LinkedList<>();
        createCombinations(digits , 0 , "" , resultCombinations);
        return resultCombinations;

    }

    private void createCombinations(String digits , int i , String currComb , List<String> allComb){
        //base case

        if(i == digits.length()){
            allComb.add(new String(currComb));
            return ;
        }



        int currNum = Integer.parseInt(digits.charAt(i)+"");
        String curr = numCharMap.get(currNum);

        for(int k = 0 ; k<curr.length() ; k++){
            createCombinations(digits , i+1 , currComb+curr.charAt(k), allComb);

        }

    }
}
