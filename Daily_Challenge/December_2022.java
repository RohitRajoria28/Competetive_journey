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