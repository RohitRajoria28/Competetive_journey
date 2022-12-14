// leetcode 540. Single Element in a Sorted Array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int hi=nums.length-2;
        
        while(l<=hi){
            int mid=(l+hi)>>1;
            
            if(nums[mid]==nums[mid^1]){
                l=mid+1;
            }else{
                hi=mid-1;
            }
        }
        
        return nums[l];
    }
}

// leetcode v1283. Find the Smallest Divisor Given a Threshold
class Solution {
    public int helper(int arr[],int val){
        int sum=0;

        for(int i:arr){
            sum+= i/val;
            
            if(i%val!=0) sum+=1;
        }

        return sum;
    }   
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r=0;
        for(int i:nums){
            r=Math.max(i,r);
        }
        
        int ans=0;
        while(l<=r){
           int mid=(l+r)/2;

           int smallans=helper(nums,mid);
           
            if(smallans<=threshold){
               ans=mid;
               r=mid-1;
           }else  {
              l=mid+1;
           }
        }
        
        return ans;
    }
}


// leetcode 1300. Sum of Mutated Array Closest to Target
class Solution {
    public int helper(int []arr,int val){
        int sum=0;
        for(int i:arr){
            sum+=val<i?val:i;
        }
        return sum;
    }
    public int findBestValue(int[] arr, int target) {
        
        int l=0;
        int r=-1;
        
        for(int i:arr){
            r=Math.max(r,i);
        }
        
        int ans=10000;
        int diff=10000;
        
        while(l<=r){
            int mid=(l+r)/2;
            
            int smallans=helper(arr,mid);
            int curr=Math.abs(target-smallans);
            if(diff>curr){
                ans=mid;
                diff=curr;
            }else if (diff==curr){
               ans=Math.min(ans,mid);
            }
            if(smallans>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        
        
        return ans;
    }
}


//leetcode  1011. Capacity To Ship Packages Within D Days
// Allocate books pages 
class Solution {
    public boolean binarySearch(int tar,int []arr,int days){
        int sum=0;
        int d=1;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>tar){
                d++;
                 
                sum=arr[i];
            }
        }

        return  d<=days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l=-1;
        int r=0;
        
        for(int i:weights){
            l=Math.max(l,i);
            r+=i;
        }
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(binarySearch(mid,weights,days)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;
    }
}


//leetcode  981. Time Based Key-Value Store
class TimeValue {
    String val;
    int timestamp;
    
    public TimeValue(String val, int time){
        this.val = val;
        timestamp = time;
    }
}
class TimeMap {
    Map<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> list = map.getOrDefault(key, null);
        if(list == null) return "";
        int low = 0, high = list.size()-1;
        if(list.get(low).timestamp > timestamp) return "";
        if(list.get(high).timestamp <= timestamp) return list.get(high).val;
        while(low < high){
           int mid = (low + high) / 2;
           if(list.get(mid).timestamp == timestamp) return list.get(mid).val;
           if(list.get(mid).timestamp < timestamp) low = mid + 1;
           else high = mid - 1;
            
        }
        return list.get(low - 1).val;
        
    }
}

// leetcode 875. Koko Eating Bananas

