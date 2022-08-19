// gfg-> Next Greater Element

class Solution
{
    
    public static long[] nextLargerElement(long[] arr, int n)
    { 
         Stack<Long> st=new Stack<>();
         st.add(arr[n-1]);
         long ans[]=new long[n];
         ans[n-1]=-1;
         for(int i=n-2;i>=0;i--){
         	long val=arr[i];
         	while(!st.empty() && st.peek()<val){
         		st.pop();
         	}

         	ans[i]=st.empty()?-1:st.peek();
         	st.push(val);
         }

         return ans;
    } 
}
// approach 2 from left to right 


class Solution
{
    
    public static long[] nextLargerElement(long[] arr, int n)
    { 
         Stack<Long> st=new Stack<>();
         st.add(0);
         long ans[]=new long[n];
         for(int i=1;i<n;i++){
         	long val=arr[i];
         	 
         	 while(!st.empty() && arr[st.peek()]<val){
         	 	ans[st.pop()]=val;
         	 }
         	 st.push(i);
         }

         while(st.size()>0){
         	ans[st.pop()]=-1;
         }

         return ans;
    } 
}

// leetcode 496. Next Greater Element I
// approch from left to right ( similer to next greater using hashmap)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int ans[]=new int[nums1.length];

        int n=nums2.length;
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++){
        	int val=nums2[i]
        	while(!st.empty() && nums2[st.peek()]<val){
        		map.put(nums2[st.pop()],val);
        	}

        	st.push(i);
        }

        while(!st.empty()){
        	map.put(nums2[st.pop()],-1);
        }
        int idx=0;
        for(int i:nums1){
        	ans[idx++]=map.get(i);
        }

        return ans;
    }
}

// pepcoding -> Next Greater on the left 

public static int[] solve(int[] arr) {
    int n=arr.length;
    int ans[]=new int[n];

    Stack<Integer> st=new Stack<>();
    st.push(n-1);
    for(int i=n-2;i>=0;i--){
    	int val=arr[i];

    	while(!st.empty() && arr[st.peek()]<val){
    		ans[st.pop()]=val;

    	}
    	st.push(i);
    }
    while(!st.empty()){
    	ans[st.pop()]=-1;
    }

    return ans;
}

// 
// leetcode : 1475. Final Prices With a Special Discount in a Shop
// Next smaller element in the right 


class Solution {
    public int[] finalPrices(int[] arr) {
        int n=arr.length;
        int ans[]=new int[n];

        Stack<Integer> st=new Stack<>();
        ans[n-1]=arr[n-1];
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
        	int val=arr[i];
        	while(!st.empty() && st.peek()>val){
        		st.pop();
        	}
        	if(st.empty()){
        		ans[i]=arr[i];
                st.push(arr[i]);
        	} else{
                ans[i]=arr[i]-st.peek();
       			st.push(arr[i]);
            }
        		
        	
        }

        return ans;
    }
}

// gfg-> next smaller element on left  

// left to right approach
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
         Stack<Integer> st=new Stack<>();
         List<Integer> ans=new ArrayList<>();

         st.push(a[0]);
         ans.add(-1);
         for(int i=1;i<n;i++){
            int val=a[i];
            while(!st.empty() && st.peek()>=val){
                st.pop();
            }
            if(st.empty()) ans.add(-1);
            else{
                ans.add(st.peek());
            }
            st.push(val);
         }
         return ans;
    }
    
}

// right to left approach 

class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
         Stack<Integer> st=new Stack<>();
         List<Integer> ans=new ArrayList<>();
         int smallans[]=new int[n];
         st.push(n-1);
         
         for(int i=n-2;i>=0;i--){
            int val=a[i];
            while(!st.empty() && val<a[st.peek()]){
                smallans[st.pop()]=val;
            }
             
            st.push(i);
         }

         while(!st.empty()){
            smallans[st.pop()]=-1;
         }
         for(int i=0;i<n;i++){
            ans.add(smallans[i]);
         }
         return ans;
    }
    
}

// 503. Next Greater Element II


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n*2];
        for(int i=0;i<n;i++){
            arr[i]=arr[i+n]=nums[i];
        }
         
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int small[]=new int[n*2];

        for(int i=0;i<n*2;i++){
            int val=arr[i];
            while(!st.empty() && arr[st.peek()]<val){
                smallans[st.pop()]=val;
            }
            st.push(i);
        } 

        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=smallans[i];
        }

        return ans;

    }
}

// leetcode 503. Next Greater Element II

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n*2];
        for(int i=0;i<n;i++){
            arr[i]=arr[i+n]=nums[i];
        }
         
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int smallans[]=new int[n*2];
        Arrays.fill(smallans,(int)1e9+1);
        for(int i=1;i<n*2;i++){
            int val=arr[i];
            while(!st.empty() && arr[st.peek()]<val){
                smallans[st.pop()]=val;
            }
            st.push(i);
        } 
         
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=smallans[i]!=(int)1e9+1?smallans[i]:-1;
        }

        return ans;

    }
}