//leetcode 208 implement Tries -> leetcode 

class Trie {
   public  class Node{
       Node list[]=new Node[26];
       boolean flag=false;
       
       public boolean containsKey(char c){
       	  return (list[c-'a']!=null);
       }

       // constructor
       Node(){

       }
       public void put(char c, Node node){
       	 list[c-'a']=node;
       }

       public Node get(char c){
       	return list[c-'a'] ;
       }

       public void endSet(){
        	flag=true;
       }
       public boolean isEnd(){
       	return flag;
       }

   }

    private static Node root;

    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
       Node node=root;

       for(int i=0;i<word.length();i++){
       	char c=s.charAt(i);
       	 if(!node.containsKey(c)){
       	 	node.put(c,new Node());
       	 }
       	 node=node.get(c);
       } 


       node.endSet();
    }
    
    public boolean search(String word) {
    	Node node=root;

    	for(int i=0;i<word.length();i++){
    		char c=word.charAt(i);
    		if(!node.containsKey(c)) return false;
    		else{
    			node=node.get(c);
    		}
    	}

    	return node.isEnd();
        
        
    }
    
    public boolean startsWith(String prefix) {
    	Node node=root;

    	for(int i=0;i<word.length();i++){
    		char c=word.charAt(i);
    		if(!node.containsKey(c)) return false;
    		else{
    			node=node.get(c);
    		}
    	}


    	return true;
        
    }
}

// implement Tries -2 ___ coding Ninjas 

public class Trie {

    public class Node{
        Node list[]=new Node[26];
        int ew=0;
        int cp=0;

        Node(){

        }

        boolean containsKey(char c){
            return (list[c-'a']!=null);
        }

        void put(char c, Node node){
            list[c-'a']=node;
        }

        public Node get(char c){
            return list[c-'a'];
        }

        void incEw(){
            ew++;
        }
        void incCp(){
            cp++;
        }
        void decCp(){
            cp--;
        }
        void decEw(){
            ew--;
        }
        int getEw(){
            return ew;
        }
        int getCp(){
            return cp;
        }


    }

    private static Node root;
    public Trie() {
         root=new Node();
    }

    public void insert(String w ) {
         Node node=root;

         for(int i=0;i<w.length();i++){
             char c=w.charAt(i);
             if(!node.containsKey(c)){
                  node.put(c,new Node());
             }
             node=node.get(c);
             node.incCp();
         }

         node.incEw();
    }

    public int countWordsEqualTo(String w) {
         Node node=root;

         for(int i=0;i<w.length();i++){
             char c=w.charAt(i);
             if(!node.containsKey(c)){
                  return 0;
             }else{
                 node=node.get(c);
             }
              
         }

         return node.getEw();
    }

    public int countWordsStartingWith(String w) {
         Node node=root;

         for(int i=0;i<w.length();i++){
             char c=w.charAt(i);
             if(!node.containsKey(c)){
                  return 0;
             }else{
                 node=node.get(c);
             }
              
         }

         return node.getCp();
    }

    public void erase(String w) {
         Node node=root;

         for(int i=0;i<w.length();i++){
             char c=w.charAt(i);
             if(!node.containsKey(c)){
                  return ;
             }else{
                 node=node.get(c);
                 node.decCp();
             }
              
         }

           node.decEw();
    }

}


// longest word with all the prefixes -> coding Ninjas 
// https://www.codingninjas.com/codestudio/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
class Solution {
    public Node{
        Node link[]=new Node[26];
        boolean flag=false;

        boolean ContainsKey(char c){
            return link[c-'a']!=null;
        }

        void put(char c, Node node){
            link[c-'a']=node;
        }

        Node get(char c){
            return link[c-'a'];
        }
        void endStr(){
            flag=true;
        }

        boolean isEnd(){
            return flag;
        }

    }
    Strinf longest="";
    Node root;
    public void insert(String s){
        Node  node=root;

        for(int i=0i<s.length();i++){
            char c=s.charAt(i);
            if(!node.containsKey(c)){
                node.put(c,new Node());
            } 
            node=node.get(c);
        }

        node.endStr();
    }

    public boolean checkIfPrefixExist(Strin s){
        Node node=root;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(node.containsKey(c)){
                node=node.get(c);
                if(flag & !node.isEnd()) return false; 
            }
        }

