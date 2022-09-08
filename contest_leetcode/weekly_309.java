 // q1

class Solution {
    public boolean checkDistances(String s, int[] distance) {

    	HashMap<Character,Integer> map=new HashMap<>();
    	int arr[]=new int[26];
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if(map.containsKey(c)){
    			arr[c-'a']=i-map.get(c)-1;
    			if(distance[c-'a']!=i-map.get(c)-1) return false;
    		}else{
    			map.put(c,i);
    		}
    	}

    	return true;
        
    }
}

// q2

class Solution {
	public long helper(int curr,int end,int steps,long dp[][]){
		if(steps==0 && curr==end) return dp[curr+2500][steps]=1;
        if(steps<=0 && curr!=end) return 0;
        
        if(dp[curr+2500][steps]!=-1) return dp[curr+2500][steps];
         
    
		long ans=0;

		 
		ans=(helper(curr-1,end,steps-1,dp)%((int)1e9 + 7)+helper(curr+1,end,steps-1,dp)%((int)1e9 + 7))%((int)1e9 + 7);
		

		return  dp[curr+2500][steps]=ans ;
	}
    
    public int numberOfWays(int startPos, int endPos, int k) {

     
         
        long [][] dp=new long[5000+1][k+1];
        for(long a[]:dp){
            Arrays.fill(a,-1L);     
        }
        
    	long ans=helper(startPos,endPos,k,dp);
        
        return (int)ans%((int)1e9 + 7);
    }
}

// q3

class Solution {
	public int helper(int arr[],int k){
		for(int i=0;i<=n-k;i++){
			boolean check=true;
			itn num=arr[i];
			for(int j=i+1;j<i+k;j++){
				 num=(num&arr[j]);
				 if(num!=0) check=false;
			}

			if(check) return k;
		}

		return 1;
	}
    public int longestNiceSubarray(int[] nums) {

    	int n=nums.length;
        int res=1;
        
        for(int i=1;i<=n;i++){
        	res=Math.max(res,helper(nums,i));
        }

        return res;
    }
}