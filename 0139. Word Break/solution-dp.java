class Solution {

    // Using Dynamic Programming

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();

        for(String word: wordDict) {
            set.add(word);
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        // each index indicates if the string until this index
        // is a valid parse

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}