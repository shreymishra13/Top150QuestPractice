class Solution {
    public boolean lemonadeChange(int[] bills) {

        int countOf5 = 0;
        int countOf10 = 0;
        int countOf20 = 0;

        for(int bill : bills){
            if(bill == 5)countOf5++;
            else if(bill == 10){
                if(countOf5 > 0){
                    countOf10++;
                    countOf5--;
                }else{
                    return false;
                }

            }else{
                //bill == 20
                if(countOf10 > 0 && countOf5>0){
                    countOf10--;
                    countOf5--;
                 
                }else if(countOf5 >= 3){
                    countOf5-=3;
                    

                }else{
                    return false;
                }
                countOf20++;

            }
        }

        return true;
        
    }
}