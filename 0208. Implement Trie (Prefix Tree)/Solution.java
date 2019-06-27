class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cursor = root;
        char c;

        for(int i = 0; i < word.length(); i++){
            c = word.charAt(i);
            if(cursor.children[c-'a'] == null){
                cursor.children[c-'a'] = new TrieNode();
            }
            cursor = cursor.children[c-'a'];
        }

        cursor.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cursor = root;
        char c;

        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if(cursor.children[c-'a'] == null) {
                return false;
            }
            cursor = cursor.children[c-'a'];
        }
        return cursor.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cursor = root;
        char c;

        for(int i = 0; i < prefix.length(); i++){
            c = prefix.charAt(i);
            if (cursor.children[c-'a'] == null) {
                return false;
            }
            cursor = cursor.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */