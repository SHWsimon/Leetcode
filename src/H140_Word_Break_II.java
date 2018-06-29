/**
 * Way: Using DFS, 31ms, O(n), space O(n)
 * 1. HashMap store each index contain the segment (avoid duplicate word) 
 * 2. travel from the first word(i=start) of string to the last word
 * 3. wordDict.contains(s.substring(start, end)) contain the segment
 * 4. recursion
 * 5. repeat 1 to 4, until to the last word
 * 6. return the result 
 *
 * @author: simonwang
 */

class Solution {
    //map store the word once use
    HashMap<Integer, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordDFS(s, wordDict, 0);
    }
    
    public List<String> wordDFS(String s, List<String> wordDict, int start){
        //the start point already have the word in map
        if(map.containsKey(start))
            return map.get(start); 
        
        List<String> res = new ArrayList<>();
        //to the end
        if(start==s.length()){
            res.add("");
            return res;
        }
        
        //travel from the first alpha
        for(int end=start+1; end <= s.length(); end++){
            //find the word in Dict
            if(wordDict.contains(s.substring(start, end))){
                String word=s.substring(start, end);
                List<String> subList = wordDFS(s, wordDict, end);
                
                //return the result
                for(String sub : subList){
                    res.add( word + (sub.equals("")? "": " ") + sub );
                }
                
            }
        }
        
        //put the word in map
        map.put(start, res);
        
        return res;
            
    }
}