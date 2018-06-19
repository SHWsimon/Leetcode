/**
 * Using BFS, HashSet
 * 1. store beginWord into queue
 * 2. poll word out of queue
 * 3. compare word to the wordList
 * 4. store all the transform word in the curr level into queue
 *    (currNum record how many words in curr level in queue)
 *    (newNum record how many word for next level push into queue)
 * 5. remove word in wordList
 * 6. Repeat step 2-5
 * 7. terminal when word equal to endWord
 *
 *  hit   -> hot   -> dot, lot -> dog, log -> cog
 *  curr =1  curr =1  curr =2     curr =2     level=5 
 *  new  =1  new  =1  new  =2     new  =1
 *  level=1  level=2  level=3     level=4
 *
 * @author: simonwang
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //store all the word in set, and can only be use once
        HashSet<String> set = new HashSet<String>(wordList);
        
        //no transform sequence
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        
        //BFS search
        Queue<String> queue = new LinkedList<String>();
        int level=1;   // sequence lenght
        int currNum=1; // number of word in curr level
        int newNum=0;  // number of word in next level
        queue.offer(beginWord);
        
        while(!queue.isEmpty()){
            String word = queue.poll();
            currNum--;
            
            //compared each char of word to set
            for(int i=0; i<word.length(); i++){
                char[] wordUnit = word.toCharArray();
                for(char j='a'; j<'z'; j++){
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    //find the transform word in set
                    if(set.contains(temp)){
                        //match to the endWord, terminal
                        if(temp.equals(endWord)){
                            return level+1;
                        }
                        
                        newNum++;
                        queue.offer(temp);
                        set.remove(temp);
                    }
                }
            }
            
            //curr level have no number left
            if(currNum==0){
                currNum=newNum;
                newNum=0;
                level++;
            }
            
        }
        
        return 0;
    }
}