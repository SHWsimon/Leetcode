
public class M208_Implement_Trie_Prefix_Tree {
	/**
	 * Way: TrieNode data structure, 104 ms, O(n), space O(n)
	 * 1. TrieNode class - children[26] : each node have 26 alpha
	 *                   - isWord : record the word path
	 *                   - word : record the word string
	 * 2. WordDictionary - Trie()
	 *                   - insert(String word)
	 *                   - search(String word)
	 *                   - findWord(String word, TrieNode node, int i)
	 *                   - startsWith(String prefix)
	 *                   - findPre(String word, TrieNode node, int i) 
	 * 3. TrieNode data structure
	 *          root
	 *         /  |  \
	 *       t    a    i
	 *     /   \        \ 
	 *    o      e        n
	 *         / | \    /
	 *        a  d  h  n  
	 *
	 * @author: simonwang
	 */

	class TrieNode {
	        TrieNode[] children;
	        boolean isWord;
	        String word;

	        public TrieNode(){
	            children= new TrieNode[26];//record use or not use
	            isWord=false;
	            word="";
	        }
	    }

	public class Trie {
	    
	    private TrieNode root;
	    
	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new TrieNode(); //initialized
	    }
	    
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode node = root;
	        for(int i=0; i < word.length(); i++) {
	            int ch = word.charAt(i)-'a'; //char to integer
	            if(node.children[ch] == null) {
	                node.children[ch] = new TrieNode();
	            }
	            node = node.children[ch];
	        }
	        node.isWord=true; 
	        node.word=word;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        return findWord(root, word, 0);
	    }

	    public boolean findWord(TrieNode root, String word, int i) {
	        if(word.length() == i)
	            return root.isWord;
	        int ch = word.charAt(i) - 'a';
	        TrieNode temp = root.children[ch];
	        return temp!=null && findWord(temp, word, i+1);
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        return findPre(root, prefix, 0);
	    }
	    
	    public boolean findPre(TrieNode root, String pre, int i) {
	        if(pre.length() == i)
	            return true;
	        int ch = pre.charAt(i) - 'a';
	        TrieNode temp = root.children[ch];
	        return temp!=null && findPre(temp, pre, i+1);
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}
