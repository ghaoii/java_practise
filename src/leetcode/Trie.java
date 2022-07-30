package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Trie {
    private boolean isEnd;
    private Trie[] children;

    public Trie() {
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie trie = this;
        for(char ch : word.toCharArray()) {
            if(trie.children[ch - 'a'] == null) {
                trie.children[ch - 'a'] = new Trie();
            }
            trie = trie.children[ch - 'a'];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = this;
        for(char ch : word.toCharArray()) {
            if(trie.children[ch - 'a'] == null) {
                return false;
            }
            trie = trie.children[ch - 'a'];
        }
        return trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie trie = this;
        for(char ch : prefix.toCharArray()) {
            if(trie.children[ch - 'a'] == null) {
                return false;
            }
            trie = trie.children[ch - 'a'];
        }
        return true;
    }
}