class Solution {
    public int helper(int piles[],int b){
         int sum=0;
        for(int i=0;i<piles.length;i++){
            sum+=Math.ceil((double) piles[i]/b);
        }
        
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int l=0;
        int r=0;
        for(int i:piles) r=Math.max(r,i);
        int ans=(int)1e9;
        while(l<=r){
            int mid=(l+r)/2;
            int time =helper(piles,mid);
            
            if(time<=h){
                ans=Math.min(ans,mid);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        
        return ans;
        
    }
}

//leetcode  744. Find Smallest Letter Greater Than Target

class Solution {
    public char nextGreatestLetter(char[] lt, char target) {
        int l=0;
        int r=lt.length-1;
        
        char ans=lt[0];
        while(l<=r){
            int mid=(l+r)/2;
            
            if(lt[mid]>target){
                ans=lt[mid];
                r=mid-1;
            }else{
             l=mid+1;
            }
        }
         
        
        
        return ans;
    }
}
// leetcode 436. Find Right Interval


class Solution {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer,Integer> map=new HashMap<>(); 
        
        int k=0;
        
        for(int []interval : intervals){
            map.put(interval[0],k++);
        }
        
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        
        int n=intervals.length;
        int res[]=new int[n];
        
        for(int i=0;i<n;i++){
            res[map.get(intervals[i][0])]=map.getOrDefault(binarySearch(intervals[i][1],intervals),-1);
        }
        
        return res;
    }
    
    
    public Integer binarySearch(int val,int arr[][]){
        int lo=0;
        int hi=arr.length-1;
        
        if(val>arr[hi][0]) return null;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
            
            if(val==arr[mid][0]){
                return arr[mid][0];
            }
            if(val>arr[mid][0]){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        
        return arr[lo][0];
    }
}


// leetcode 278. First Bad Version
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=0;
        int r=n;
        int ans=1;
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(isBadVersion(mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        
        return ans;
    }
}


 

// leetcode 1482. Minimum Number of Days to Make m Bouquets
class Solution {
    public int minDays(int[] arr, int m, int k) {
        int l=0;
        int r=(int)1e9;
        if(arr.length<m*k) return -1;


        while(l<r){
            int mid=(l+r)/2;
            int flower=0;
            int days=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]>=mid){
                    flower++;
                }else{
                    if(flower>=k){
                        days++;
                    }
                    flower=0;
                }
                if(flower==k){
                  days++;
                  flower=0;  
                } 
            }

            if(days<m){
                l=mid+1
            }else{
                r=mid;
            }

        }

        return l;
    }
}

// leetcode 410. Split Array Largest Sum
class Solution {
    public boolean numberOfvalidPairLimit(int []arr,int limit,int m){
        int pair=1;
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>limit) return false;
            sum+=arr[i];
            if(sum>limit){
                sum=arr[i];
                pair++;
            }
        }
        
        
        return pair<=m;
        
    }
    public int splitArray(int[] nums, int m) {
         int l=-1;
         int hi=0;
         int sum=0; 
        for(int i:nums){
            sum+=i;
            l=Math.max(l,i);
        }
        
        hi=sum;
        int ans=0;
        while(l<=hi){
            int mid=(l+hi)/2;
            
            if(numberOfvalidPairLimit(nums,mid,m)){
                ans=mid;
                hi=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return ans;
        
        
    }
}

//leetcode  153. Find Minimum in Rotated Sorted Array
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int st=0;
        int end=n -1;
        
        while(st<end){
            int mid=(st+end)/2;
            
            if( nums[mid]>nums[end]){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        
        return nums[st];
    }
}


//leetcode  34. Find First and Last Position of Element in Sorted Array
class Solution {
    public int binaryLast(int []arr,int tar ){
        int l=0;
        int r=arr.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(arr[mid]==tar){
                ans=mid;
                l=mid+1;
            }else if(arr[mid]>tar){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return ans;
    }
    public int binaryFirst(int []arr,int tar ){
         int l=0;
        int r=arr.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(arr[mid]==tar){
                ans=mid;
                r=mid-1;
            }else if(arr[mid]>tar){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=binaryFirst(nums,target);
        int last=binaryLast(nums,target);
        
        return new int[]{first,last};
    }
}
// leetcode 33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int n=nums.length;
        int r=n-1;
        
        
        while(l<=r){
            int mid=(l+r)/2;
             
            if(nums[mid]==target) return mid;
//             left part is sorted 
            if(nums[mid]>=nums[l]){
//               if element lyes in left part 
                if(nums[l]<=target && nums[mid]>=target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else {// right part is sorted 
                 if(nums[mid]<=target && nums[r]>=target){
                     l=mid+1;
                 }else{
                     r=mid-1;
                 }
            }
        }
        
        
        return -1;
        
      
    }
}

// Aggresive Cows 
// 1552. Magnetic Force Between Two Balls
class Solution {
     public    boolean binarySearch(int[]arr, int dis,int cows){
        int n=arr.length;
        int k=arr[0];
         cows--;
        for(int i=1;i<n;i++){
            if(arr[i]-k>=dis){ 
                cows--;
                if(cows==0) return true;
                k=arr[i];
            }
        } 
        return false;
    }
    public int maxDistance(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int l=1;
        int r=arr[n-1]-arr[0];
        int ans=0;
        
       while(l<=r){
           int mid=l+(r-l)/2;
           
           if(binarySearch(arr,mid,k)){
               l=mid+1;
               ans=Math.max(ans,mid);
           }else{
               r=mid-1;
           }
       }
        return ans;
    }
}


// leetcode 4. Median of Two Sorted Arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1); 
        
        int n=nums1.length;
        int m=nums2.length;
        
        int medion=(n+1+m)/2;
        
        int lo=0;
        int hi=n;
        
        while(lo<=hi){
            int cut1=(lo+hi)/2;
            int cut2=medion-cut1;
            
            int l1=cut1==0?-(int)1e9:nums1[cut1-1];
            int l2=cut2==0?-(int)1e9:nums2[cut2-1];
            int r1=cut1==n?(int)1e9:nums1[cut1];
            int r2=cut2==m?(int)1e9:nums2[cut2];
            
            
            if(l1<=r2 && l2<=r1){
                if((m+n)%2!=0){
                    return Math.max(l1,l2);
                }else{
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            } else  if(l1>r2){
                hi=cut1-1;
            }else{
                lo=cut1+1;
            }
        }
        
        return 0.00;
    }
}
 
// leetcode 1011. Capacity To Ship Packages Within D Days
// Allocate Books to Students -(Interview Bit)(same problem)

public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        // if students = A.size() -> ans is maximum element
        // if students= 1 -> ans is sum of all the elements
        
        // range->(maimum element , Sum of all the elements);
        
        // run Binary Search for it 


        
        
    }
}

