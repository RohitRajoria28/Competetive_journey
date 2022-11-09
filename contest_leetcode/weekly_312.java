// 

class Solution {
    public class pair {
        int val;
        String s;
        pair(int val,String s){
            this.val=val;
            this.s=s;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            return b.val-a.val;
        });

        for(int i=0;i<names;i++){
            int val=heights[i];
            int str=names[i];

            pq.add(new pair(val,s));
        }

        int n=names.length;
        String []ans=new String[n];
        int idx=0;
        while(pq.size()>0){
            ans[idx++]=pq.poll().s;
        }
        return ans;

    }
}

//leetcode Longest Subarray With Maximum Bitwise AND

class Solution {
    public int longestSubarray(int[] nums) {
        
        int max=0;
        int alen=0;
        
        for(int e: nums){
            max=Math.max(e,max);
        }
        
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max) alen++;
            else alen=0;
            
            ans=Math.max(ans,alen);
        }
        
        return ans;
        
    }
}

// 


class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        int n=nums.length;
        int inc[]=new int[n];
        int dc[]=new int[n];
        

        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]){
                inc[i]=inc[i-1]+1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                dc[i]=dc[i+1]+1;
            }
        }

        List<Integer> ans=new ArrayList<>();

        for(int i=k;i<n-k;i++){
            if(inc[i-1]>=k && dc[i+1]>=k) ans.add(i);
        }
        Collections.sort(ans);
        return ans;

    }
}

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {


        int n=nums.length;
        int []right=new int[n];
        int left[]=new int[n];
        
        Stack<Integer> st=new Stack<>();

        // right
        for(int i=n-1;i>=0;i--){
            int val=nums[i];

            while(st.size()!=0 && nums[st.peek()]>=val){
                st.pop();
            }

            if(st.size()>0){
               right[i]=st.peek()-1;
            }else{
                right[i]=n;
            }

            st.push(i);
            
        }
        for(int i: right){
            System.out.print(i+" ");
        }

        while(st.size()!=0) st.pop();


        for(int i=0;i<n;i++){
            int val=nums[i];

            while(st.size()!=0 && nums[st.peek()]>=val){
                st.pop();
            }

            if(st.size()>0){
               left[i]=st.peek()+1;
            }else{
                left[i]=-1;
            }

            st.push(i);
        }
        System.out.println();
        for(int i: left){
            System.out.print(i+" ");
        }
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=k;i<n-k;i++){
            
            int rval=right[i+1];
            int lval=left[i-1];
            
            if(rval+1>=k-1 && lval-1<=k-1) ans.add(i);
        }

        return ans;
    }
}