
public class M227_Basic_Calculator_II {
	/**
	 * Way1 : stack, 26 ms, O(n), space O(n)
	 * 1. sign to store the pre signature
	 * 2. num to store the current number
	 * 3. stack store the number need to be "+" && "-" 
	 *
	 * Ex: 3+2*4
	 *  i=0  temp1:3  sign:"+"  num:3  stack:
	 *  i=1  temp1:+  sign:"+"  num:3  stack:3
	 *  i=2  temp1:2  sign:"+"  num:2  stack:3
	 *  i=3  temp1:*  sign:"+"  num:2  stack:3 2
	 *  i=4  temp1:4  sign:"*"  num:4  stack:3 2*4=8
	 *
	 *  res = 3 + 8 = 11
	 *
	 * @author: simonwang
	 */
	class Solution {
	    public int calculate(String s) {
	        int res=0;
	        //1. Basic
	        if(s.length() == 0 || s == null)
	            return 0;
	        
	        //2. Fix the space
	        String newS = s.replace(" ", "");
	        
	        //3. Run 
	        Stack<Integer> st = new Stack<Integer>();
	        int num=0;
	        char sign='+';
	        
	        //3.1 Finish the "*" && "/" 
	        for(int i=0; i<newS.length(); i++) {
	            char temp1 = newS.charAt(i);
	            //3.1.1 Number
	            if(Character.isDigit(temp1)) {
	                num = temp1 - '0';
	                while(i+1<newS.length() && Character.isDigit(newS.charAt(i+1))) {
	                    int temp2 = newS.charAt(i+1) - '0';
	                    num = num*10 + temp2;
	                    i++;
	                }
	            }
	            
	            //3.1.2 Sign
	            //i==newS.length()-1 : last number
	            if(!Character.isDigit(temp1) || i==newS.length()-1) {
	                if(sign == '+')
	                    st.push(num);
	                if(sign == '-')
	                    st.push(-num);
	                if(sign == '*')
	                    st.push(st.pop() * num);
	                if(sign == '/')
	                    st.push(st.pop() / num);
	                sign = temp1;
	                num=0;
	            } 
	        }
	        
	        //4. Finish the "+" && "-"
	        for(int i : st) {
	            res = res + i; 
	        }
	        
	        return res;
	    }
	}
}
