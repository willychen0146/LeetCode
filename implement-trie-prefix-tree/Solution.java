import java.util.HashMap;

class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false; 
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isEndOfWord;      
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
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