class Solution {
    public boolean isValid(String S) {
		if(S == null || S.length() == 0) return false; 
        String valid = "abc";
        Stack<Character> s = new Stack<>();
        int index = 0;
        while(index < S.length()){
            if(S.charAt(index)!= 'c'){
                s.push(S.charAt(index));
                index++;
            }
            else{
                int count = 2;
                while(!s.isEmpty() && count >0){
                    if(s.pop() != valid.charAt(count - 1)){
                        return false;
                    }
                    count--;
                }
                index++;
            }
        }
        return s.isEmpty();
    }
}