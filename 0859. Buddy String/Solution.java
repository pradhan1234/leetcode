/**
 * Given two strings A and B of lowercase letters,
 * return true if and only if we can swap two letters in A so that the result equals B.
 */


/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


class Solution {
    public boolean buddyStrings(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        /**Check if the lengths are same or not*/
        if (lenA != lenB)
            return false;

        /**
         * If both the strings are same then there has to be at least one character repeating in the String
         * and the Count has to be greater than 1
         */
        if(A.equals(B)){
            int[] arr = new int[26];


            for(int i = 0; i < lenA; i++){
                arr[A.charAt(i) - 'a']++;
            }

            for(int count: arr){
                if(count > 1)
                    return true;
            }
            return false;
        }
        else{
            /**
             * Traverse through each character Note the indices of first and the second change in the String.
             */
            int first = -1, second = -1;
            for(int i = 0; i < lenA; i++){
                if(A.charAt(i) != B.charAt(i)){
                    if(first == -1)
                        first = i;
                    else if(second == -1)
                        second = i;
                    else
                        return false;
                }
            }
            /**
             * If the Character if first of A is same as second in B and
             * second in A same as first in B - return true
             * Otherwise false
             */

            if(second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first))
                return true;
            return false;

        }

    }
}