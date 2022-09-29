// Leetcode 103 Zig zag level order traversal 

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<TreeNode> smallans=new ArrayList<>();
        
        smallans.add(root);
        int level=1;
        while(smallans.size()!=0){
            int size=smallans.size();
            List<Integer> list=new ArrayList<>();
            List<TreeNode> sal=new ArrayList<>();
            while(size--  && level%2==0){
               TreeNode node = smallans.get(smallans.size()-1);
               smallans.remove(smallans.size()-1);
               list.add(node.val);

               if(node.right!=null) sal.add(node.right);
               if(node.left!=null) sal.add(node.left);
            }    
            
             while(size--  && level%2!=0){
               TreeNode node = smallans.get(0);
               smallans.remove(0);
               list.add(node.val);

               
               if(node.left!=null) sal.add(node.left);
               if(node.right!=null) sal.add(node.right);
            }
            level+=1;
            ans.add(list);
            smallans=new ArrayList<>(sal);
        }

        return ans;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<TreeNode> list=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();

        list.add(root);

        int level=1;

        while(list.size()>0){
            int size=list.size();
            List<Integer> smallans=new ArrayList<>();
            while(size-->0){
                TreeNode rnode=list.removeFirst();
                smallans.add(rnode.val);

                if(rnode.left!=null) list.add(rnode.left);
                if(rnode.right!=null) list.add(rnode.right);
            }
            if(level%2!=0){
                Collections.reverse(smallans);
            }
            level++;
            ans.add(smallans);
        }

        return ans;
        
    }
}
// leetcode 107. Binary Tree Level Order Traversal II
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<>();

        LinkedList<TreeNode> list=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();

        list.add(root);;;

         

        while(list.size()>0){
            int size=list.size();
            List<Integer> smallans=new ArrayList<>();
            while(size-->0){
                TreeNode rnode=list.removeFirst();
                smallans.add(rnode.val);

                if(rnode.left!=null) list.addLast(rnode.left);
                if(rnode.right!=null) list.addLast(rnode.right);
            }
            
             
            ans.add(new ArrayList<>(smallans));
        }
       List<List<Integer>> ans2=new ArrayList<>();
        
        for(int i=ans.size()-1;i>=0;i--){
            ans2.add(new ArrayList<>(ans.get(i)));
        }
        return  ans2;
    }
}
// leetcode 515. Find Largest Value in Each Tree Row
class Solution {
    public List<Integer> largestValues(TreeNode root) {
         if(root==null) return new ArrayList<>();

        LinkedList<TreeNode> list=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();

        list.add(root);

         

        while(list.size()>0){
            int size=list.size();
           int max=Integer.MIN_VALUE;
            while(size-->0){
                TreeNode rnode=list.removeFirst();
                max=Math.max(rnode.val,max);

                if(rnode.left!=null) list.addLast(rnode.left);
                if(rnode.right!=null) list.addLast(rnode.right);
            }
            
             
            ans.add(max);
        }
        
        return  ans;
     
    }
} 
//leetcode  623. Add One Row to Tree

 class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) return root;
        if(depth==1) return new TreeNode(val,root,null);
    
        int level=1;
        LinkedList<TreeNode> list=new LinkedList<>();

        list.add(root);

        while(list.size()>0){
            int size=list.size();
            if(level==depth-1) break;
            while(size-->0){
                TreeNode rnode=list.removeFirst();

                if(rnode.left!=null) list.add(rnode.left);
                if(rnode.right!=null) list.add(rnode.right);
            }
            level++;
        }

        while(list.size()>0){
            TreeNode rnode=list.removeFirst();

            TreeNode left=rnode.left;
            TreeNode right=rnode.right;

            rnode.left=new TreeNode(val,left,null);
            rnode.right=new TreeNode(val,null,right);
        }

        return root;
    }
}


// 429. N-ary Tree Level Order Traversal

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        LinkedList<Node> list=new LinkedList<>();

        List<List<Integer>> ans=new ArrayList<>();

        list.add(root);

        while(list.size()!=0){
            int size=list.size();

            List<Integer> smallans=new ArrayList<>();

            while(size-->0){
                Node rnode=list.removeFirst();

                smallans.add(rnode.val);

                if(node.children!=null){
                    List<Node> child=node.children;

                    for(Node anode: child){
                        list.add(anode);
                    }
                }

            }
            ans.add(smallans);
        }

        return ans;
        
    }
}

// 559. Maximum Depth of N-ary Tree

class Solution {
    public int helper(Node node){
        if(node.children==null) return 1;

        int ans=0;
        for(Node child : node.children){
            ans=Math.max(ans,helper(child));
        }

        return ans+1;
    }

