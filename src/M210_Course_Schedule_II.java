
public class M210_Course_Schedule_II {
	/**
	 * Way: BFS, 29 ms, O(E+V), space O(V)
	 * 1. Basic case
	 * 2. Count the indegree
	 * 3. BFS
	 * 4. Return result
	 *
	 * @author: simonwang
	 */

	class Solution {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        int[] res = new int[numCourses];
	        int[] indegree = new int[numCourses];
	        int degree=0; //for indegree
	        
	        for(int i=0; i < numCourses; i++)
	            res[i]=i;
	        
	        //1. Basic
	        if(prerequisites == null || prerequisites.length == 0)
	            return res;
	        
	        //2. count how many indegree
	        for(int[] pair: prerequisites) {
	            indegree[pair[0]]++;
	        }
	        
	        //3. BFS
	        Queue<Integer> rec = new LinkedList<Integer>();
	        //find the indegree = 0
	        for(int i=0; i < numCourses; i++) {
	            if(indegree[i]==0)
	                rec.offer(i);
	        }
	        
	        int idx=0;
	        while(!rec.isEmpty()) {
	            int val=rec.poll();
	            res[idx++]=val;
	            for(int[] pair: prerequisites) {
	                if(pair[1] == val){
	                    indegree[pair[0]]--;
	                    if(indegree[pair[0]] == degree) {
	                        rec.offer(pair[0]);
	                    }
	                }   
	            }
	        }
	        
	        //4. return result
	        if(idx==numCourses)
	            return res;
	        else
	            return new int[]{};
	       
	    }
	    
	}
}
