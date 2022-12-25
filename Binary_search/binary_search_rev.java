 
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
    public boolean helper(int []arr,long minDays,int m,int k){
        int flowersInRow=0;
        int days=0;

        for(int flower:arr){
            if(flower<=minDays){
                flowersInRow++;
            }else{
                if(flowersInRow>=k) days++;
                days=0;
            }

            if(flowersInRow>=k){
                days++;
                flowersInRow=0;
            }
        }

        return days>=m;
    }

    public int minDays(int[] arr, int m, int k) {
        if(arr.length<m*k) return -1;

        long l=0;
        long r=-1;

        for(int i: arr) r=Math.max(r,i);

        while(l<r){
            long mid=l+(r-l)/2;

            if(helper(arr,mid,m,k)){
                r=mid-1;
            }else{
                l=mid;
            }
        }

        return l;
    }
}

// 410. Split Array Largest Sum

class Solution {
    public boolean isValid(int []arr,int limit,int k){
        int sum=0;

        for(int i: arr){
            if(i>limit) return false;

            if(limit>sum){
                sum+=i;
            }else{
                sub++;
                sum=i;
            }
        }

        return (k==sub);
    }

    public int splitArray(int[] nums, int m) {
        int l=-1;
        int r=0;

        for(int i: arr){
            l=Math.max(l,i);
            r+=i;
        }        

        while(l<r){
            int mid=(l+r)/2;

            if(isValid(arr,mid,k)){
                r=mid;
            }else{
                l=mid+1;
            }
        }

        return r;
    }
}
// letcpde 153

