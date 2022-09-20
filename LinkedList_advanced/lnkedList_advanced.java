
// leedcode 2181
class Solution {
    public ListNode mergeNodes(ListNode head) {
        
        ListNode dummy=new ListNode();
        ListNode prev=dummy;
         
        ListNode curr=head;

        while(curr!=null){
            if(curr.val!=0){
                sum+=curr.val;
                curr=curr.next;
            }else{
                prev.val=sum;
                prev.next=curr;
                prev=prev.next;
                sum=0;
                curr=curr.next;
            }

        }

        return head;
    }
}
//leetcode  2130. Maximum Twin Sum of a Linked List
class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode frd=curr.next;

            curr.next=prev;
            prev=curr;
            curr=frd;
        }

        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode rnode=reverse(head);
        ListNode node=head;
        int max=0;
        while(node!null){
            max=Math.max(node.val+rnode.val,max);
            node=node.next;
            rnode=rnode.next;
        }

        return max;
    }
}

// leetcode 1669 Merge Between 2 LinkedList  
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i=a-1;
        int j=b+1;
        
        ListNode tail=list2;
        
        while(tail.next!=null) tail=tail.next;
        
        int len=0;
        
        ListNode prev=null;
        ListNode nxt=null;
        
        ListNode curr=list1;
        
        while(curr!=null){
            
            if(len==i){
                prev=curr;
            }else if(len==j){
                nxt=curr;
            }
            curr=curr.next;
            len++;
        }
        
        prev.next=list2;
        tail.next=nxt;
        
        return list1;
    }
}

// leetcode 1091 next greater element  


class Solution {
    public class pair{
        int idx;
        int val;
        pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        };
    }
    public int[] nextLargerNodes(ListNode head) {
        if(head==null) return new int[]{};
        
        int len=0;
        ListNode curr=head;
        
        while(curr!=null){
             len++;
             curr=curr.next;
        }

        int arr[]=new int[len];
        int i=0;
        Stack<pair> st=new Stack<>();
        curr=head;

        while(curr!=null){

            int val=curr.val;

            while(!st.empty() && st.peek().val<val){
                arr[st.pop().idx]=val;
            }
            st.push(new pair(i,val));
            curr=curr.next;
            i++;
        }
        
        return arr;
        
    }
}

// leetcode 382 LinkedList Random Node 

class Solution {
    Random rand;
    ListNode nhead;
    int len;
    public Solution(ListNode head) {
        rand=new Random();
        nhead=head;
        ListNode node=head;
        
         len=0;
        while(node!=null){
            node=node.next;
            len++;
        }
    }
    
    public int getRandom() {
        int ridx=rand.nextInt(len);
        
        ListNode node=nhead;
        int i=0;
         int ans=node.val;
        while(node!=null && i<=len){
            if(i==ridx){
               ans=node.val;
                break;
            } 
            node=node.next;
            i++;
        }
        return ans;
        
    }
}

// Leetcode 817 LinkedList Component

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set=new HashSet<>();

        for(int i:nums) set.add(i);
        
        ListNode curr=head;
        int maxlen=0;
        int ans=0;
        while(curr!=null){
            if(set.contains(curr.val)){
                maxlen++;
            }else{
                maxlen=0;
            }
            ans=Math.max(ans,maxlen);
        }

        return ans;
    }
}

// leetcode 117 Pointn=ing next pointer 
class Solution {
    public Node connect(Node root) {
        
        Node leftMost=root;
        while(leftMost!=null){
            Node parent=leftMost, dummy=new Node(0), tail=dummy;

            while(parent!=null){
                if(parent.left!=null){
                    tail.next=parent.left;
                    tail=tail.next;
                }
                if(parent.right!=null){

                    tail.next=parent.right;
                    tail=tail.next;
                }
                parent=parent.next;
            }
            leftMost=dummy.next;
        }
        return root;
    }
}

// leetcode 1367. Linked List in Binary Tree

class Solution {
    public boolean path(listNode curr,TreeNode node){
        if(node==null || curr==null) return false;

        if(curr.next==null && curr.val==node.val) return true;
        
        if(curr.val!=node.val) return false;

        boolean left=path(curr.next,node.left);
        boolean right=path(curr.next,node.right);

        return left || right ;
    }
    public boolean helper(TreeNode node,ListNode head){
        if(node==null) return false;

        if(node.val==head.val){
            return path(node,head);
        }


        boolean ans=false;

        ans = ans || helper(node.left,head) || helper(node.right,head) ;

        return ans;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean ans = helper(root,head.val);

        return ans;
 
    }
}