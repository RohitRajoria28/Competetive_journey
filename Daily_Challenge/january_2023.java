// 2 janauary

class Solution {
	public int isCapitle(char c){
		return (c >='A' &&  c<='Z')?1:0;
	}

    public boolean detectCapitalUse(String word) {
        
        int n=word.length();
        
        
        if(n==1  ) return  isCapitle(word)==1?true:false;

        for(int i=0;i<word.length;i++){
        	int ft=isCapitle(word.charAt(i));

        	if(i==0)  {
        		val=(ft==0)?2:3;  
        	} 

        	if( i >0 && val==2 && ft==1){
        		return false;
        	} 
        }

         return true; 
    }
} 



// 3 january

class Solution {
    public int minDeletionSize(String[] strs) {
        int ans=0;
        
        for(int i=0;i<strs[0].length;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}

// jan 4

class Solution {
    public int minimumRounds(int[] arr) {
        if(arr.length<2) return -1;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i: arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans=0;

        for(int i: map.keySet()){
            int tasks=map.get(i);
            if(tasks<2) return -1;

            ans+=(Math.ceil((double)tasks/3.0));
        }

        return ans;
    }
}

// 5 january

class Solution {
    public int findMinArrowShots(int[][] arr) {
        if(arr.length<=1) return arr.length;

        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });

        int pst=arr[0][0];
        int pend=arr[0][1];
        List<Integer []> list=new ArrayList<>();
        list.add(new int[]{pst,pend});



        for(int ar[]:arr){
            int cst=ar[0];
            int cend=ar[1];

            
            if(pend>=cst ){
                list.remove(list.size()-1);
                pst=Math.max(pst,cst);
                pend=Math.min(pend,cend);
            }else{
                 pst= cst ;
                pend= cend ;
            }

           

            list.add(new int[]{pst,pend});

        }

        return list.size();
    }
} 


// 6 january 

class Solution {
    public int maxIceCream(int[] arr, int coins) {
        Arrays.sort(arr);
        int idx=0;
        while(coins>0){
            if(coins>arr[idx]){
                coins-=arr[idx++];
                ans++;
            }else{
                break;
            }
        }

        return idx;
    }
}

// 7 january 

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gtota=0;

        for(int i:gas){
            gtotal+=i;
        }
        int ctotal=0;
        for(int i:cost){
            cost+=ctotal;
        }
        if(gtotal<ctotal) return -1;

        for(int i=0;i<gas.length;i++){
            if(gas[i]-cost[i]>=0) return i;
        }

        return -1;
    }
}

// 8 january 

class Solution {
    public int maxPoints(int[][] points) {
        int max=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int total=2;

                for(int k=0;k<n;k++){
                    if(k!=i && k!=j){
                        if(arr[j][1]-arr[i][1]/arr[j][0]-arr[i][0]==arr[i][1]-arr[k][1]/arr[i][1]-arr[k][1]){
                            total++;
                        }
                    }
                }
                max=Math.max(max,total);
            }
        }


        return max;
    }
} 


class Solution {
    public int maxPoints(int[][] arr) {
        int max=0;
    int n=arr.length;
        if(n<2) return n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int total=2;

                for(int k=0;k<n;k++){
                    if(k!=i && k!=j){
                        if((arr[j][1]-arr[i][1])*(arr[i][1]-arr[k][1])==(arr[j][0]-arr[i][0])*(arr[i][1]-arr[k][1])){
                            total++;
                        }
                    }
                }
                max=Math.max(max,total);
            }
        }


        return max;
    }
} 

// 10 january 
class Solution {
    public boolean helper(TreeNode node1,TreeNode node2){
        if((node1==null &&  node2!=null) || (node1!=null &&  node2==null) ) return false;

        if(node1==null && node2==null) return true;
        
        if(node1.val!=node2.val) return false;

        return helper(node1.left,node2.left) && helper(node1.right,node2.right); 
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }
}


// 12 january 2023


class Solution {
    public class edge{
        int val;
        char c;

        edge(int val,char c){
            this.val=val;
            this.c=c;
        }
    }
    public int helper(List<edge>[] graph,int u,char ch){
        int ans=0;
        for(edge e:graph[u]){
            if(e.c==ch){
                ans++;
            }
            ans+=helper(graph,e.val,ch);
        }
        return ans;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int n;
        List<edge>[] graph=new ArrayList<>()[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new pair(0,labels.charAt(0)));
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            char c=labels.
            graph[u].add(new pair(v,c));
        }
        int ans[]=new int[n];
        Arrays.fill(ans,1);

        for(int i=0;i<n;i++){
            int c=labels.charAt(i);
            ans[i]+=helper(graph,i,c);
        }
        return ans;
    }
}
// 

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer,List<Integer>> g=new HashMap<>();

        for (int[] e : edges) {
            g.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
        }     

        HashSet<Integer> set=new HashSet<>();
        int ans[]=new int[n];

        dfs(g,0,ans,set,labels);
    }
    private int[] dfs(Map<Integer,List<Integer>> g,int node,int ans[],HashSet<Integer> set,String lab){
        int count[]=new int[26];
        if(set.add(node)){
            char c=lab.charAt(node);

            for (int child : g.getOrDefault(node, Collections.emptyList())) {
                int sub[]=dfs(g,child,ans,set,lab);
                for(int i=0;i<26;i++){
                    count[i]+=sub[i];
                }
            }
            count[c-'a']++;
            ans[node]+=count[c-a];
        }

        return count;
    }

}