// leetcode 
class Solution {
    public int binarySearch(int tar,int []arr,int days){
    	int sum=0;
    	days--;
    	for(int i=0;i<arr.length;i++){
    		sum+=arr[i];
    		if(sum>tar){
    			days--;
    			if(days==0) return true;
    			sum=arr[i];
    		}
    	}

    	return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l=-1;
        int r=0;
        
        for(int i:weight){
        	l=Math.max(l,i);
        	r+=i;
        }
        int ans=0;
        while(l<r){
        	int mid=l+(r-l)/2;

        	if(binarySearch(mid,weights,days)){
                ans=mid;
        		r=mid-1
        	}else{
        		l=mid+1;
        	}
        }

        return ans;
    }
}
// 2 question
// Kth- Elemet of two Sorted Arrays

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n>m) return kthElement(arr2,arr1,m,n,k);

        int ans=0;

        int lo=Math.max(0,k-m);
        int hi=Math.min(n,k);


        while(lo<=hi){
        	int cut1=(lo+hi)/2;
        	int cut2=k-cut1;
             

            int l1=(cut1)==0?-(int)1e9:arr1[cut1-1];
            int l2=(cut2)==0?-(int)1e9:arr2[cut2-1];

            int r1=cut1==n?(int)1e9:arr1[cut1];
            int r2=cut2==m?(int)1e9:arr2[cut2];


        	if(l2<=r1 && l1<=r2){
        	return (long)Math.max(l1,l2);
        	}else if(l1>r2){
        		hi=cut1-1;
        	}else{
        		lo=cut1+1;
        	}
        }
        return ans;
    }
}
 

 // 81. Search in Rotated Sorted Array II

