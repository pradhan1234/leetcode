class Solution {
    public String decodeString(String s) {
        // This is a problem of parsing, where we would process something, need to 
        // remember something and retrieve what we have already processed.
        
        Stack<Integer> numStack = new Stack<>();    // count of repetition of following string
        Stack<String> strStack = new Stack<>();     // to save currently processed string, mostly because we encountered '['
        
        int i = 0, n;
        String current = "";    // to store ongoing processed work
        
        while(i < s.length()) {
            
            // if char_i is digit, parse it as it could be multi-digit number
            if(Character.isDigit(s.charAt(i))) {
                n = Integer.parseInt(""+s.charAt(i));
                while(Character.isDigit(s.charAt(i+1))) {
                    n = n * 10 + Integer.parseInt(""+s.charAt(i+1));
                    i++;
                }
                numStack.push(n);   // save this, would be useful
                i++;
            } else if (s.charAt(i) == '[') {
                // save current to stack, flush current
                strStack.push(current);
                current = "";
                i++;
            } else if (s.charAt(i) == ']') {
                // closing bracket indicates completion of current parse
                // all we need next is to multiply with its correcponding count
                // then concatenate with string previously saved to stack
                String temp = "";
                temp = copyAppend(numStack.pop(), current);
                current = strStack.pop() + temp;
                i++;
            } else {
                // simple case: just concatenate
                current+=s.charAt(i);
                i++;
            }
        }
        // all done
        return current;
    }
    
    // helper that copies s, n times
    private String copyAppend(int n, String s) {
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            result.append(s);
            n--;
        }
        return result.toString();
    }
}
