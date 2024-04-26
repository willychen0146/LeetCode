class Solution {
    public int[] plusOne(int[] digits) {
        final int len = digits.length;
        int[] newDigits = new int[len+1];
        int carry = 1;
        int current = 0;
        for(int i = len-1; i >= 0; i--){
            current = digits[i] + carry;
            if(current > 9){
                digits[i] = current%10;
                newDigits[i+1] = digits[i];
                carry = 1;
            }
            else{
                digits[i] = current;
                newDigits[i+1] = digits[i];
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}