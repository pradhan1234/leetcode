/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,5};
        String str = "Test1ng-Leet=code-Q!";
        System.out.println("Answer: "+reverseOnlyLetters(str));
    }


    public static String reverseOnlyLetters(String S) {

        StringBuilder str = new StringBuilder(S);

        int i = 0;
        int j = str.length()-1;

        while(i < j){
            int intI = str.charAt(i);
            int intJ = str.charAt(j);
            /** Check if the character at Location i is a alphabet or not.
             * If not just continue with the next iteration of loop */
            if(!((intI >= 97 && intI <= 122) || (intI >= 65 && intI <= 90))){
                i++;
                continue;
            }
            /** Check if the character at Location j is a alphabet or not.
             * If not just continue with the next iteration of loop */
            if(!((intJ >= 97 && intJ <= 122) || (intJ >= 65 && intJ <= 90))){
                j--;
                continue;
            }

            /** If both i and j are alphabets then we can easily swap them */

            char temp = str.charAt(j);
            str.setCharAt(j, str.charAt(i));
            str.setCharAt(i, temp);
            i++;
            j--;
        }
        return str.toString();
    }


}