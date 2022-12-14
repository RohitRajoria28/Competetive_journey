// 911

class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt();
            if(c=='(' && st.peek()==')'){
                st.pop();
            }else if(c==')' && st.peek()=='('){
                st.pop();
            }else{
                st.push(c);
            }
        }
        return st.size();
        
    }
}

// 

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
         Stack<Integer> st=new Stack<>();
         st.push((int)1e9);
         int n=nums2.length;
         
         HashMap<Integer,Integer> map=new HashMap<>();

          
         for(int i=n-1;i>=0;i--){
            int val=nums2[i];

            while(st.peek()<val){
                st.pop();
            }
            if(st.size()>1 && st.peeek()>val){
                map.put(val,st.peek());
            }else{
                map.put(val,-1);
            }
            st.push(val);
         }
         int res[]=new int[nums1.length];
          int idx=0;
          for(int i: nums1){
            res[idx++]=map.get(i);
          }

         return res;
        
    }
}

// 

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        st.push('$');
        for(int i=0i<n;i++){
            if(st.peek()=='(' && ch==')'){
                st.pop();
            }else{
                st.push(ch);
            } 
        }

        return st.size()-1;
    }
}