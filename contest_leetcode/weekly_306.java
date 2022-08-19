// question 1

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
    	int ans[][]=new int[n-2][n-2];
        
       for(int r=0;r<=n-3;r++){
	       	for(int c=0;c<=n-3;c++){
	       		max=0;
		       		for(int i=r;i<r+3;i++){
			        	 for(int j=c;j<c+3;j++){
                              max=Math.max(grid[i][j],max);                             
			        	}
		            }

		            ans[r][c]=max;
	       	}
       }

       return ans;
        
    }
}

// ques 2
class Solution {
    public int edgeScore(int[] edges) {
        
     HashMap<Integer,Integer> map=new HashMap<>();
        map.put(-1,-1);        
        for(int i=0;i<edges.length;i++){
        	int key=edges[i];
            map.put(key,map.getOrDefault(key,0)+i);
        }
        int maxKey=-1;
        for(int key: map.keySet()){
            if(map.get(key)>map.get(maxKey)){
            	maxKey=key;
            }else if(map.get(key)==map.get(maxKey)){
                maxKey=Math.min(key,maxKey);
            }         
        }

        return maxKey;
    }
}

// approach 2

class Solution {
    public int edgeScore(int[] edges) {
        List<List<Integer>> graph= new ArrayList<>();
        
        int n=edges.length;
        
        for(int i=0;i<n;i++){
        	graph.add(new ArrayList<>());
        }
         
         for(int i=0;i<n;i++){
            int val=edges[i];
         	graph.get(val).add(i);
         }

         int maxKey=-1;
         int maxSum=-1;
         for(int i=0;i<graph.size();i++){
         	List<Integer> small=graph.get(i);
            int sum=0;
         	for(int e:small){
         		sum+=e;
         	}
         	if(sum>maxSum){
         		maxSum=sum;
         		maxKey=i;
         	}
         }

         return maxKey;
         


    }
}