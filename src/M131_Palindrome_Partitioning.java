/**
 * Using Recursion
 *
 * @author: simonwang
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length()==0 || s==null)
            return res;
        List<String> curr = new ArrayList<>();
        findPalin(s, curr, res, 0);
        
        return res;
    }
    
    public void findPalin(String s, List<String> curr, List<List<String>> res, int start){
        if(start == s.length()){
            res.add(new ArrayList<String>(curr));
            return ;
        }
        
        for(int end=start; end<s.length(); end++){
            if(isPalin(s, start, end)){
                curr.add(s.substring(start, end+1));
                findPalin(s, curr, res, end+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public boolean isPalin(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}