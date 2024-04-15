import java.util.Stack;

class Solution {
    public String addBinary(String a, String b) {
        // brute force method
        // StringBuilder output = new StringBuilder("");
        // Stack<Character> stackA = new Stack<>();
        // Stack<Character> stackB = new Stack<>();
        // for(int i=0; i < a.length(); i++)
        //     stackA.push(a.charAt(i));
        // for(int i=0; i < b.length(); i++)
        //     stackB.push(b.charAt(i));
        // int extra = 0;
        // while(!stackA.isEmpty() && !stackB.isEmpty()){
        //     int bitA = stackA.pop() - '0';
        //     int bitB = stackB.pop() - '0';
        //     int temp = bitA+bitB+extra;
        //     if(temp == 3){
        //         output.append('1');
        //         extra = 1;
        //     }
        //     else if(temp == 2){
        //         output.append('0');
        //         extra = 1;
        //     }
        //     else if(temp == 1){
        //         output.append('1');
        //         extra = 0;
        //     }
        //     else if(temp == 0){
        //         output.append('0');
        //         extra = 0;                
        //     }
        // }
        // while(!stackA.isEmpty()){
        //     int temp = (stackA.pop() - '0') + extra;
        //     if(temp == 2){
        //         output.append('0');
        //         extra = 1;
        //     }
        //     else if(temp == 1){
        //         output.append('1');
        //         extra = 0;
        //     }
        //     else if(temp == 0){
        //         output.append('0');
        //         extra = 0;                
        //     }
        // }
        // while(!stackB.isEmpty()){
        //     int temp = (stackB.pop() - '0') + extra;
        //     if(temp == 2){
        //         output.append('0');
        //         extra = 1;
        //     }
        //     else if(temp == 1){
        //         output.append('1');
        //         extra = 0;
        //     }
        //     else if(temp == 0){
        //         output.append('0');
        //         extra = 0;                
        //     }
        // }
        // if(extra == 1)
        //     output.append('1');
              
        // String result = output.reverse().toString();
        // return result;

        // straight forward method
        StringBuilder output = new StringBuilder("");
        StringBuilder RevA = new StringBuilder(a).reverse();
        StringBuilder RevB = new StringBuilder(b).reverse();
        int carry = 0;
        for(int i=0; i< Math.max(RevA.length(), RevB.length()); i++){
            int charA;
            int charB;
            if(i < RevA.length())
                charA = RevA.charAt(i)-'0';
            else
                charA = 0;
            if(i < RevB.length())
                charB = RevB.charAt(i)-'0';
            else
                charB = 0;
            
            int total = charA+charB+carry;
            char ch = (char)(total%2 + '0');
            carry = total/2;
            output.append(ch);
        }
        if(carry != 0)
            output.append('1');

        String result = output.reverse().toString();
        return result;
    }
}