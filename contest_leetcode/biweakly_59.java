// 1974. Minimum Time to Type Word Using Special Typewriter
 class Solution {
    

    public int minTimeToType(String word) {
    	 	int time=0;
 	 		char prev='a';
    		
    		for(int i=0;i<word.length();i++){
    			char c=word.charAt(i);

    			tim=Math.min(Math.abs(prev-c),Math.min(pre-'a'+'z'-c,'z'-prev+ch-'a'));
    			time+=tim+1;
    			prev=c;
    		}

		return time;        
    }
}

// 

class Solution {
   public TreeNode helper(TreeNode node,int limit,int sum){
      if(node==null) return null;

      if(node.left==null && node.right==null){
         if(node.val+sum<limit) return null;
         else return node;
      }

      node.left=helper(node.left,limit,sum+node.val);
      node.right=helper(node.right,limit,sum+node.val);

      if(node.left==null && node.right==null) return null;
      return node;
   }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode root=helper(root,limit,0);
        
        return root;
    }
}

// leetcode 1110. Delete Nodes And Return Forest

class Solution {
   public TreeNode helper(TreeNode node,HashSet<Integer> set,List<TreeNode> list){
      if(node==null) return null;

      node.left=helper(node.left,set,list);
      node.right=helper(node.right,set,list);

      if(set.contains(node.val)){
         if(node.left!=null) list.add(node.left);
         if(node.right!=null) list.add(node.right);

         return null; 
      }
      return node;
   }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
         List<TreeNode> list=new ArrayList<>();

         HashSet<Integer> set=new HashSet<>();
         
         for(int a: to_delete) set.add(a);
         
         TreeNode node=helper(root,set,list);

         if(node!=null) list.add(node);

         return list;
    }
}