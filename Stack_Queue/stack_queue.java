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

// 
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new 
    }
}

// 402. Remove K Digits

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<num.length();i++){
            int n=num.charAt(i)-'0';
            
            while(!st.empty() && k>0 && st.peek()>n){
                st.pop();
                k--;
            }
            st.push(n);
            
        }
        
        while(k-->0) st.pop();
        
        int []arr=new int[st.size()];
        int idx=st.size()-1;
        
        while(st.size()>0) arr[idx--]=st.pop();
        for(int i:arr){
            System.out.print(i+" ");
        }
        int d=0;
        while(d<arr.length && arr[d]==0) d++;
        
        StringBuilder str=new StringBuilder();
        
        while(d<arr.length) str.append(arr[d++]+"");
        
        return str.length()!=0?str.toString():"0";
    }
} 
// leetcode 316 remove Duplicate Letters 


class Solution {
    public String removeDuplicateLetters(String s) {
        int last[]=new int[26];
        
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }

        boolean seen[]=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(seen[c-'a']) continue;

            while(!st.empty() && c<st.peek() && i<last[st.peek()-'a']){
                seen[st.pop()-'a']=false;
            }

            seen[c-'a']=true;
            st.push(c);
        }


        StringBuilder str=new StringBuilder();

        while(!st.empty()) str.append(st.pop());

        return str.reverse().toString();
    }
}

// 42. Trapping Rain Water

class Solution {
    public int trap(int[] arr) {
        int rmax=-100000;
        int lmax=-1;

        int l=0;
        int r=arr.length-1;
        int water=0;
        while(l<r){
            lmax=Math.max(lmax,arr[l]);
            rmax=Math.max(rmax,arr[r]);

            if(lmax<=rmax){
                water=lmax-arr[l];
                l++;
            }else{
                water=rmax-arr[r];
                r--;
            }
        }


        return water;
        
    }
}

// leetcode  407  trapping rain water 2 

class Solution {
    public class pair implements Comparable<pair>{
        int ht;
        int r;
        int c;

        pair(int ht,int r,int c){
            this.r=r;
            this.c=c;
            this.ht=ht;
        }

        public int compareTo(pair o){
            return this.ht-o.ht;
        }
    }
    public int trapRainWater(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;

        boolean [][]vis=new boolean[n][m];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1 ){
                    pq.add(new pair(arr[i][j],i,j));
                    vis[i][j]=true;
                }
            }
        }
        int water=0;

        int dir[][]={{1,0},{-1,0},{0,-1},{0,1}};
        while(pq.size()!=0){
            pair rpair=pq.remove();

            for(int d[]:dir){
                int r=rpair.r+d[0];
                int c=rpair.c+d[1];

                if(r<n && r>=0 && c<m && c>=0 && !vis[r][c] ){
                    
                    water+=Math.max(0,rpair.ht-arr[r][c]);
                    if(arr[r][c]>rpair.ht){
                        pq.add(new pair(arr[r][c],r,c));
                    }else{
                        pq.add(new pair(rpair.ht,r,c));
                    }

                    vis[r][c]=true;
                }
            }
        }


        return water;
    }
}


// Number of valid subarrays

public static int validSubarrays(int[] nums) {
     int n=nums.length;
     int []lsmall=new int[n];
     
     Stack<Integer> st=new Stack<>();
     lsmall[n-1]=n-1;
     st.push(n-1);
    //  finding smaller on right 
     for(int i=n-2;i>=0;i--){
         int val=nums[i];
          while(!st.empty() && nums[st.peek()]>val){
              st.pop();
          }
          if(!st.empty()){
              lsmall[i]=st.peek();
          }else{
              lsmall[i]=i;
          }
          st.push(nums[i]);
     }
     
     
     int ans=0;
     
     for(int i=0;i<n;i++){
         ans+=lsmall[i]-i;
         
     }
     
     
     return ans;
  }


  //Basic Calculator

  class Solution {
    public int calculate(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        int sum=0;
        int sign=1;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int val=0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    val+=val*10+(s.charAt(i)-'0');
                }
                i--;
                val*=sign;
                sum+=val;
                sign=+1;
            }else if(c=='('){

                st.push(sum);
                st.push(sign);
                sum=0;
                sign=1;

            }else if(c==')'){
                sum*=st.pop();
                sum+=st.pop();

                sign=1;
            }else if(c=='-'){
                sign=-1;
            }
        }

        return sum;
    }
}

// 227. Basic Calculator II

class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        
        int sum=0;
        char sign='+';
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int val=0;
                while(i<n && Character.isDigit(s.charAt(i)) ){
                    val=val*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(sign=='+'){
                    st.push(val);
                }else if(sign=='-'){
                    st.push(-val);
                }else if(sign=='*'){
                    int ans=st.pop();
                    ans*=val;
                    st.push(ans);
                }else if(sign=='/'){
                    int ans=st.pop();
                    ans/=val;
                    st.push(ans);
                }
            }else if(ch!=' '){
                sign=c;
            } 
        }

        int ans=0;

        while(!st.empty()) ans+=st.pop();


        return ans;
        
    }
}


 //lintcode  849 · Basic Calculator III

