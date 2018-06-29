/**
 * Way1: Using DP, 5ms, O(2n), space O(n)
 * 1. dp[s.length()+1] store each word contain the segment or not 
 * 2. travel from the first word(i=0) of string to the last word, and (j<i)
 * 3. dp[j] has previous result
 * 4. wordDict.contains(s.substring(j, i)) contain the segment
 * 5. repeat 2 to 4, until to the last word
 * 6. return the result dp[s.length]
 *
 * @author: simonwang
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        
        //start from first word
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i]=true;
                    break;
                }
                else
                    dp[i]=false;
                    
            }
        }
        
        return dp[s.length()];
    }
}