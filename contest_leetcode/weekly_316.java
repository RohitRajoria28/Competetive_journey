q2
class Solution {
    public boolean findGCD(int num,int k){
        if(num%k!=0) return false;
        
        for(int i=k+1;i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public int subarrayGCD(int[] nums, int k) {
         int ans=0;
        int  n=nums.length;
         int arr[]=new int[n];
        
         for(int i=0;i<n;i++){
            if(findGCD(nums[i],k)){
                arr[i]=1;
                ans++;
            }
         }
        for(int i: arr){
            // System.out.print(i+" ");
            int m=9%3;
            System.out.print(m+" ");
        }

         int i=-1;
         int j=0;

         while(j<n){

            if(arr[j]==0){
                i=j;
            }


            if(j-i>=2) ans++;
            j++;
         }

         return ans;
    }
}