// 13 january 
// 2246. Longest Path With Different Adjacent Characters
 class Solution {
    int longest=1;
    public int longestPath(int[] parent, String s) {
        Map<Integer,List<Integer>> g=new HashMap<>();
        int n=parent.length;
        for(int i=1;i<n;i++){
            g.putIfAbsent(parent[i],new ArrayList<>());
            g.get(parent[i]).add(i);
        }

        dfs(g,0,s);
        return longest;
    }
    public int dfs(Map<Integer,List<Integer>> g,int src,String s){
        int max=0;
        int smax=0;

        for(int nbr:g.get(src)){
            int ans=dfs(g,nbr,s);

            if(s.charAt(src)-'a'==s.charAt(nbr)-'a') continue;

            if(ans>max){
                smax=max;
                max=ans;
            }else if(ans>smax){
                sman=ans;
            }
        }

        longest=Math.max(longest,max+smax+1);
        return max+1;
    }
}

// leetcode 1061. Lexicographically Smallest Equivalent String

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character> set=new HashSet<>();

        HashMap<Integer,List<Character>> map=new HashMap<>();

        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);

            int count=0;

            if(set.contains(c1) || set.contains(c2)){

            }else{
                count++;
            
                map.put(count,new ArrayList<>());
            
                map.put(count,c1);
                map.put(count,c2);
            }

        }
    }
}

// 
class Solution {
    int[] root = new int[26];

    // recursively get the root element
    int get(int x) {
        return x == root[x] ? x : (root[x] = get(root[x]));
    }

    // unite two elements
    void unite(int x, int y) {
        // find the root of x
        x = get(x);
        // find the root of y
        y = get(y);
        // if their roots are not same, we combine them
        if (x != y) {
            // smaller first
            if (x < y)  root[y] = x;
            else root[x] = y;
        }
        return;
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        String ans = "";
        // init root. initialy each element is in its own group.
        for (int i = 0; i < 26; i++)  root[i] = i;
        // unite each character
        for (int i = 0; i < s1.length(); i++) unite(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        // build the final answer from the root element (smallest)
        for (int i = 0; i < baseStr.length(); i++) {
            ans += (char)(get(baseStr.charAt(i) - 'a') + 'a');
        }
        return ans;
    }
}

// 

class Solution {
    public int get(int []root,int x){
        if(root[x]==x) return x;

        return root[x]==x?x:get(root[x]);
    }
    public void unite(int root[],int x,int y){
        int x=get(root,x);
        int y=get(root,y);

        if(x!=y){
            if(y>x) root[y]=x;
            else root[x]=y;
        }

    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int root[]=new int[26];

        for(int i=0;i<26;i++) root[i]=i;

        for(int i=0;i<s1.length();i++){
            unite(root,s1.charAt(i)-'a',s2.charAt(i)-'a');
        }

        for(int i=0;i<baseStr.length();i++){
            char ss=baseStr.charAt(i);
            str.append((char)(get(root[ss-'a'])+'a'));
        }


        return set.toString();
    }
}

// 16 january 2023

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer[]> list=new ArrayList<>();
        for(int []a:intervals){
            list.add(a);
        }
        for(int a[]:  newInterval){
            list.add(a);
        }
        Collections.sort(list,(a,b)->{
            return a[0]-b[0];
        });

        int sarr[]=list.get(0);
        int sp=sarr[0];
        int ep=sarr[1];

        List<int[]> ans=new ArrayList<>();

        for(int i=1;i<list.size();i++){
            int ar[]=list.get(i);

            int sc=ar[0];
            int ec=ar[1];

            if(ep>sc){
                sc=Math.min(sp,sc);
                ec=Math.max(ep,ec);
                 
            }
            ans.add(new int[]{sc,ec});
            sp=sc;
            ep=ec;
        }
        int fans[][]=new int[ans.length()][2];
        for(int i=0;i<fans.length;i++){
            fans[i][0]=list.get(i)[0];
            fans[i][1]=list.get(i)[1];
        }
        return fans;
    }
}

// 

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        int i=0;
        // add intervals which ending is smaller than starting of new Interval
        while( i<intervals.length &&  intervals[i][1]<newInterval[0]){
            ans.add(new int[]{intervals[0],intervals[1]});
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[i][0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[i][1]);
            i++;
        }
        ans.add(newInterval);

        while(i<intervals.length ){
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

// 17january  

class Solution {
    public int minFlipsMonoIncr(String s) {
        int zero=0;
        int ones=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'==0) {
                zero=Math.min(zero+1,one);
            }else{
                one++;
            }
        }

         

        return zero;

    }
}

