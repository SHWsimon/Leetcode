public class M211_Add_and_Search_Word_Data_structure_design {
	/**
	 * Way: TrieNode data structure, 71 ms, O(n), space O(n)
	 * 1. TrieNode class - children[26] : each node have 26 alpha
	 *                   - isWord : record the word path
	 *                   - word : record the word string
	 * 2. WordDictionary - WordDictionary()
	 *                   - find(String word, TrieNode node, int i)
	 *                   - addWord(String word)
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


	// Trie Tree
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

	public class WordDictionary {
	    
	    private TrieNode root;
	    
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        TrieNode node = root;
	        for(int i=0; i< word.length(); i++){
	            int j=word.charAt(i)-'a'; //char to int
	            if(node.children[j]==null){
	                //add new node
	                node.children[j]=new TrieNode(); 
	            }
	            node=node.children[j]; 
	        }
	        
	        //record the word
	        node.isWord=true; 
	        node.word=word;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return find(word, root, 0);
	    }
	    
	    public boolean find(String word, TrieNode node, int i){
	        //word = "" && word = word
	        if(i==word.length())
	            return node.isWord;
	        
	        if(word.charAt(i) == '.'){
	            //find the next word a-z
	            for(TrieNode temp: node.children){
	                if(temp!=null && find(word, temp, i+1))
	                    return true;
	            }
	            return false;
	        }
	        else{
	            int j=word.charAt(i)-'a';
	            TrieNode temp=node.children[j];
	            return temp!=null && find(word, temp, i+1);
	        }

	    }
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */
}