class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length;
        int ans=0;
        while(l<=r){
            int mid=(l+r)/2;

            if(arr[r]>=arr[mid]){
                ans=arr[mid];
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}

// 

class Solution {
    public int First(int arr[],int tar){
        int l=0;
        int r=arr.length-1;
        int ans=0;
        while(l<=r){
            int mid=(l+r)/2;

            if(arr[mid]>=tar){
                if(arr[mid]==tar){
                    ans=mid;
                }
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int Last(int arr[],int tar){
        int l=0;
        int r=arr.length-1;
        int ans=0;
        while(l<=r){
            int mid=(l+r)/2;

            if(arr[mid]<=tar){
                if(arr[mid]==tar){
                    ans=mid;
                }
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int lidx=Last(nums,target);
        int fidx=First(nums,target);

        if(lidx==-1 && fidx==-1) return new int[]{-1,-1};
        return new int[]{lidx,fidx};
    }
}

// medium of 2 sorted array 


class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if(arr2.length<arr1.length) findMedianSortedArrays(arr2,arr1);

        int n1=arr1.length;
        int lo=0;
        int hi=n1;
        int n2=arr2.length;

        while(lo<=hi){
            int cut1=(lo+hi)>>1;
            int cut2=(n1+n2+1)/2-cut1;

            int l1=cut1==0?-(int)1e9?arr1[cut1-1];
            int l2=cut2==0?-(int)1e9?arr2[cut2-1];

            int r1=cut1>=n1?(int)1e9?arr1[cut1];
            int r2=cut2>=n2?(int)1e9?arr1[cut2];


            if(l1<=r2 && l2<=r1){
                if(n1+n2%2!=0) return (double)(Math.max(l1,l2));
                else{
                    return (double)((Math.max(l1,l2)+Math.min(r1,r2))/2.0);
                }

            }else{
                if(l1>r2){
                    hi=cut-1;
                }else{
                    lo=cut1+1;
                }
            }

        }

        return 0;
    }
}

// 

class Solution {
    public boolean isValidSpace(int []arr,int space,int m){
        
        int curr=arr[0];
        int i=1;
        int cow=0;
        while(i<arr.length){
            int dis=0;
            while(i<arr.length && (arr[i]-curr)<m){
                i++;
            }
            if(arr[i]-curr) cow++;
            curr=arr[i];
            i++;
        }

        return cow>=m;
    }
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int n=arr.length;
        int hi=arr[n-1]-arr[0];
        int lo=(arr[1]-arr[0]);

        int ans=0;
        while(lo<=hi){
            int mid=(hi+lo)>>1;

            if(isValidSpace(arr,mid,m)){
                ans=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }

        return ans;
    }
}




// 


class Solution {
    public int search(int[] nums, int target) {
        int lo=0;
        int hi=nums.length-1;

        while(lo<=hi){
            int mid=(lo+hi)/2;
            // left part is sorted
            if(arr[mid]==tar) return mid;
            if(arr[lo]<=arr[mid]){
                if(arr[lo]<=tar  && arr[mid]>=tar){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else{
                 if(arr[r]>=tar  && arr[mid]<=tar){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }

        retrun mid;
    }
}

// 1011

class Solution {
    public boolean isValid(int arr,int cap,int mdays){
        int days=0;

        for(int i:arr){
            sum+=i;
            if(sum>cap){
                days++;
                sum=i;
            }
        }
        return days>=mdays;
    }
    public int shipWithinDays(int[] arr, int days) {
       int l=0;
       int r=0;

       for(int i: arr){
         r+=i;
         l=Math.max(l,i);
       } 

int ans=0;
       while(l<=r){
          int mid=(l+r)>>1;

          if(isValid(arr,mid,days)){
            ans=mid;
            r=mid-1;
          }else{
            l=mid+1;
          }
       }

       return ans;
    }
}


// 81. Search in Rotated Sorted Array II

class Solution {
    public boolean search(int[] arr, int tar) {
        int lo=0;
        int hi=arr.length-1;

        while(lo<=hi){
            int mid=(lo+hi)/2;
            // left part is sorted
            if(arr[mid]==tar) return true;
            if(arr[lo]<=arr[mid]){
                if(arr[lo]<=tar  && arr[mid]>=tar){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else{
                 if(arr[r]>=tar  && arr[mid]<=tar){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }

        retrun false;
    }
}

// 

class Solution {
    public boolean search(int[] nums, int target) {
        int lo=0;
        int hi=arr.length-1;

        while(lo<=hi){
            int mid=(lo+hi)/2;
            // left part is sorted
            if(arr[mid]==tar) return true;

            if(arr[lo]<arr[mid] || arr[mid]>arr[hi]){
                if(arr[lo]<=tar  && arr[mid]>=tar){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
                // right sorted
            }else if(arr[hi]>arr[mid] || arr[mid]<arr[l]){
                 if(arr[r]>=tar  && arr[mid]<=tar){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }else{
            r--;
        }

        retrun false;
    }
}


// leetcode 74

class Solution {
    pubic boolean helper(int arr[],int tar){
        int l=0;
        int r=arr.length-1;

        while(l<=r){
            int mid=(l+r)>>1;

            if(arr[mid]==tar) return true;

            if(arr[mid]>tar){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return false;
    }
    public boolean searchMatrix(int[][] arr, int target) {
        
        int r=arr.length;
        int c=arr[0].length;

        for(int ar[]: arr){
            if(ar[0]>= tar && ar[c-1]){
                return helper(ar,tar) ?true:false;
            }
        }

        return false;

    }
}


// leetcode 1631 min Diff to travel


class Solution {
    public boolean isValid(int [][]arr,int row,int col,int prev,boolean [][]vis,int maxDiff,,int dir[][]){

        int n=arr.length;
        int m=arr[0].length;

        if(row>=n || col>=m || row<0 || col<0 || Math.abs(prev-arr[row][col])>maxDiff || vis[row][col]){
            return false;
        }
        if(row==n-1 && col==m-1) return true;
        vis[row][col]=true;

        for(int d=0;d<4;d++){
            int r=row+dir[d][0];
            int c=col+dir[d][1];

            ans=ans || isValid(arr,r,c,arr[row][col],vis,maxDiff,dir);
        }

        return ans;

    }
    public int minimumEffortPath(int[][] arr) {
        int l=0;
        int r=(int)1e6;

        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};

        while(l<=r){
            int mid=(l+r)>>1;
            boolean vis[][]=new boolean[arr.length][arr[0].length];
            if(isValid(arr,0,0,arr[0][0],vis,mid,dir)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
    }
}




