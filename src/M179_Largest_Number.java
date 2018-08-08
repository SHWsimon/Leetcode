/**
 * Way: Sort, 17ms, O(n*logn), space O(1)
 * 1. basic
 * 2. transfer int to String
 * 3. comparator String
 * 4. sort
 * 5. return new String
 *
 * @author: simonwang
 */



class Solution {
    public String largestNumber(int[] nums) {
        //1. basic
        if(nums.length==0 || nums==null)
            return "";
        
        
        String res[]= new String[nums.length];
        //2. transfer int to String
        for(int i=0; i<nums.length; i++){
            res[i]=String.valueOf(nums[i]);
        }
        
        //3. compare
        Comparator<String> comp = new Comparator<String>(){
            public int compare( String s1, String s2){
                String p1=s1+s2;
                String p2=s2+s1;
                
                //large to small
                return p2.compareTo(p1);
                
                // //small to large
                // return p1.compareTo(p2);
            }
        };
        
        //4. Arrays.sort() uses O(N*logN) 
        Arrays.sort(res, comp);
        
        if(res[0].charAt(0) == '0'){
            return "0";
        }
        
        //5. new String
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            builder.append(res[i]);
        }
        
        return builder.toString();
    }
}
