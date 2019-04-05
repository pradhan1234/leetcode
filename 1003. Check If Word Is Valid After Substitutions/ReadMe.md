# Problem 
 Check If Word Is Valid After Substitutions

## Description
 We are given that the string "abc" is valid.

From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.

If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".

Return true if and only if the given string S is valid.

## Approach
 Keep pushing elements until 'c' is found. When 'c' is found pop 2 times and check first pop is same as 'b' and second pop is same as 'a'. Keep repeating the process for the string. After termination check if stack is empty or not. If it is then its valid otherwise not valid.

## Link
 https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
