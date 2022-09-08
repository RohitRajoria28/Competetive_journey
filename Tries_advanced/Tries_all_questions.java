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

