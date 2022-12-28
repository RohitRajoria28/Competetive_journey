import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class class1{




	// Construct Graph

	 public static class Edge{
        int v;
        int w;

        Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
    public static void addEdge(ArrayList<Edge>[] graph, int u , int v,int w){
        graph[v].add(new Edge(u,w));
        graph[u].add(new Edge(v,w));
    }
    // display in graph

    public static void display(ArrayList<Edge>[] graph){
        int i=0;
        for(ArrayList<Edge> e: graph){
            
            System.out.print(i+"-> " );
            i++;
            for(Edge ed:e){
                int v=ed.v;
                int w=ed.w;

                System.out.print("( value : "+ v + " Weight : "+ w + " )");
            }
            System.out.println();
        }
    }
    // find in Graphs
    public static boolean findEdge(ArrayList<Edge>[] graph, int u , int v ){
        ArrayList<Edge> edge=graph[u];

        for(Edge e: edge){
            if(e.v==v) return true;
        }
        return false;
    }
    
    public static  boolean findPath(ArrayList<Edge>[] graph, int src , int dest,boolean vis[]){
        if(vis[src]) return false;
        if(src==dest) return true;
        vis[src]=true;
        boolean ans=false;
        
            for(Edge eg: graph[src]){
                ans= ans|| findPath(graph, eg.v, dest, vis);
            }
         

        return ans;
    }
    // print all path og graph for destinataion
    public  static void findAllpaths(ArrayList<Edge>[] graph,List<List<Integer>> ans,List<Integer> smallans,int src,int dest,boolean vis[]){
        if(vis[src]) return;
        if(src==dest){
            List<Integer> sans=new ArrayList<>(smallans);
            sans.add(src);
            ans.add(sans);
            return ;
        }

        vis[src]=true;
        smallans.add(src);
        for(Edge e : graph[src]){
            findAllpaths(graph,ans,smallans,e.v,dest,vis);
        }
        smallans.remove(smallans.size()-1);
        vis[src]=false;
    }
// GCC
    public static void dfsGCC(ArrayList<Edge>[] graph, int u,boolean vis[] ){
        if(vis[u]) return ;
        vis[u]=true;
        for(Edge e: graph[u]){
            dfsGCC(graph,e.v,vis);
        }
    }

    public static int countGCC_dfs(ArrayList<Edge>[] graph){
        int count=0;

        int  n=graph.length;
        boolean vis[]=new boolean[101];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfsGCC(graph,i,vis);
            }
        }
        return count;
    }

    // leetcode Number of islands

    class Solution {
    	public void dfs_NumIsland(char [][]arr,int r,int c,int [][]dir){
    		
    		
    		arr[r][c]="2";
    		for(int d=0;d<4;d++){
    			int rr=r+dir[d][0];
    			int cc=c+dir[d][1];

    			if(rr>=0 && cc>=0 && rr<arr.length && cc<arr[0].length  && arr[rr][cc]-'0'==1 ){
    				dfs_NumIsland(arr,rr,cc,dir);
    			}
    		}
    	}
	    public int numIslands(char[][] arr) {
	        int components=0;
	        int dir[][]={{1,0},{0,1},{0,-1},{-1,0}};

	        for(int i=0;i<arr.length;i++){
	        	for(int j=0;j<arr[0].length;j++){
	        		if(arr[i][j]-'0'==1){
	        			dfs_NumIsland(arr,i,j,dir);

	        			components++
	        		}
	        	}
	        }

	        return components;
		}
	}

	public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

          ArrayList<Edge>[] graph=new ArrayList[100];
        for (int i = 0; i < 100; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph,0,3,19);
        addEdge(graph,0,1,10);
        addEdge(graph,4,3,9);
        addEdge(graph,4,5,2);
        addEdge(graph,4,6,8);
        addEdge(graph,5,6,3);
        addEdge(graph,2,3,40);
        addEdge(graph,2,3,40);
        addEdge(graph,2,1,10);
        addEdge(graph,7,8,10);
        addEdge(graph,11,10,10);
        addEdge(graph,12,10,11);
        addEdge(graph,10,13,110);







        // display(graph);
        boolean flag=findEdge(graph,0,12);
        


        // System.out.println(findPath(graph,0,9,new boolean[9]));
       // List<List<Integer>> paths=new ArrayList<>();
       // List<Integer> smallans=new ArrayList<>();
       // findAllpaths(graph,paths,smallans,0,6,new boolean[101]);

       // for(List<Integer> list: paths){
       //    for(int i: list){
       //      System.out.print(i+"->");
       //    }
       //    System.out.println(";");
       // }
        
        // GCC 
        System.out.print(countGCC_dfs(graph)) ;
	}
}

// leetcode Max Area of island 

class Solution {
	public void dfsArea(int [][]arr,int r,int c,int []ans){
		arr[r][c]=2;
		ans[0]++;
		int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
		for(int d=0;d<4;d++){
			int rr=r+dir[d][0];
			int cc=c+dir[d][1];
			if(rr>=0 && cc>=0 && rr<arr.length && cc<arr[0].length  && arr[rr][cc]==1 ){
    				dfsArea(arr,rr,cc,ans);
			}
		}
	}
    public int maxAreaOfIsland(int[][] grid) {
		

		int mans=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(arr[i][j]==1){
					int ans[]=new int[1];
					dfsArea(arr,i,j,ans);
					mans=Math.max(ans,mans);
				}
			}
		}    

		return mans;    
   }
}