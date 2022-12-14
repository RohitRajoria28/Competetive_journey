 
// leetcode 1300
 class Solution {
 	public int helper(int []arr,int val){
 		int sum=0;
 		for(int i: arr){
 			sum+=(val<i)?val:i;
 		}
 		return sum;
 	}
    public int findBestValue(int[] arr, int target) {
        int sum=0;
        int max=0;
        for(int i:arr) max=Math.max(max,i); sum+=i;
        
        int i=1;
        int j=max;
        int diff=10000;
        int ans=100000;
        while(i<=j){
            int mid=(i+j)/2;
            
            int smallans=helper(arr,mid);
            int curr=Math.abs(smallans-target);

            if(diff>curr){
            	ans=mid;
            	diff=curr;
            }else if(diff==curr){
            	ans=Math.min(ans,mid);
            }
            if(smallans>target){
            	r=mid-1;
            }else{
            	l=mid+1;
            }
        }

        return ans;
        
    }
}

// leetcode 1011 

class Solution {
    public boolean helper(int arr[],int minw,int tar){
        
        int days=0;
        int dsum=0;
        
        for(int i=0;i<arr.length;i++){
            dsum+=arr[i];
            if(dsum>minw){
                days++;
                dsum=arr[i];
            }
        }

        return days<=tar;
    }

    public int shipWithinDays(int[] arr, int tar) {
        
        int l=1;
        int r=0;
         

        for(int i: arr){
            r+=;
            l=Math.max(i,l);
        }

int ans=0;
        while(l<=r){
            int mwt=(l+r)/2;

            boolean  cdays=helper(arr,mwt,tar);
            if(cdays){
                ans=mwt;
                r=mwt-1;
            }else{
                l=mwt+1;
            }

        }

        return ans;
        
    }
}

// 875. Koko Eating Bananas

class Solution {
    public int helper(int arr[],int k){
        int sum=0;
        for(int i: arr){
            sum+=Math.ceil((double)(arr[i]/k));
        }
        return sum;
    }
    public int minEatingSpeed(int[] arr, int h) {
        int l=0;
        int r=0;

        for(int i: arr) r=Math.max(r,i);


        int ans=10000000;
        while(l<=r){
            int mid=(l+r)/2;
            int cdays=helper(arr,mid);

            if(cdays<=tar){
                ans=Math.min(ans,mid);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;
    }
}

// leetcode 275 

class Solution {
    public int[] findRightInterval(int[][] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int k=0;
        for(int ar[]: arr){
            map.put(ar[k][0],k++);
        }

        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        })
        int res[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[map.get(arr[i][0])]=map.getOrDefault(binarySearch(arr[i][1],arr),-1)
        }

        return res;

    }

    public int binarySearch(int arr[],int val){
        if(arr[arr.length-1][0]<val ) return null;

        int lo=0;
        int hi=arr.length-1;

        while(lo<=hi){
            int mid=(lo+hi)/2;

            if(arr[mid][0]==val) return arr[mid][0];

            if(val>arr[mid][0]){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }

        return arr[lo][0];
    }
}

// 

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
            int k=0;
            for(int ar[]: arr){
                map.put(ar[k][0],k++);
            }

             
        int res[]=new int[arr.length];  

        for(int i=0;i<arr.length;i++){
            int val=map.ceilKey(arr[i][1]);

            res[i]=val==null?-1:map.get(val);
        }     
        return res;
    }
}

// 

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
               
    }
}