        return true;
    }
    public void checkForLongest(String a[]){

        Node node=root;

        for(String s:a){
            insert(s);
        }

        for(String s:a){
            if(checkIfPrefixExist(s)){
                if(s.length()>longest.length()) longest=s;
                else if(s.length()==longest.length() && s<longest){
                    longest=s;
                }

            }
        }
    }



  public static String completeString(int n, String[] a) {
     
     root=new Node();
     checkForLongest(a);

     return longest;

  }
}


// Count of distinct substrings

class GfG
{
    public static class Node{
        Node link[]=new Node[26];

        boolean containsKey(char c){
            return (link[c-'a'])!=null;
        }

        public Node get(char c){
            return link[c-'a'];
        }

        public void put(char c,Node node){
            link[c-'a']=node;
        } 
    } 

    
   public static int countDistinctSubstring(String st)
   {
        Node root=new Node();
        int count =0;
        for(int j=0;j<st.length();j++){
            Node node=root;
            for(int i=j;i<st.length();i++){
            char c=st.charAt(i);

            if(!node.containsKey(c)){
                 node.put(c,new Node());
                 count++;
            }
            node=node.get(c);
          }
        }
        
        return count+1;
      
   }
} 

// leetcode  421. Maximum XOR of Two Numbers in an Array

class Solution {
    public class Node{
        Node []arr=new Node[2];

        Node get(int i){
            return arr[i];
        }

        boolean containsKey(int i){
            return arr[i]!=null;
        }

        void put(int i,Node node){
            arr[i]=node;
        }


    }

    public class Trie{

        public static Node root;

        Trie(){
            root=new Node();
        }

        void insert(int num){
            Node node=root;
            for(int i=31;i>=0;i--){
                int bit=num | (1<<i);

                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node=node.get(bit);
            }
        }

        public int getMax(int num){
            Node node=root;

            int max=0;

            for(int i=31;i>=0;i--){
                int bit=(num>>i) & 1;
                if(node.containsKey(1-bit)){
                    max=max | (1<<i) ;
                    node=node.get(1-bit);
                }else{
                    node=node.get(bit);
                }
            }


            retur max;
        }
    }
 
    public int findMaximumXOR(int[] nums) {
          Trie trie=new Trie();

          for(int i : nums){
            trie.insert(i);
          }     

          int max=0;
          for(int i: nums){
             max=Math.max(max,trie.getMax(i));
          }

          retur max;
    }
}

// leetcode 1707. Maximum XOR With an Element From Array

class Solution {
    public class Node{
        Node link[]=new Node[2];

        boolean containsKey(int bit){
            return link[bit]!=null;
        }

        void put(int bit,Node node){
            link[bit]=node;
        }

        public Node get(int bit){
            return link[bit];
        }


    }

    public class Tries{
        
        Node root;
        Tries(){
            root=new Node();
        }

        void insert(int num){
            Node node=root;

            for(int i=31;i>=0;i--){
                int bit=(num>>i) & 1;
                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node=node.get(bit);
            }

        }

        public int getMax(int num){
            Node node=root;
            int max=0;
            for(int i=31;i>=0;i--){
                int bit=num>>i & 1;

                if(node.containsKey(1-bit)){
                    max=(num>>i | 1);
                    node=node.get(bit-1);
                }else{
                    node=node.get(bit);
                }
            }

            return max;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int max=0;

        Tries trie=new Trie();

        int ans[]=new int[queries.length];

        for(int i : nums){
            trie.insert(i);
        }

        for(int i=0;i<queries.length;i++){
            int a[]=queries[i];

            int x=a[0];
            int maxVal=a[1];

            
        }
    }
}

// maximum Xor queries of XOR 

class Solution {
    public class Node{
        Node []arr=new Node[2];
        
        Node(){
            
        }

        public Node get(int i){
            return arr[i];
        }

        boolean containsKey(int i){
            return arr[i]!=null;
        }

        void put(int i,Node node){
            arr[i]=node;
        }


    }

    public class Trie{

        public static Node root;

        Trie(){
            root=new Node();
        }

        void insert(int num){
            Node node=root;
            for(int i=31;i>=0;i--){
                int bit=num>>i & 1;

                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node=node.get(bit);
            }
        }

        public int getMax(int num){
            Node node=root;

            int max=0;

            for(int i=31;i>=0;i--){
                int bit=(num>>i) & 1;
                if(node.containsKey(1-bit)){
                    max=max | (1<<i) ;
                    node=node.get(1-bit);
                }else{
                    node=node.get(bit);
                }
            }


            return max;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> qlist=new ArrayList<>();

        for(int i =0;i<queries.length;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);

            qlist.add(temp);
        }

