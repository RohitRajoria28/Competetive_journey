// q1

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int maxtime=-1;
        int ltp=0;
        int ans=100000;

        for(int i=0;i<logs.length;i++){
        	int clt=logs[i][1];
        	int id=logs[i][0];
        	int tasktime=clt-ltp;

        	if(tasktime>=maxtime){
        		if(tasktime==maxtime){
                  ans=Math.min(ans,id);  
                } 
        		else{
        			ans=id;
        		}
                maxtime=Math.max(maxtime,tasktime);
        	}

        	ltp=clt;
        }

        return  ans;
    }
}

// 

class Solution {
    public int[] findArray(int[] pref) {
    	int n=pref.length;
    	int ans[]=new int[pref.length];

    	 for(int i=n-1;i>0;i--){
    	 	ans[i]=pref[i]^pref[i-1];
    	 }

    	 return ans;
    }
}

// 

class Solution {
    public int helper(int arr[][], int r,int c,int sum,int k,int dir[][],int dp[][][]){
        if(r==arr.length-1 && c==arr[0].length){
            if(k%sum+arr[r][c]==0) return dp[r][c][k]=1;

            return dp[r][c][k]=0;
        }

        if(dp[r][c][k]!=-1) return dp[r][c][k];

        int mod=(int)1e9+7
        int ans=0;
        for(int i=0;i<2;i++){
            int rr=r+dir[d][0];
            int cc=c+dir[d][1];


            if(rr>=0 && cc>=0 && rr<arr.length && cc <arr[0].length){
                ans+=helper(arr,rr,cc,sum+arr[r][c],dir,k,dp);
            }
        }
        return dp[r][c][k]=ans%mod;
    }
    
    public int numberOfPaths(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;

        int dir[][]={{1,0},{0,1}};
        int dp[][][]=new int[n][m][k];

        for(int d[][]:dp){
            for(int dd[]:d){
                Arrays.fill(dd,-1);
            }
        }
        
        int ans=helper(grid,0,0,0,k,dir,dp);
        int mod=(int)1e9+7;
        return ans%mod;
    }
}


public:
    string minWindow(string s, string t) {
        int m=s.size();
        int n=t.size();
        
        unordered_map<char,int> mp;
        
        int ans=INT_MAX;
        int start=0;
        
        for(auto x:t){
            mp[x]++;
        }
        
        int cnt=mp.size();
        int i=0;
        int j=0;
        
        while(j<m){
            //reduce the frequency of elements

            mp[s[j]]--;
            
            if(mp[s[j]]==0){
                cnt--;
            }
            //if cnt 0 means size of map is 0 which means potential answer found
            if(cnt==0){
                while(cnt==0){
                    //update the minimum length of string
                    if(ans>j-i+1){
                        ans=min(j-i+1, ans);
                        start=i;
                    }
                    //now reducing the window size and removing extra elements
                    mp[s[i]]++;
                    //if mp[s[i]] > 0 that means size of map will also increase so increase the count as well
                    if(mp[s[i]]>0){
                        cnt++;
                    }
                    //reduce the window size
                    i++;
                }
            }
//the above while loop is for potential answer now as soon as we loose our potential answer by doing i++ again start increasing the window by j++ for a new potential answer
            j++;
        }
//if ans not equal to int max means ans found so take the substring from start = i and size of substring will be length of ans;
        if (ans != INT_MAX)
            return s.substr(start, ans);
        else
            //otherwise return empty string
            return "";

    }