    public int maxDepth(Node root) {
        int h=helper(root);
    }
}

//leetcode  865. Smallest Subtree with all the Deepest Nodes

class Solution {
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }

        return Math.max(height(node.left),height(node.right))+1;
    }
    TreeNode roothead;

    public int helper(TreeNode node, int tlevel,int clevel){
        if(node==null) return clevel;
        
        int l=helper(node.left,tlevel,clevel+1);
        int r=helper(node.left,tlevel,clevel+1);

        if(l==tlevel && r==tlevel) roothead=node;

        return Math.max(r,l);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int h=height(root);
        int n=helper(root,h,0);
        return roothead;
    }
}


// leetcode 894. All Possible Full Binary Trees

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        TreeNode res=new ArrayList<>()
        if(n%2==0) return res;
        
        if(n==1) return new TreeNode(0);

        for(int i=1;i<=n;i+=2){
            List<TreeNode> l=allPossibleFBT(i);
            List<TreeNode> r=allPossibleFBT(n-i-1);

            for(TreeNode left :l ){
                for(TreeNode right : r){
                    TreeNode root=new TreeNode(0);

                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }

        }
        return res;
    }
}

// 988. Smallest String Starting From Leaf

class Solution {
    String smallest="zzzzzzzzzzzzzzzzzzzzzzz";

    pubic void helper(TreeNode node,String s){
        if(node==null) return ;

        s=(char)(node.val+'a')+s;
        if(node.left==null && node.right==null){
            if(s.compareTo(smallest)<0){
                smallest=s;
            }
        }

        helper(node.left,s);
        helper(node.right,s);
    }
    public String smallestFromLeaf(TreeNode root) {
        helper(root,"");
        return smallest;
    }
}



class Solution {
    public void helper(TreeNode node, StringBuilder str,PriorityQueue<String> pq ){
        if(node.left==null && node.right==null){
            str.append(node.val+'a');

            pq.add(str);
            return ;
        }

        str.append(node.val+'a');
        helper(node.left,str,pq);
        helper(node.right,str,pq);
        str.remove(0);
    }
    public String smallestFromLeaf(TreeNode root) {
       PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
        return a-b;
       });

       StringBuilder str=new StringBuilder();

       helper(root,str,pq);

       return pq.poll();
    }
}

// 

class Solution {
    int mdiff=-1;
   
    
    public void helper(TreeNode root,int minVal,int maxVal){
        if(root==null) return ;
        int val=root.val;
        if(minVal>val){
            minVal=val;
        }
        if(maxVal<val){
            maxVal=val;
        }

        mdiff=Math.max(mdiff,Math.max(Math.abs(val-minVal),Math.abs(maxVal-val)));

        helper(root.left,Math.min(minVal,root.val),Math.max(maxVal,root.val));
        helper(root.right,Math.min(minVal,root.val),Math.max(maxVal,root.val));

    }   
    public int maxAncestorDiff(TreeNode root) {
        helper(root,root.val,root.val);
        return mdiff;
    }
}
// Recover a Tree From PreOrder Traversal 
class Solution {
    pubic TreeNode helper(char arr,int si,int ei,int level){
        if(si>ei) return null;

        int val=0;
        StringBuilder str=new StringBuilder();
        while( arr[si]!='-'){
            str.append(arr[si]);
            si++;
        }

        val=It=Integer.pasreInt(str.toString());
        TreeNode root=new TreeNode(val);
        if(si==arr.length()) return root;
        int leftStart=si+level;
        int rightStart=leftStart+1;
        int dash=0;
        while(rightStart<arr.length){
            char c=arr[rightStart];

            if(c=='-'){
                dash++;
            }else {
                if(dash==level){
                    break;
                }
                dash=0;
            }
            rightStart++;
        }

        int leftEnd=(rightStart==ei)?ei: rightStart-level;




         root.left=helper(arr,leftStart,leftEnd,level+1);
         root.right=helper(arr,rightStart,ei,level+1);

         return root;
    }
    public TreeNode recoverFromPreorder(String a) {
        char arr[]=a.toCharArray();
        
        return helper(arr,0,a.length()-1,1);
    }
}


// 1161. Maximum Level Sum of a Binary Tree

class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;

        LinkedList<TreeNode> list=new LinkedList<>();

        list.add(root);

        int maxSum=Integer.MIN_VALUE;
        while(list.size()>0){
            int size=list.size();
            int sum=0;
            while(size-->0){
                TreeNode rnode=list.removeFirst();
                sum+=rnode;

                if(rnode.left!=null) list.add(rnode.left);
                if(rnode.right!=null) list.add(rnode.right);
            }
            maxSum=Math.max(maxSum,sum);
        }

        return maxSum;
    }
}