        Collections.sort(qlist,(a,b)->{
            return a.get(0)-b.get(0);
        })


        int m=queries.length;
        int n=nums.length;

        int idx=0;

        Trie trie=new Trie();
        int ans[]=new int[m];
        for(int i=0;i<m;i++){
            int maxVal=qlist.get(i).get(0);
            int qidx=qlist.get(i).get(2);
            int  x=qlist.get(i).get(1);

            while(idx<n && nums[idx]<=maxVal){
                trie.insert(nums[idx]);
                idx++;
            }
            if(idx!=0) ans[qidx]=trie.getMax(x);
            else ans[qidx]=-1;
        }
        return ans;
    }
}


 // 211. Design Add and Search Words Data Structure

class WordDictionary {

    public class Node{
        Node []link=new Node[26];
        boolean flag=true;

        booleean containsKey(char c){
            return link[c-'a']!=null;
        }

        void put(char c,Node node){
            link[c-'a']=node;
        }

        public Node get(char c){
            return link[c-'a'];
        }

        public boolean isEnd(char c){
            return flag;
        }

        public void endNode(){
            flag=true;
        }
    }
    
     Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;

        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);

            if(!node.containsKey(c)){
                node.put(c,new Node());
            }
            node=node.get(c);
        }

        node.endNode();
    }
    
    public boolean search(String word) {
        Node node=root;
         Node node=root;

        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);

            if(!node.containsKey(c)){
                 return false;
            }else{
                node=node.get(c);                
            }
        }


        return node.isEnd();
    }
}

// leetcode 221
class Solution {
    public class Node{
        Node []link=new Node[26];
        String word;
        boolean flag=false;

        void put(char c,Node node){
            link[c-'a']=node;
        }

        Node get(char c){
            return link[c-'a'];
        }
        void endWord(){
            flag=true;
        }
        public boolean containsKey(char c){
            return link[c-'a']!=null;
        }
    }
    Node root;

    public void insert(String s){
        int n=s.length();
        Node node=root;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(!node.containsKey(c)){
                node.put(c,new Node());
            }
            node=node.get(c);
        }

        node.endWord();
        node.word=s;
    }
    public void dfs(int cr,int cc,int er,int ec,int [][]dir, char[][] arr,List<String> ans,Node node){

        
         if(node.flag ){
            ans.add(node.word);
            node.flag=false;
            return ;
        }
       
        
       

        char c=arr[cr][cc];
        arr[cr][cc]='$';

        for(int d=0;d<4;d++){
            int rr=cr+dir[d][0];
            int ccc=cc+dir[d][1];

            if(rr>=0 && ccc>=0 && rr<er && ccc<ec && arr[rr][ccc]!='$' &&  node.containsKey(c)){
                // node=node.get(arr[rr][ccc]);
                dfs(rr,ccc,er,ec, dir,arr, ans,node.get(c));
            }
        }
        arr[cr][cc]=c;
        
        

    }
    public List<String> findWords(char[][] board, String[] words) {
        root=new Node();    


        for(String s: words){
            insert(s);
        }
        List<String> ans=new ArrayList<>();
        int r=board.length;
        int c=board[0].length;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dfs(i,j,r,c,dir,board,ans,root.get(board[i][j]));
            }
        }
     
        return ans;
    }
}

// leetcode Replace Words

class Solution {
    public class Node{
        Node[] link=new Node[26];
        boolean flag=false;

        String word;
        boolean flag=false;

        void put(char c,Node node){
            link[c-'a']=node;
        }

        Node get(char c){
            return link[c-'a'];
        }
        void endWord(){
            flag=true;
        }
        public boolean containsKey(char c){
            return link[c-'a']!=null;
        }

    }
    Node root;
    public void insert(String s){
        int n=s.length();
        Node node=root;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(!node.containsKey(c)){
                node.put(c,new Node());
            }
            node=node.get(c);
        }

        node.endWord();
        node.word=s;
    }
    public String search(String s){
        Node node=root;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(node.flag){
                return node.word;
            }

            if(!node.containsKey(c)){
                return s;
            }else{
                node=node.get(c);
            }
        }

        if(node.flag) return node.word;
        return s;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root=new Node();
        for(String s: dictionary){
            insert(s);
        }

        String []arr=sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            String sw=search(arr[i]);
            arr[i]=sw;
        }

        return arr.toString();
    }
}

// leetcode 677 Map Sum Count

