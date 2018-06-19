/**
 * Way1 : Using linear search, 70ms, O(n^2)
 * 1. travel from first station
 * 2. tank+gas[i]-cost[i]>=0, walk to next station
 * 3. tank+gas[i]-cost[i]<0, start from i+1 station
 * 4. repeat step2 to 3 until find the start station can walk around
 * 
 * Way2 : sum gas[i] >= sum cost[i] has solution, 1ms, O(n)
 * 1. sum gas[i] >= sum cost[i], return i
 * 2. sum gas[i] < sum cost[i], return -1
 *
 * @author: simonwang
 */

class Solution {
    
    //Way1 
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        while(start!=gas.length){
            int numStation=gas.length;
            int tank=0;
            boolean walk=true;
            for(int i=start; numStation!=0; i++, numStation--){
                //correct the i
                if(i>=gas.length)
                    i=gas.length-i;
                
                //enough to next gas station
                if(tank+gas[i]-cost[i]>=0)
                    tank=tank+gas[i]-cost[i];
                //not enough to next gas station
                else{
                    walk=false;
                    break;
                }
            }
            
            //can walk around
            if(walk)
                return start;
            start++;
        }
        
        return -1;
    }
    
    //Way2
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int numGas=0;
        int numCost=0;
        int tank=0;
        int start=0;    
        
        for(int i=0; i<gas.length; i++){
            numGas+=gas[i];
            numCost+=cost[i];
            tank=tank+gas[i]-cost[i];
            
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        
        if(numGas>=numCost)
            return start;
        else
            return -1;
    }
}