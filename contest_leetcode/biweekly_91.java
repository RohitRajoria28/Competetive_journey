
// Number of Distinct Averages

class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        int  i=0;
        int j=n-1;
        HashSet<Double> set=new HashSet<>();

        while(i<j){
            set.add((nums[i]+nums[j])/2);
            i++;
            j--;
        }
        return set.size();
    }
}


// q2
class Solution {
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[]=new int[high+1];
        
        dp[0]=1;
        int ans=0;
        int mod=(int)1e9+7;
         for(int i=1;i<=high;i++){
             if(i>=zero) dp[i]=(dp[i]+dp[i-zero])%mod;
             if(i>=one) dp[i]=(dp[i]+dp[i-one])%mod;
             if(i>=low) ans=(ans+dp[i])%mod;
         }
        return ans;
    }
}