//leetcode  1315. Sum of Nodes with Even-Valued Grandparent

class Solution {
    int sum=0;
    
    public void helper(TreeNode node){
        if(node==null) return ;
        
        if(node.val%2==0){
           if(node.left!=null){
                if(node.left.left!=null){
                    sum+=node.left.left.val;
                 }
                if(node.left.right!=null){
                    sum+=node.left.right.val;    
                }
           }
            if(node.right!=null){
                if(node.right.right!=null){
                    sum+=node.right.right.val;
                 }
                if(node.right.left!=null){
                    sum+=node.right.left.val;
                }
                
            }
        }
        
        helper(node.left);
        helper(node.right);
    }
    public int sumEvenGrandparent(TreeNode root) {
        helper(root);
        
        return sum;
    }
}

// approach 2

class Solution {
    int sum=0;
    public void helper(TreeNode node,TreeNode parent,TreeNode gp){
        if(node==null) return ;

        if(gp!=null && gp.val%2==0){
            sum+=node.val;
        }

        helper(node.left,node,parent);
        helper(node.right,node,parent);
    }
    public int sumEvenGrandparent(TreeNode root) {
         
         helper(root,null,null);
         return sum;
    }
}

// 

class GfG {

    public class pair {
        int data=0;
        boolean flag=false;
        pair(){};
    }
    int ans=0;
    public pair helper(Node node,int a,int b ){
        if(node==null) return new pair();

        pair left=helper(node.left,a,b );
        pair right=helper(node.right,a,b );

        pair mpair=new pair();

        if(node.data==a || node.data==b){
            mpair.flag=true;
            mpair.data=1;
        }

        if(left.flag==true  && right.flag==true ){
            ans=left.data+right.data;
           
        }else if(left.flag==true  && mpair.flag==true){
             ans=left.data+mpair.data-1;
            //  System.out.print(ans+" ");
        }else if(mpair.flag==true  && right.flag==true ){
             ans=mpair.data+right.data-1;
            //  System.out.print(ans+" ");
        }else{
            if(left.flag){
                mpair.flag=true;
               mpair.data=left.data+1;
            }else if(right.flag){
                mpair.flag=true;
                mpair.data=right.data+1;
            }
        }

        // System.out.print(ans+" ");
        return mpair;
    }
    
    int findDist(Node root, int a, int b) {
       
       pair p=helper(root,a,b );

       return ans;
    }
}


// 1457. Pseudo-Palindromic Paths in a Binary Tree


class Solution {
    public boolean isPalindrome(int arr[]){
        boolean flag=true;

        for(int i =0;i<arr.length;i++){
            if(arr[i]%!=0){
                
                if(!flag) return false;
                flag=false;

            }
        }

        return true;
    }
    public int pseudoPalindromicPaths (TreeNode node) {
        if(node==null) return 0;

        arr[node.val]++;
        if(node.left ==null && node.right==null){
            boolean res=isPalindrome(arr);
            return res==true?1:0;
        }
        int count=0;
        count+=pseudoPalindromicPaths(node.left);
        count+=pseudoPalindromicPaths(node.right);


        arr[node.val]--;

        return count;
        
    }
}

// odd even Tree leetcode


class Solution {
    public boolean isEvenOddTree(TreeNode root) {

        LinkedList<TreeNode> list=new LinkedList<>();

        list.add(root);

        int level=0;
        
        while(list.size()!=0){
            int size=list.size();
            int eval=0;
            int oval=(int)1e9;

            while(size-->0){
                TreeNode rnode =list.remove();

                if(level%2==0){
                    if(rnode.val%2==0) return false;

                    if(eval>rnode.val){
                        return false;
                    }
                    mval=rnode.val;
                }else{
                    if(rnode.val%2!=0) return false;

                    if(oval<rnode.val){
                        return false;
                    }
                    oval=rnode.val;
                }


                if(rnode.left!=null) list.add(rnode.left);
                if(rnode.right!=null) list.add(rnode.right);
            }


        }

        return true;
        
    }
}

//leetcode  652. Find Duplicate Subtrees

class Solution {
    public void helper(TreeNode node,HashSet<TreeNode> set,List<TreeNode> list){
        if(node==null) return ;

        helper(node.left,set,list);
        helper(node.right,set,list);

        set.add(node);

        if(set.contains(node)){
            list.add(node);
        }else{
            set.add(node);
        }


        return node;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashSet<TreeNode> set=new HashSet<>();
        List<TreeNode> list=new ArrayList<>();

        helper(root,set,list);


        return list;
    }
}

// 513. Find Bottom Left Tree Value

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        
        
    }
}