
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


// find cycle node
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head==null || head.next==null) return head;

        ListNode slow=head;
        ListNode fast=head;

        while(slow!=fast){
            fast=fast.next.next;
            slow=slow.next;
        }

        if(slow==fast) slow=head;
        boolean isloop=false;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
            isloop=true;
        }
        if(!isloop){
            fast=fast.next;
            while(fast.next!=null && fast!=slow){
                fast=fast.next;
            }
        }
        if(fast.next==null) return null;
        return slow;
        
    }
}

// /
 */
class Solution {
    public int length(ListNode head){
        ListNode node=head;
        int count=0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
    ListNode th=null;
    ListNode tt=null;
    public void addFirst(ListNode node){
        if(th==null && tt==null){
            th=node;
            tt=node;
        }else{
            node.next=th;
            th=node;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null ) return null;
        int l=length(head);
        int len=l;
        ListNode curr=head;
        ListNode ph=null;
        ListNode pt=null;
        while(len>=k && curr!=null){
            int temp=0;
            while(temp<=k && len>=k && curr!=null){
                addfirst(curr);
                curr=curr.next;
                temp++; 
            }
            if(ph==null ){
                ph=th;
                pt=tt;
            }else{
                pt.next=th;
                pt=tt;
            }
            len-=k;
            tt=null;
            th=null;
        }
        if(curr!=null){
            pt.next=curr;
        }

        return ph;
    }
}

//2074. Reverse Nodes in Even Length Groups

class Solution {
    public int length(ListNode node){
        int len=0;

        ListNode curr=node;

        while(curr!=null){
            len++;
            curr=curr.next;
        }
        return len;
    }
    public void addFirst(ListNode node){
        if(th==null && tt==null){
            th=node;
            tt=node;
        }else {
            node.next=th;
            th=node;
        }
    }
    ListNode th;
    ListNode tt;
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len=length(head);

        int k=1;
        ListNode ph=null;
        ListNode pt=null;


        while(curr!=null){
            if(k%2==0  || (k>len && len%2==0)){

                if(k>len && len%2==0){
                    k=len;
                }

                int temp=k;
                while(k-->0 && curr!=null){
                    ListNode frd=curr.next;
                    curr.next=null;
                    addFirst(curr);
                    curr=frd;
                }

                if(ph==null){
                    ph=th;
                    pt=tt;
                }else{
                    pt.next=th;
                    pt=tt;
                }

            }else{
                ListNode frd=curr.next;
                if(ph==null){
                    ph=curr;
                    while(k-->0 && curr.next!=null){
                        curr=curr.next;
                    }

                    pt=curr;
                }else{
                   pt.next=curr;
                    while(k-->0 && curr.next!=null){
                        curr=curr.next;
                    }
                     pt=curr;
                }
            }
            len-=k;
            k++;
        }

        return ph;
    }
}


public  static int helper(int arr[])
{
     
    int prev[][] = new int[n][2];
 
     
    for (int i = 0; i < n; i++)
        prev[i][0] = prev[i][1] = 1;
  
    int ans = 1; 
    
   
    for (int i = 1; i < n; i++)
    {  

        boolean flag=false;
        
        for (int j = 0; j < i; j++)
        {
             
            if (arr[j] < arr[i] &&
                prev[i][0] < prev[j][1] + 1)
                prev[i][0] = prev[j][1] + 1;
 
             
            if( arr[j] > arr[i] &&
              prev[i][1] < prev[j][0] + 1)
                prev[i][1] = prev[j][0] + 1;
        }


        if(flag){
            while(!flag){
                prev[i][0] = prev[j][1] + 1;
                prev[i][1] = prev[j][0] + 1;

            }
        }

 
        
        if (ans < Math.max(prev[i][0], prev[i][1]))
            ans = Math.max(prev[i][0], prev[i][1]);
    }
 
    return ans+arr.length;
}

0 1 2 3 5 8

public class fib(int n){
    if(n==1) return 0;


    int ans=1+n;

    retuan ans;
}