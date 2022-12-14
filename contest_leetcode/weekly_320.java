// 

class Solution {
    public int unequalTriplets(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int val=nums[i];
            for(int j=i+1;j<n;j++){
                int val2=nums[j];
                if(val!=val2){
                     for(int k=j+1;k<n;k++){
                        int val3=nums[k];

                        if(val3!=val && val3!=val2) count++;
                     }
                }
               
            }
        }

        return count;     
    }
}

// 

class Solution {
    public List<Integer> helper(TreeNode root,int tar){

         int min= -(int)1e9;
         int max=(int)1e9;


         TreeNode node=root;

         while(node!=null){
            int tv=node.val;

            if(tv<=tar && tv>min){
                min=tv;
            }
            if(tv>=tar && tv<max){
                max=tv;
            }

            if(node.val==val){

                min=val;
                max=val;
                break;

            }else if(node.val<val){
                node=node.right;
            }else{
                node=node.left;
            }
         }

         List<Integer> ans=new ArrayList<>();
         ans.add(min);
         ans.add(max);
         
         return ans;
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        
        for(int i:queries){
            

            
           List<Integer>  smallans=helper(root,i);

            ans.add(smallans);
        }


        return  ans;
    }
}

// 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> find(TreeNode r,int tr){

         int min= -(int)1e9;
         int max=(int)1e9;


         TreeNode nd=r;
 
         while(nd!=null){
            int tv=nd.val;

            if(tv<=tr && tv>min){
                min=tv;
            }
            if(tv>=tr && tv<max){
                max=tv;
            }

            if(nd.val==tr){

                min=tr;
                max=tr;
                break;

            }else if(nd.val<tr){
                nd=nd.right;
            }else{
                nd=nd.left;
            }
         }

         List<Integer> aa=new ArrayList<>();
         ans
        if(min==-(int)1e9){
            min=-1;
        }
         aa.add(min);
        if(max==(int)1e9){
            max=-1;
        }
         aa.add(max);
         
         return aa;
    }
    public List<List<Integer>> closestNodes(TreeNode r, List<Integer> qq) {
        List<List<Integer>> a=new ArrayList<>();
        
        for(int k:qq){
           
           List<Integer>  sa=find(r,k);

            a.add(sa);
        }


        return  a;
    }
}

// 

class Solution {
    public int unequalTriplets(int[] arr) {
        int ans=0;
          
        int len=arr.length;
         
        for(int i=0;i<len;i++){
            int v=arr[i];
            for(int j=i+1;j<len;j++){
                int v2=arr[j];
                if(v!=v2){
                     for(int k=j+1;k<len;k++){
                        int v3=arr[k];

                        if(v3!=v  && v3!=v2) ans++;
                     }
                }
               
            }
        }

        return ans;     
    }
}