class MapSum {
    public class Node{
        Node[] link=new Node[26];
        int count=0;
        boolean flag=false;
        int endCount=0;

        boolean containsKey(char c){
            return link[c-'a']!=null;
        }
        void put(char c,Node node){
            link[c-'a']=node;
        }

        Node get(char c){
            return link[c-'a'];
        }
        Integer getCount( ){
            return count;
        }
        

        boolean isEnd(){
            return  flag;
        }
        Integer EndCount(){
            return count;
        }
        void endString(){
            flag=true;
        }

    }
    public int[] containsString(String key){
        int arr[]=new int[2];
//         arr[0]=true / false ;
//         arr[1]=countValue;
        
        Node node=root;
         
        for(int i =0;i<key.length();i++){
            char c=key.charAt(i);

            if(!node.containsKey(c)){
               return  arr;
            }else{
                node=node.get(c);
            } 
        }
        arr[0]=(node.isEnd()?1:0);
        arr[1]=(node.isEnd()?node.endCount:0);
        return  arr;
    }
Node root;
    public MapSum() {
        root=new Node();
    }
    
    public void insert(String key, int val) {
        Node node=root;
        
       int arr[]= containsString(key);
        int prevVal=0;
        if(arr[0]!=0) prevVal=arr[1];
        

        for(int i =0;i<key.length();i++){
            char c=key.charAt(i);

            if(!node.containsKey(c)){
                node.put(c,new Node());
            }
             
            node=node.get(c);
            node.count-=prevVal;
            node.count+=val;
            System.out.print(prevVal+" ");
        }
        System.out.println();
        
        node.endString();
        node.endCount=val;
    }
    
    public int sum(String prefix) {
        
        
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(node.containsKey(c)){
                node=node.get(c);
            }else{
                return 0;
            }
        }

        return node.getCount();
    }
}
 

 // leetcode 720. Longest Word in Dictionary


class Solution {
    public class Node{
        Node[] link=new Node[26];
         
        boolean flag=false;
        String str;
        

        boolean containsKey(char c){
            return link[c-'a']!=null;
        }
        void put(char c,Node node){
            link[c-'a']=node;
        }

        Node get(char c){
            return link[c-'a'];
        }
         
        

        boolean isEnd(){
            return  flag;
        }
         
        void endString(){
            flag=true;
        }

    }
Node root;
    public void insert(String key, int val) {
        Node node=root;
        
        for(int i =0;i<key.length();i++){
            char c=key.charAt(i);

            if(!node.containsKey(c)){
                node.put(c,new Node());
            }
             
            node=node.get(c);
        }
        
        node.endString();
        node.str=key;
        
    }
    public boolean search(String s){
        Node node=root;
        for(int i=key.length()-2;i>=0;i--){
            
            char c=key.charAt(i);

            if(isEnding())
             
            node=node.get(c);
        }

    }
    String ans="";
    public void dfs(){
        for(Node child: root){
            if(child!=null && child.str!=null){
                if(child.str.length()>ans.length()){
                    ans=child.str;
                }
                dfs(child);
            }
        }
    }
    public String longestWord(String[] words) {
        Node node=root;

        for(String s: words){
            insert(s);
        }

        dfs();

        return ans;
    }
}

//  leetcode 1032 Stream of character 


class StreamChecker {
    public class Node{
        Node[] link=new Node[26];
         
        boolean flag=false;
        
        

        boolean containsKey(char c){
            return link[c-'a']!=null;
        }
        void put(char c,Node node){
            link[c-'a']=node;
        }

        Node get(char c){
            return link[c-'a'];
        }

        boolean isEnd(){
            return  flag;
        }
        void endWord(){
            flag=true;
        }
    }
    
    
  

    public void insert(String s){
        Node node=root;

        for(int i =s.length()-1;i>=0;i--){
            char c=s.charAt(i);

            if(!node.containsKey(c)){
                node.put(c,new Node());
            }
            node=node.get(c);
        }

        node.endWord();
    }
    Node root;
    StringBuilder str;
    public StreamChecker(String[] words) {
        root=new Node();
        str=new StringBuilder();
        
        for(String s:words){
            insert(s);
        }
    }
      
    public boolean query(char letter) {
        str.append(letter);

        boolean flag=false;
        Node node=root;

        for(int i=str.length()-1;i>=0;i--){
            char c=str.charAt(i);

            if(!node.containsKey(c)) return false;
            node=node.get(c);
            if(node.isEnd()) return true;
        }
        return false;

    }
}



// INORDER WITHOUT RECURSION

