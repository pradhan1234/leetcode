// DFS Approach

class Solution {

    // DFS Approach, we compare the words in dictionary against the string
    // Really good approach

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashSet<>());
    }

    // s : string yet to be parsed
    // wordDict : given list of words
    // visited : set to remember if s was already processed in some branch of dfs
    private boolean dfs(String s, List<String> wordDict, Set<String> visited) {
        if(s.length() == 0) {
            // end of string reached, parse successful
            return true;
        }

        // if s is in the visited set, it means it was encountered before
        // and if it were a successful parse, program would have returned
        // so it appearing again implies it does not parse successfully
        // this essentially helps prune our dfs
        if(visited.contains(s)) {
            return false;
        }

        // we match the words in dictionary against the string
        // if we get a word that is a suffix in s, we freeze it and expand dfs on remaining s
        // s = word + remaining s
        for(String word: wordDict) {
            if(s.startsWith(word) && dfs(s.substring(word.length()), wordDict, visited)) {
                return true;
            }
        }

        visited.add(s);
        return false;
    }
}
