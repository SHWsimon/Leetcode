public class M200_Number_of_Islands {
	/**
	 * Way: DFS, 17ms, O(m*n), space O(1)
	 * 1. basic
	 * 2. grid[i][j]=='1', res++ -> DFS
	 * 3. DFS detect 4 direction
	 * 4. return res
	 *
	 * @author: simonwang
	 */

	class Solution {
	    private int m;
	    private int n;
	    
	    //DFS
	    public int numIslands(char[][] grid) {
	        m=grid.length;
	        if(m==0)
	            return 0;
	        n=grid[0].length;
	        
	        int res=0;
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                if(grid[i][j]=='1'){
	                    dfs(grid, i, j);
	                    res++;
	                }
	            }
	        }
	        
	        return res;
	    }
	    
	    private void dfs(char[][] grid, int i, int j){
	        if(i<0 || j<0)
	            return;
	        if(i>=m || j>=n)
	            return;
	        if(grid[i][j]=='0')
	            return;
	        
	        //walked
	        grid[i][j]='0';
	        
	        //detect 4 direction
	        dfs(grid, i+1, j);
	        dfs(grid, i-1, j);
	        dfs(grid, i, j+1);
	        dfs(grid, i, j-1);
	    }
	    
//	     //BFS
//	     public int numIslands(char[][] grid) {
//	         m=grid.length;
//	         if(m==0)
//	             return 0;
//	         n=grid[0].length;
	        
//	         int res=0;
//	         for(int i=0; i<m; i++){
//	             for(int j=0; j<n; j++){
//	                 if(grid[i][j]=='1'){
//	                     bfs(grid, i, j);
//	                     res++;
//	                 }
//	             }
//	         }
	        
//	         return res;
//	     }
	    
//	     private void bfs(char[][] grid, int i, int j){
//	         Queue<int[]> queue = new LinkedList<>();
//	         queue.offer(new int[]{i, j});  
	        
//	         while(!queue.isEmpty()){
//	             int[] location=queue.poll();
//	             int x=location[0];
//	             int y=location[1];
	            
//	             //1, continue to next location
//	             if(grid[x][y]=='1'){
//	                 //walked
//	                 grid[x][y]='0';

//	                 //detect 4 direction
//	                 if(x+1<m)
//	                     queue.offer(new int[]{x+1, y});
//	                 if(x-1>=0)
//	                     queue.offer(new int[]{x-1, y});
//	                 if(y+1<n)
//	                     queue.offer(new int[]{x, y+1});
//	                 if(y-1>=0)
//	                     queue.offer(new int[]{x, y-1});
//	             }
	            
//	         }
//	     }
	}

}
