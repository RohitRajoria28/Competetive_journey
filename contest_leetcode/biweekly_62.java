// q1

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {

    	int ans[][]=new int[m][n];
    	int idx=0;
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			ans[i][j]=original[idx++];
    		}
    	}

    	return  original.length<=m*n?ans:null;
        
    }
}

// 2023. Number of Pairs of Strings With Concatenation Equal to Target

class Solution {
    public int numOfPairs(String[] nums, String target) {

    	StringBuilder str=new StringBuilder();
    	int ans=0;
    	for(int i=0;i<nums.length;i++){
    		for(int j=i+1;j<nums.length;j++){
    			String str=nums[i]+nums[j];
    			if(str.equals(target)) ans+=2;
    		}
    	}

    	return ans;
        
    }
}

class Solution {
    public int findpreIdx(String s,String target){
         
        int idx=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=target.charAt(i)){
                return -1;
            }
        }

        return s.length();
    }
    public int findsufIdx(String s,String target){
        int idx=target.length()-1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=target.charAt(idx--)){
                return -1;
            }
        }
        return idx;
    }
    public int numOfPairs(String[] nums, String target) {

        // StringBuilder str=new StringBuilder();
        int res=0;
        int tn=target.length();
        int prefix[]=new int[tn];
        int suffix[]=new int[tn];

        for(int i=0;i<nums.length;i++){
            
            String s=nums[i];
            
            if(s.length()>=tn) continue;
            int preIdx=findpreIdx(s,target);
            int suffIdx=findsufIdx(s,target);

            if(preIdx!=-1) res+=suffix[preIdx];
            if(suffIdx!=-1) res+=prefix[suffIdx];

            if(preIdx!=-1) prefix[preIdx-1]++;
            if(suffIdx!=-1) suffix[suffIdx+1]++;
        }
        return res;
        
    }
}

// 2024. Maximize the Confusion of an Exam

class Solution {
    public int maxConsecutiveAnswers(String key, int k) {
    	 
    	HashMap<Character,Integer> map=new HashMap<>();
    	int ans=0;
    	int i=0;
    	int j=0;
    	int n=key.length();
    	while(j<n){
    		 char ch=key.charAt(j);
    		 map.put(ch,map.getOrDefault(ch,0)+1);
    		 
    		 int tfreq=map.getOrDefault('T',0);
    		 int ffreq=map.getOrDefault('F',0);
              
            

    		 while(i <j &&  tfreq>k &&  ffreq>k){
                  
    		     char c=key.charAt(i);
    		     int f=map.get(c);
    		     if(f==1){
    		     	map.remove(c);
    		     }else{
    		     	map.put(c,map.getOrDefault(c,0)-1);
    		     }
                 tfreq=map.getOrDefault('T',0);
                 ffreq=map.getOrDefault('F',0);
                 i++;
                 
                 
    		 }
    		  
    		  ans=Math.max(ans,j-i+1);
             j++;
    		 
    	}

    	return ans;
        
    }
}

 
class Solution {
    public boolean isPossible(String key,int len,int k){
        int f=0;
        int t=0;
        for(int i=0;i<len;i++){
            char c=key.charAt(i);
            if(c=='T') t++;
            if(c=='F') f++;
        }

        int l=0;
        int h=len-1;
        int n=key.length();
         if(t<=k || f<=k) return true;   
        
        while(h!=n-1){
            if(key.charAt(l)=='T') t--;
            if(key.charAt(l)=='F') f--;

            l++;
            h++;
            
            if(key.charAt(h)=='T') t++;
            if(key.charAt(h)=='F') f++;

            if(t<=k || f<=k) return true;            
        }
        return false;
    }
    public int maxConsecutiveAnswers(String key, int k) {
        int low=1;
        int hi=key.length();
        int ans=0;
        while(low<=hi){
            int mid=((low+hi)>>1);

            if(isPossible(key,mid,k)){
                ans=mid;
                low=mid+1;
            }else{
                hi=mid-1;
            }

        }

        return ans;
    }
}

// q4 

class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n=nums.length;
        long pref[]=new long[n];
        long suff[]=new long[n];
       
        for(int i=0;i<n;i++){
            if(i==0){
              pref[i]=nums[i];  
                continue;
            } 
            pref[i]=nums[i]+pref[i-1];

        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
              suff[i]=nums[i];  
                continue;
            } 
            suff[i]=nums[i]+suff[i+1];
        }

        HashMap<Long,Long> left=new HashMap<>();
        HashMap<Long,Long> right=new HashMap<>();

        for(int i=0;i<n-1;i++){
            long diff=pref[i]-suff[i+1];
            right.put(diff,right.getOrDefault(diff,0L)+1);
        }
        long maxans=right.getOrDefault(0L,0L);
        for(int i=0;i<n;i++){
            long d=k-nums[i];
            long ans=0;
            if(left.containsKey(d)) ans+=left.get(d);
            if(right.containsKey(-d)) ans+=right.get(-d);

            maxans=Math.max(maxans,ans);

            if(i<n-1){
                long count=pref[i]-suff[i+1];
                long rc=right.get(count);
                left.put(count,left.getOrDefault(count,0L)+1);
                if(rc==1){
                    right.remove(count);
                }else{
                    right.put(count,right.get(count)-1);
                }
            }
        }
        return (int)maxans;

    }
} 