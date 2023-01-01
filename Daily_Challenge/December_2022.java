// 14 december 2022

class Solution {
    public int helper(int arr[],int dp[],int idx){
        if(idx>=arr.length) return 0;

        if(idx==arr.length-1 || idx==arr.lenth-1) return arr[idx];

         
        if(dp[idx]!=0) return dp[idx];

        return  dp[idx]=helper(arr,dp,idx+2);
    }
    public int rob(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n]
        
        int even=helper(arr,dp,0);
        int odd=helper(arr,dp,1);

        return even>odd?even:odd;

    }   
}

// 

class Solution {
    public int helper(int arr[],int idx){
        if(idx<0 ) return 0;

        return Math.max(helper(arr,idx-2)+arr[idx],helper(arr,idx-1));
    }
    public int rob(int[] nums) {
        return helper(arr,arr.length-1);
    }

}

// 15 december 

class Solution {
    public int maxSubString(String s1,String s2,int i,int j,int [][]dp){
        if(i>=s1.length || j>=s2.length){
            return 0;
        }
        if(dp[i][j]!=0) return dp[i][j];
        int ans=0;
        if(s1.charAt(i)==s2.charAt(i)){
            ans+=1+maxSubString(s1,s2,++i,++j,dp);
        }else{
            ans+=maxSubString(s1,s2,++i,j,dp);
        }
        return dp[i][j]=ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int i=0;
        int j=0;
        int n=text1.length;
        int m=text2.length;
        int dp[]=new int[n][m];

        int ans=maxSubString(text1,text2,i,j,dp);
    }
}

// 17 dec 

class Solution {
    public boolean isNumber(String st){
        int val=Integer.parseInt(st);

        return (val>=-200 && val<=200);
    }
    public int evalRPN(String[] arr) {
        Stack<Integer> st=new Stack<>();

        for(int i =0;i<arr.length;i++){
            String ch=arr[i];

            if(isNumber(ch)){
                st.push(Integer.parseInt(ch));
            }else{
                int v1=st.pop();
                int v2=st.pop();
                int ans=0;
                if(ch.equals("*")){
                    ans=v1*v2;
                }else if(ch.equals("/")){
                    ans=(v2/v1);
                }else if(ch.equals("+")){
                    ans=(v1+v2);
                }else{
                    // ch== "-"
                    ans=(v2-v1);
                }
                st.push(ans);
            }

        }

        return st.pop();
    }
}


// 18 december - Daily Temperature

class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int ans[]=new int[n];

        for(int i=0;i<n;i++){
            int val=arr[i]
            while(!st.empty() && arr[st.peek()] < val ){
                ans[st.peek()]=i- st.pop();
            }
            st.push(i);
        }    

        while(st.size()>0) st.pop();


        return ans;

    }
}


// december 20

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.length;
        Stack<Integer> dfs=new Stack<>();
        HashSet<Integer> seen=new HashSet<>();
        dfs.add(0);
        seen.add(0);
        while(dfs.size()!=0){
            int i=dfs.pop();

            for(int j: rooms.get(j)){
                if(!set.contains(j)){
                    dfs.push(j);
                    seen.add(j);
                }
            }

            if(rooms.size()==seen.size()) return true;
        }

        return seen.size()==rooms.size();
    }
}

// 23 decemeber

class Solution {
    public int findMax(int idx,int buy,int []arr){

        if(idx>=arr.length) return 0;

        // buy condition
        if(buy==1){
            return (-arr[idx]+Math.max(findMax(idx+1,1,arr)+findMax(idx+1,0,arr)));
        }
        return (+arr[idx]+Math.max(findMax(idx+2,1,arr)+findMax(idx+1,0,arr)));
    }
    public int maxProfit(int[] arr) {
        return findMax(0,1,arr);
    }
}


class Solution {
    public int findMax(int idx,int buy,int []arr){

        if(idx>=arr.length) return dp[idx]=0;

        if(dp[idx]!=0) return dp[idx];

        // buy condition
        if(buy==1){
            return dp[idx]=Math.max(-arr[idx]+findMax(idx+1,0,arr,dp),findMax(idx+1,1,arr,dp));
        }
        return dp[idx]=Math.max(arr[idx] +findMax(idx+2,1,arr,dp),findMax(idx+1,0,arr,dp));
    }
    public int maxProfit(int[] arr) {
        int []dp=new int[arr.length+2];
        return findMax(0,1,arr,dp);
    }
}