public class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        char sign='+';
        int sum=0;
        int  n=s.length();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(Character.isDigit(c)){
                int val=0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    val=val*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(sign=='+'){
                    st.push(val);
                }else if(sign=='-'){
                    st.push(-val);
                }else if(sign=='/'){
                    int ans=st.pop();
                    ans/=val;
                    st.push(ans);
                }else if(sign=='*'){
                    int ans=st.pop();
                    ans*=val;
                    st.push(ans);
                }
            }else if(c=='('){
                while(!st.empty()) sum+=st.pop();
                st.push(sum);
                st.push(sign-'0');
                st.push(2147483648);
                sum=0;
                sign='+';
            }else if(c==')'){
                while(!st.empty() && st.peek()!=2147483648) sum+=st.pop();
                st.pop();
                if(st.pop()+ '0' =='+'){
                    sum+=st.po();
                }else if(st.pop()+ '0'=='-'){
                    int small=st.pop();
                     sum=small-sum;
                     st.push(sum);
                }else if(st.pop()+ '0'=='/'){
                    int small=st.pop();
                    sum=small/sum;
                    st.push(sum);
                }else if(st.pop()+ '0'=='*'){
                    int small=st.pop();
                    sum=small/sum;
                    st.push(sum);
                }

            }else if(c!=' '){
                sign=c;
            }
        }

        int ans=0;

        while(!st.empty()) ans+=st.pop();

        retrun ans;
    }
}

// leetcode 1673. Find the Most Competitive Subsequence

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st=new Stack<>();


        int n=nums.length;

        for(int i=0;i<n;i++){
            while(!st.empty() && st.peek()>nums[i] && (k-st.size()>=n-i-1)){
                st.pop();
            }

            if(st.size()<k){
                st.push(nums[i]);
            }

        }

        int ans[]=new int[k];

        int i=k-1;
        while(i-->=0) ans[i]=st.pop();
        return ans;
    }
}

// 1381. Design a Stack With Increment Operation

class CustomStack {
    int inc[];
    int st[];
    int idx;

    public CustomStack(int max ) {
        inc=new int[max];
        st=new int[max];
        idx=-1;
    }
    
    public void push(int x) {
        if(idx+1==inc.length ) return ;
        idx++;
        st[idx]=x;
        inc[idx]=0;
        
    }
    
    public int pop() {
        if(idx==-1) return -1;
        
        int val=st[idx];
        int ic=inc[idx];
        idx--;
        if(idx>=0){
            inc[idx]+=ic;
        }
        
        return val+ic;
    }
    
    public void increment(int k, int val) {
        int i=Math.min(k-1,idx);
        
        if(idx>=0) inc[i]+=val;
        
    }
}

 // 641. Design Circular Deque

class MyCircularDeque {
    public class Node{
        int val;
        Node prev,next;
        Node(){

        }
        Node(int val){
            this.val=val;
        }
        public void delete(){
            prev.next=next;
            next.prev=prev;
        }
    }
    int size;
    Node front;
    Node rear;
    int maxSize;
    public MyCircularDeque(int k) {
        front=new Node();
        rear=new Node();
        maxSize=k;
        front.next=rear;
        rear.prev=front;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(size==maxSize) return false;
        Node n=new Node(value);
        n.prev=front;
        n.next=front.next;

        n.next.prev=n;
        front.next=n;

        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
         if(size==maxSize) return false;
        Node n=new Node(value);

        n.next=rear;
        n.prev=rear.prev;
        
        n.prev.next=n;
        rear.prev=n;
        size++;        
        
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        Node n=front.next;
        int val=n.val;

        n.delete();
        size--;
        return true;
        
    }
    
    public boolean deleteLast() {
        if(size==0) return false;

        Node n=rear.prev;
        int val=n.val;
        n.delete();
        size--;
        return true;
    }
    
    public int getFront() {
        if(size==0) return -1;

        return front.next.val;
    }
    
    public int getRear() {
        if(size==0) return -1;
        return rear.prev.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==maxSize;
    }
}


// LintCode maxStack 

class MaxStack {
    Stack<Integer> data,max;

    public MaxStack() {
         data=new Stack<>();
         max=new Stack<>();
    }

      
    public void push(int x) {
         

        data.push(x);
        int maxx=x;
        if(max.size()>0)
         maxx=Math.max(x,max.peek());
       
       max.push(maxx);
    }

    public int pop() {
        if(data.size()<=0) return -1; 
         max.pop();
        return data.pop();
    }
 
    public int top() {
        return data.peek();
    }

    
    public int peekMax() {
        return max.peek();
    }

   
    public int popMax() {

        int tbr=max.peek();
        Stack<Integer> buffer=new Stack<>();
        while(tbr!=data.peek()){
            int res=pop();  
           buffer.push(res); 
        }  
        pop();

        while(buffer.size()>0) push(buffer.pop());

        return tbr;
    }
} 


// leetcode check if word is valid after insertion 

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
         
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c=='a' || c=='b'){
                st.push(c);
            }else {
                if(st.size()>=2 && (st.pop()=='b' && st.pop()=='a')){
                    
                }else{
                    return false;
                }

            } 
        }

        return st.size()==0;
    }
}

//leetcode  design Hit counter

static class HitCounter {
 
   ArrayDeque<Integer> dq   ;
    public HitCounter() {
        dq=new ArrayDeque<>();
    }
 
    public void hit(int timestamp) {
    dq.add(timestamp);
        int start=timestamp-300+1;
        while(   dq.peek()<start) dq.remove();
        
    }
 
    public int getHits(int timestamp) {
        
       int start=timestamp-300+1;
        while(dq.peek()<start) dq.remove();
        

        return dq.size();
    }

  
}

// 907. Sum of Subarray Minimums

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            left[i]=(i-st.peek());
            st.push(i);
        }

        while(!st.empty()){
            st.pop();
        }

        for(int i=n-1;i<0;i--){
            while(!st.empty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            right[i]=(st.peek()-i);
            st.push(i);
        }

        int ans=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            ans+=(arr[i]*left[i]*right[i])%mod;
        }

        return ans;

    }
}