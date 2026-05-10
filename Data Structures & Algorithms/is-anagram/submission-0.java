class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        System.out.println(Arrays.toString(c1));
        System.out.println(Arrays.toString(c2));

        for(int i = 0 ;i<s.length() ; i++){
            if(c1[i] != c2[i])return false;
        }
        return true;

    }
}
