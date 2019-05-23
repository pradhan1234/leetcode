//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//Example 1:
//
//Input: num1 = "2", num2 = "3"
//
//Output: "6"
//Example 2:
//
//Input: num1 = "123", num2 = "456"
//
//Output: "56088"
//
//Note:
//
//The length of both num1 and num2 is < 110.
//Both num1 and num2 contain only digits 0-9.
//Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//You must not use any built-in BigInteger library or convert the inputs to integerdirectly.

class Solution {
    public String multiply(String num1, String num2) {
        // Reverse becasue it becomes easy for accessing the elements from the end of the number string
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        // Store the basic multiplication of numbers maybe in 2 digits which can be later carry forwarded to a different string.
        int[] d = new int[ n1.length() + n2.length() ];

        for(int i = 0; i < n1.length(); i++){
            for(int j = 0; j  < n2.length(); j++){
                d[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < d.length; i++){
            int carry = d[i] / 10;              // Carry Forward string
            int rem = d[i] % 10;                //Reminder that will be as it is in the output string
            if(i+1 < d.length){
                d[i+1] += carry;                //Adding Cary forward String
            }
            // reminder inserted at the begining everytime because we are accessing it from the end and we don't wanna reverse it again after building the string.
            result.insert(0, rem);
        }


        // There would be multiple 0's in the string that would return if they are not removed from the string.
        while(result.charAt(0) =='0' && result.length() > 1){
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}