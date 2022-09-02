 // question 2 
 class Solution {
 	public boolean Restrirct(int v,int[] res){
 		for(int i: res){
 			if(i==v) return true;
 		}
 		return false;
 	}
    public int reachableNodes(int n, int[][] num, int[] res) {
       HashSet<Integer> set=new HashSet<>();
        
        
        List<int[]> edges=new ArrayList<>();
        for(int a[]:num){
            edges.add(a);
        }
        
        Collections.sort(edges,(a,b)->{
            return a[0]-b[0];
        });
       
        int count=1;
         set.add(0);
        for(int a[]:edges){
        	 int v=a[0];
        	 int u=a[1];
               // System.out.print(v+" ");
              	if(set.contains(v) && !Restrirct(u,res) ){
                      
              		set.add(u);
                     
              	}else if(set.contains(u) && !Restrirct(v,res)){
                    set.add(v);
              	}
              
        }
         for(int i: set){
             System.out.print(i+" ");
         }
          
        return set.size();
    }
}


// 


class Solution {
    public HashMap<Integer,ArrayList<Integer>> CreateGraph(int [][]arr){
        HashMap<Integer,ArrayList<Integer>> graph=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            graph.add(i,new ArrayList<>());
        }
        
        for(int a[]:graph){
            int u=a[0];
            int v=a[1];
            
            graph.get(u).add(v);
        }
        
        return graph;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer,ArrayList<Integer>> graph=CreateGraph(edges);
        
        HashSet<Integer> rest= new HashSet<>();
        for(int i:restricted){
            rest.add(i);
        }
        
        HashSet<Integer> visited=new HashSet<>();
        
        int nodes=0;
        
        int start=0;
        
        dfs(start,nodes,graph,rest,visited);
        
        return nodes;
    }
    
    public void dfs(int start,int nodes,HashMap<Integer,ArrayList<Integer>> graph  ,HashSet<Integer> rest,HashSet<Integer> visited){
    	if(rest.contains(start) || visited.contains(start)){
    		return ;
    	}

    	nodes++;

    	for(int i: graph.get(start)){
    		dfs(i,nodes,graph, rest,visited);
    	}
    }
}

