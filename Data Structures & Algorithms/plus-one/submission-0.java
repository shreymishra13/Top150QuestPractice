class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        if(digits[size-1] <= 8){
            digits[size-1]++;
            return digits;
        }

        List<Integer> answerList = new LinkedList<>();

        int carry = 0;
        int sum = digits[digits.length-1]  + 1;
        answerList.addFirst(sum % 10);
        carry =  sum / 10;

        for(int i = digits.length-2 ;i>= 0 ; i--){
             sum = digits[i] + carry ;
            answerList.addFirst(sum % 10);
            carry =  sum / 10;
        }
        if(carry > 0){
            answerList.addFirst(carry);
        }

        int answer[] = new int[answerList.size()];
        for(int i = 0 ; i<answerList.size() ;i++){
            answer[i]= answerList.get(i);
        }        

        return answer;
    }
}
