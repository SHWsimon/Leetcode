public class M207_Course_Schedule {
	/**
	 * Way: Topology + DFS, 71 ms, O(n), space O(n)
	 * 1. basic, initialization
	 * 2. DFS find the course v=0 to v=numCourses (v=0 is first course)
	 * 3. find the course in the prerequisites pair
	 * 4. repeat step2~3 
	 * 5. return res
	 *
	 * @author: simonwang
	 */


	class Solution {
	    private boolean[] dis; //true: walked, false: not walked
	    private String[] color; //black: black path, white: white path
	    private Stack<Integer> topology; // topology order
	    private boolean result=true; 
	    
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        //basic
	        if(prerequisites==null || prerequisites.length<2)
	            return true;
	        
	        //initialized
	        this.dis=new boolean[numCourses];
	        this.color=new String[numCourses];
	        this.topology=new Stack<>();
	        
	        //initialized color to white
	        for(int v=0; v<numCourses; v++){
	            color[v]="white";
	        }
	        
	        //DFS
	        for(int v=0; v<numCourses; v++){
	            if(!this.result)
	                return false;
	            if(color[v]=="white")
	                dfs(v, prerequisites);
	        }
	        
	        return true;
	    }
	    
	    //DFS
	    private void dfs(int v, int[][] prerequisites){
	        //walked
	        dis[v]=true;
	        color[v]="gray";
	        
	        for(int[] edge: prerequisites){
	            //find the fisrt point
	            if(edge[1]==v){
	                //not walked
	                if(color[edge[0]]=="white"){
	                    dfs(edge[0], prerequisites);
	                }
	                //walked
	                else{
	                    if(dis[edge[0]])
	                        this.result=false;
	                }
	            }
	        }
	        
	        //back track
	        dis[v]=false;
	        color[v]="black";
	        topology.push(v); //topology list
	    }
	}
}
