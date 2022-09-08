import java.io.*;
import java.util.*;

// public class oops {
//     public static void main(String[] args) {
//         try {
//             System.setIn(new FileInputStream("input.txt"));
//             System.setOut(new PrintStream(new FileOutputStream("output.txt")));
//         } catch (Exception e) {
//             System.err.println("Error");
//         }
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         System.out.println( 191919);
//     }
// }

public class oops {

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
        Scanner sc = new Scanner(System.in);
         String []a={"n","ni","nin","ninj","ninj","ninja"};
         // String ans=completeString(6,a);

         System.out.println("ans");

    }

  //   public class Node{
  //       Node link[]=new Node[26];
  //       boolean flag=false;

  //       boolean containsKey(char c){
  //           return link[c-'a']!=null;
  //       }

  //       void put(char c, Node node){
  //           link[c-'a']=node;
  //       }

  //       Node get(char c){
  //           return link[c-'a'];
  //       }
  //       void endStr(){
  //           flag=true;
  //       }

  //       boolean isEnd(){
  //           return flag;
  //       }

  //   }
  //    String longest="";
  //   Node root;
  //   public void insert(String s){
  //       Node  node=root;

  //       for(int i=0;i<s.length();i++){
  //           char c=s.charAt(i);
  //           if(!node.containsKey(c)){
  //               node.put(c,new Node());
  //           } 
  //           node=node.get(c);
  //       }

  //       node.endStr();
  //   }

  //   public boolean checkIfPrefixExist(String s){
  //       Node node=root;
  //       boolean flag=true;
  //       for(int i=0;i<s.length();i++){
  //           char c=s.charAt(i);
  //           if(node.containsKey(c)){
  //               node=node.get(c);
  //               if(flag & !node.isEnd()) return false; 
  //           }
  //       }

  //       return true;
  //   }
  //   public  void checkForLongest(String a[]){

  //       Node node=root;

  //       for(String s:a){
  //           insert(s);
  //       }

  //       for(String s:a){
  //           if(checkIfPrefixExist(s)){
  //               if(s.length()>longest.length()) longest=s;
  //               else if(s.length()==longest.length() && s.compareTo(longest)<0 ){
  //                   longest=s;
  //               }

  //           }
  //       }
  //   }



  // public  String completeString(int n, String[] a) {
     
  //    root=new Node();
  //    checkForLongest(a);

  //    return longest;

  // }
}
