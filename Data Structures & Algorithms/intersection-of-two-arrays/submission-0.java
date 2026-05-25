class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for(int num : nums1){
            num1Set.add(num);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for(int num : nums2){
            if(num1Set.contains(num)){
                intersectionSet.add(num);
            }
        }
        
        int intersectionArr[] = new int[intersectionSet.size()];
        int i = 0; 
        for(int num : intersectionSet){
            intersectionArr[i++] = num;
        }
        return intersectionArr;
    }
}