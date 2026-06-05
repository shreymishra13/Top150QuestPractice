class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder answer = new StringBuilder();

        while (i >= 0 && j >= 0) {
            int sum = carry
                    + (a.charAt(i) - '0')
                    + (b.charAt(j) - '0');

            answer.insert(0, sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        while (i >= 0) {
            int sum = carry + (a.charAt(i) - '0');

            answer.insert(0, sum % 2);
            carry = sum / 2;

            i--;
        }

        while (j >= 0) {
            int sum = carry + (b.charAt(j) - '0');

            answer.insert(0, sum % 2);
            carry = sum / 2;

            j--;
        }

        if (carry > 0) {
            answer.insert(0, carry);
        }

        return answer.toString();
    }
}