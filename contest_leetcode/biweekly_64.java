// 

class Solution {
    public String kthDistinct(String[] arr, int k) {
 		HashMap<String,Integer> map=new HashMap<>();

 		for(String s: arr){
 			map.put(s,map.getOrDefault(s,0)+1);
 		}       

 		List<String> ans=new ArrayList<>();

 		for(String s: map.keySet()){
 			if(map.get(s)==1){
 				ans.add(s);
 			}
 		}

 		if(ans.size()<k){
 			return "";
 		}

 		return ans.get(k-1);
    }
}

// leetcode Two Best Non-Overlapping Events

class Solution {
    
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        
        int max=0;
        List<int[]> list=new ArrayList<>();
        for(int a[]:events){
        	list.add(a);
        }
        Collections.sort(list,(a,b)->{
        	return a[0]-b[0];
        });

        for(int i=0;i<n;i++){
        	int ar[]=list.get(i);

        	int sp=ar[0];
        	int ep=ar[1];
        	int val=ar[2];
        	max=Math.max(val,max);
        	for(int j=i+1;j<n;j++){
        		int ar2[]=list.get(j);

        		int csp=ar2[0];
        		int cep=ar2[1];
        		int cval=ar2[2];

        		if(csp>ep){
        			max=Math.max(max,val+cval);
        		}
        	}
        }

        return max;
    }
}

// approach 2

class Solution {
    public int maxTwoEvents(int[][] events) {

    	PriorityQueue<int[]> st=new PriorityQueue<>((a,b)->{
           return a[1]-b[1];
        });

    	 int n=events.length;
        
        int max=0;

        List<int[]> list=new ArrayList<>();
        for(int a[]:events){
        	list.add(a);
        }
        // Collections.sort(list,(a,b)->{
        // 	return a[0]-b[0];
        // });
        Collections.sort(list,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1]; 
        	return a[0]-b[0];
        });
        
        
        
        int ans=0;
        for(int i=0;i<list.size();i++){
            
        	int ar[]=list.get(i);
             System.out.print(ar[0]+" ");

        	int sp=ar[0];
        	int ep=ar[1];
        	int val=ar[2];
            // int max=0;
        	 
        	 
        	while(st.size()!=0 && st.peek()[1]<sp){
                  
                 int ra[]=st.remove();
//                  
        		 max=Math.max(max,ra[2]);
        	}
          	
          	ans=Math.max(ans,max+val);
        	st.add(ar);
        }


        return ans;
        
    }
} 


// 

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
    	int n=s.length();
    	int next[]=new int[n+1];
    	int prev[]=new int[n+1];
    	int psum[]=new int[n+1];
    	int ans[]=new int[queries.length];

    	Arrays.fill(next,(int)1e9);
    	for(int i=0;i<n;i++){
    		psum[i+1]=prev[i]+s.charAt(i)=='|'?1:0;
    		prev[i+1]=s.charAt(i)=='|'?i:prev[i];
    	}

    	for(int i=n-2;i>=0;i--){
    		next[i+1]=s.charAt(i)=='|'?i:next[i];
    	}

    	for(int i=0;i<queries.length;i++){
    		int st=queries[i][0];
    		int end=queries[i][1];

    		int l=next[st];
    		int r=prev[end+1];

    		ans[i]=(l<r)?r-l-(psum[r]-psum[l]):0;
    	}

    	return ans;
        
    }
}