/**
 * Way: Using Stack, 14ms, O(n), space O(n)
 * 1. push number into stack 
 * 2. when face operators, pop two number out
 * 3. doing operation, push the result back to stack  
 * 4. return last value in stack
 *
 * @author: simonwang
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        int max=0;
        for(String s: tokens){
            if(s.equals("+")){
                Integer s1=st.pop();
                Integer s2=st.pop();
                st.push(s2+s1);
            }
            else if(s.equals("-")){
                Integer s1=st.pop();
                Integer s2=st.pop();
                st.push(s2-s1);
            }
            else if(s.equals("*")){
                Integer s1=st.pop();
                Integer s2=st.pop();
                st.push(s2*s1);
            }
            else if(s.equals("/")){
                Integer s1=st.pop();
                Integer s2=st.pop();
                st.push(s2/s1);
            }
            else{
               st.push(Integer.valueOf(s));
            }
        }
        
        return st.pop();
    }
}