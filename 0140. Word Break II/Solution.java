// DFS Approach

class Solution {

    // DFS Approach, we compare the words in dictionary against the string
    // Really good approach

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // s : string yet to be parsed
    // wordDict : given list of words
    // visited : set to remember if s was already processed in some branch of dfs
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> visited) {

        LinkedList<String> result = new LinkedList<>();

        if(s.length() == 0) {
            result.add("");
            return result;
        }

        // if s is in the visited set, it means it was encountered before
        // and we already have the solution to it saved in visited.
        if(visited.containsKey(s)) {
            return visited.get(s);
        }

        List<String> forward;

        // we match the words in dictionary against the string
        // if we get a word that is a suffix in s, we freeze it and expand dfs on remaining s
        // s = word + remaining s
        for(String word: wordDict) {
            if(s.startsWith(word)) {
                forward = dfs(s.substring(word.length()), wordDict, visited);
                for(String f: forward) {
                    if(f.length() == 0) {
                        result.add(word);
                    } else {
                        result.add(word +" "+ f);
                    }
                }
            }
        }

        visited.put(s, result);
        return result;
    }
}