/**
 * Way: Boundary condition, 7ms, O(logn), space O(n)
 * 1. 0, +, -
 * 2. 整除
 * 3. 不整除
 * 4. 是否有循環小數
 * ex:
 *    1/2
 *    整數
 *    rem=(1%2)*10=10
 *    val=1/2=0
 *
 *    小數,判斷是否有循環小數
 *    rem=(rem%2)*10=(10%2)*10=0
 *    val=rem/2=5
 *
 *    val=0.5
 *
 * 5. return val
 *
 * @author: simonwang
 */

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        // 1. 0, + or -
        if(denominator==0)
            return "";
        long num = numerator;
        long denum = denominator;
        if((num<0 && denum>0) || (num>0 && denum<0))
            builder.append('-');

        num = Math.abs(num);
        denum = Math.abs(denum);
        //2. 整除
        long val = num/denum;
        builder.append(String.valueOf(val));
        num = (num%denum)*10;
       
        //3. 不整除, rem!=0
        //4.是否有循環小數
        //map store duplicate position
        HashMap<Long,Integer> maps = new HashMap<>();//store divid number
        
        //list store the fraction result part
        List<Long> number = new ArrayList<>();
        int index = 0;
        int beginIndex = -1;

        while(num!=0){
            //重複
            if(maps.containsKey(num)){
                beginIndex = maps.get(num);
                break;
            }
            else{
                maps.put(num, index++);
                val = num/denum;
                num = (num%denum)*10;
                number.add(val);
            }
        }
        
        //5.print result
        for(int i = 0;i<index;i++){
            if(i==0)
                builder.append('.');
            if(i==beginIndex){
                builder.append('(');
            }
            builder.append(number.get(i));
        }
        if(beginIndex!=-1)
            builder.append(')');

        return builder.toString();
    }
}