// 25 december

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sor(nums);
        int n=nums.length;
        int psum[]=new int[n];
       psum[0]=nums[0];
       for(int i=1;i<nums.length;i++){
           
          psum[i]=psum[i-1]+nums[i];
       }

       int ans[]=new int[queries.length];
       int idx=0;
       for(int val: queries){


          int l=0;
          int r=n-1;

          while(l<=r){
            int mid=(l+r)/2;
            if(psum[mid]>val){
                r=mid-1;
            }else{
                l=mid+1;
            }
          }

          ans[idx++]=l;
       }


       return ans;
    }
}

// 27 december 

class Solution {
    public int maximumBags(int[] cap , int[] roc , int add ) {
        
        int n=cap.length;
        int arr[]=new int[n];
        int idx=0;
        int frock=0;
        int croc=0;
        for(int i: cap){
            frock+=i;
            arr[idx]=i-roc[idx];
            croc+=roc[idx];
            idx++;
        }

        int rem=frock-croc;

        int count=0;
        for(int i:arr){
            if(i>0){
                if(add>=i){
                    add-=(i);                    
                }else{
                    break;
                }
            }
            count++;
        }

        return count;

    }
}



// 28 december 2022

class Solution {
    public int minStoneSum(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> {
            return b-a;
        });
        int ans=0;
        int n=arr.length;
        int count=k;

        for(int i: arr){
            pq.push(i);
            ans+=i;
        }

        while(count-->0){
            
            int a=pq.poll();
            pq.push(a-(a/2));
            ans-=a-(a/2);
        }
        
        return ans;
    }
}

// 
class Solution {
    public void helper(int [][]graph,List<List<Integer>> ans,List<Integer> smallans,int src,int tar,boolean []vis){
        if(vis) return ;
        if(tar==src){
            List<Integer> sans=new ArrayList<>(smallans);
            sans.add(src);
            ans.add(sans);

            return ;
        }

        vis[src]=true;
        smallans.add(src);

        for(int []e:graph[src]){
            helper(graph,ans,smallans,e,tar,vis);

        }
        smallans.remove(smallans.size()-1);
        vis[src]=false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean []vis=new boolean[graph.length];

        List<List<Integer>> ans=new ArrayList<>();
        int n=graph.length;
        List<Integer> smallans=new ArrayList<>();
        helper(graph,ans,smallans,0,n-1,vis);

        return ans;
    }
}

// leetcode 31 decemeber 22

class Solution {
    public int traveller(int [][]grid,int dir[][] ,boolean vis[][] ,int r,int c){
        if(vis[r][c] || grid[r][c]==-1) return 0;

        if(vis[r][c]==2 ){
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(!grid[i][j] && grid[i][j]==0) return 0;
                }
            }
            return 1;
        } 


        vis[r][c]=true;
        int ans=0;
        for(int d=0;d<4;d++){
            int rr=r+dir[d][0];
            int cc=c+dir[d][1];

            ans+=(traveller(grid,dir,vis,rr,cc));
        }

        return ans;

    }
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;

        int m=grid[0].length;

        boolean [][]vis=new boolean[n][m];

        int dir[][]={{1,0},{-1,0},{0,-1},{0,1}};
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if( grid[i][j]==1) {
                    ans=traveller(grid,dir,vis,i,j);
                }
            }
        }

        return ans;
    }
}



// 

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[]=s.split(' ');
        if(pattern.length() !=arr.length) return false;

        HashMap<Character,String> map=new HashMap<>();
        HashMap<String,Boolean> check=new HashMap<>();


        for(int i=0;i<arr.length;i++){
            char c=pattern.charAt(i);

            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i])) return false;
            }else{
                if(check.get(arr[i])) return false;

                map.put(c,arr[i]);
                check(arr[i],true);
            }
        }

        return true;

    }
}