class Solution {
    public boolean search(int[] nums, int target) {
        
        while(l<=r){
            int mid=(l+r)/2;

            if(arr[mid]==tar) return true;
// left is sorted 
            if(arr[mid]> arr[l] || arr[mid]> arr[r]){
                if(arr[mid]>=tar && arr[l]<=tar){
                    r=mid-1;
                }else{
                    l=mid+1;
                }


//right is sorted
            }else if(arr[mid]<arr[r] || arr[mid]<arr[l]){

                if(arr[mid]<=tar && arr[r]>=tar){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }else {
                r--;
            }
        }
        return false;
    }
}

// leetcode 74

class Solution {
    public boolean binarySearch(int arr[],int tar){
        int n=arr.length;
        int l=0;
        int r=n-1;

        while(l<r){
            int mid=(l+r)/2;

            if(arr[mid]==tar) return true;
            if(arr[mid]<tar){
                l=mid+1;
            }else if(arr[mid]>tar) {
                r=mid-1;
            }
        }

        return false;

    }
    public boolean searchMatrix(int[][] arr, int target) {
        int r=arr.length;
        int c=arr[0].length;
        if(tar>mat[r-1][c-1]){
            return false;
        }

        for(int a[]: arr){
            if(a[0]<=tar && tar<=a[c-1]){
                return binarySearch(a,tar);
            }else{
                continue;
            }
        }

        return false;
    }
}
// optimised approach


class Solution {
    public boolean searchMatrix(int[][] arr, int tar) {
        int r=arr.length;
        int c=arr[0].length;

        int i=0;
        int j=c-1;

        while(i<n && j>=0){
            if(arr[i][j]==tar) return true;

            if(arr[i][j]<tar){
                i++;
            }else if(arr[i][j]>tar){
                j--;
            }
        }

        return false;
    }
}


// //leetcode 1631. Path With Minimum Effort


class Solution {
    int omin=10000000;
    public int helper(int [][]arr,int diff,int r,int c,int [][]dir){

        int n=arr.length;
        int m=arr[0].length;
        if(r==n-1 && c==m-1){
            return diff;
        }
        int cmin=1000000;
        for(int d=0;d<2;d++){
            int rr=r+dir[d][0];
            int cc=c+dir[d][1];

            if(rr>=0 && rr<n && c>=0 && cc<m){
                cmin=Math.min(cmin,Math.abs(arr[r][c]-arr[rr][cc]));
                omin=Math.min(helper(arr,cmin,rr,cc,dir));
            }
        }

        return omin;
    }
    public int minimumEffortPath(int[][] heights) {
        int dir[][]={{1,0},{0,1}};

        int min=-1;

        return helper(arr,arr[0][0],0,0,dir);
    }
}

// binary search solution

class Solution {
    
    public int helper(int [][]arr,boolean [][]vis,int maxdiff,int r,int c,int lh, int [][]dir){

        int n=arr.length;
        int m=arr[0].length;
        if(n==1 && m==1) return 0;

        if(vis[r][c] || r<0 || c<0 || r>=n || c>=m || Math.abs(arr[r][c]-lh)>maxdiff ) return false;

        if(r==n-1 && c==m-1){
            return true;
        }
        boolean ans=false;
        vis[r][c]=true;
        for(int d=0;d<4;d++){
            int rr=r+dir[d][0];
            int cc=c+dir[d][1];

            ans = ans || helper(arr,vis,maxdiff,rr,cc , arr[r][c], dir);
             
        }
 
        return ans;
    }
    public int minimumEffortPath(int[][] arr) {
          int n=arr.length;
         int m=arr[0].length;

         int l=0;
         int r=(int)1e6;

         int dir[][]={{1,0},{0,1},{0,-1},{-1,0}};

        


         while(l<=r){
            int mid=(l+r-1)>>1;
            boolean vis[][]=new boolean[n][m];
            if(helper(arr,vis,mid,0,0,arr[0][0],dir)){
                r=mid-1;
            }else{
                l=mid+1;
            }
         }
        
        
        return mid;
    }
}

// 1894. Find the Student that Will Replace the Chalk


class Solution {
    public int chalkReplacer(int[] arr, int k) {

        int n=arr.length;

        int pre[]=new int[];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=arr[i]+prev[i-1];
        }

        if(pre[n-1]<=k) k=k%pre[n-1];
        if(k==0) return 0;

        int l=0;
        int r=n-1;

        while(l<=r){
            int mid=(l+r)/2;

            if(k-prev[mid]==0) return mid+1;
            if(k-prev[mid]<0){
                r=mid-1;
            }else{
                l=mid-1;
            }
        }
        

        return l;
    }
}