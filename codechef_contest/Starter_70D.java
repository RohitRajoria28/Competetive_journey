import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;

public class code {
   
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }


        Scanner scn=new Scanner(System.in);

       int n=scn.nextInt();

       for(int i=0;i<n;i++){
       	int v1=scn.nextInt();
       	int v2=scn.nextInt();

       	 System.out.println(v2-v1);
       }


    }
   
}

 // q3
import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;

public class code {
    public static int findValue(int []fresh,int []cost,int x){
        int n=fresh.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(fresh[i]>=x){
                ans+=cost[i];
            }
        }

        return ans;
    }
   
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
 
        Scanner scn=new Scanner(System.in);

       int n=scn.nextInt();

       for(int i=0;i<n;i++){
             int num=scn.nextInt();
             int x=scn.nextInt();
             int fresh[]=new int[num];
              int cost[]=new int[num];

             for(int j=0;j<num;j++){
                fresh[j] =scn.nextInt();
             }
             for(int j=0;j<num;j++){
                cost[j] =scn.nextInt();
             }

             System.out.println(findValue(fresh,cost,x));
              
       }

    }
   
}


 
 // q4

import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;

public class code {
    public static String findValue(String s1,String s2){
         
        int ans1=0;
        int ans2=0;
        for(char c: s1.toCharArray()){
            if(c-'0'==1){
                ans1++;
            }
        }
        for(char c: s2.toCharArray()){
            if(c-'0'==1){
                ans2++;
            }
        }
        // System.out.print("ans1 : " + ans1+"," + "ans2 :  "+ ans2+" ,");
        return ans1==ans2?"YES":"NO";
    }
   
    public static void main(String[] args) {
         
 
        Scanner scn=new Scanner(System.in);

       int n=scn.nextInt();

       for(int i=0;i<n;i++){
             int len=scn.nextInt();
             String s1=scn.next();
             String s2=scn.next();
             
             System.out.print("len :"+len+" ,"  + "ans1 : " + s1+"," + "ans2 :  "+ s2+" ,");
              
              
             System.out.println(findValue(s1,s2));
              
       }

    }
   
}


 
 // q4
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int  findValue(String s1){
         
        int min=100000;
        int max=-1;
        char arr[]= s1.toCharArray();
        int idx=-1;
        for(int i=0;i<arr.length;i++){
             if(arr[i]-'0'==1 && idx==-1){
                idx=i;
             }else if(arr[i]-'0'==1){
                min=Math.min(i-idx,min);
                max=Math.max(i-idx,max);
                idx=i;
             }
        }
         
        max=max%3;
        return Math.min(max,min)==0?1:Math.min(max,min);
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scn=new Scanner(System.in);

       int n=scn.nextInt();

       for(int i=0;i<n;i++){
             int len=scn.nextInt();
             String s1=scn.next();
             
              
             System.out.println(findValue(s1));
              
       }
    }
}


// q6
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{   
    public static void findFreq(int arr[]){

    HashMap<Integer,Integer> fmap=new HashMap<>();
    
    for(int i : arr){
        fmap.put(i,fmap.getOrDefault(i,0)+1); 
    }

    for(int key : fmap.keySet()){
        int val=fmap.get(key);
        if(val%key!=0){
            System.out.println(-1);
            return ;
        }
    }
    HashMap<Integer,Integer> nmap=new HashMap<>();
    HashMap<Integer,Integer> cmap=new HashMap<>();
    int numVal=1;
    for(int i=0;i<arr.length;i++){
        int val=arr[i];

        if( !nmap.containsKey(val) || cmap.get(val)==0 ){
            nmap.put(val,numVal++);
            cmap.put(val,val);
        }
        
        System.out.print(nmap.get(val)+" ");

        cmap.put(val,cmap.getOrDefault(val,0)-1);
    }
    System.out.println();

   }
    public static void main (String[] args) throws java.lang.Exception
    {
         Scanner scn=new Scanner(System.in);

       int n=scn.nextInt();

       for(int i=0;i<n;i++){
            int len=scn.nextInt();

            
            int arr[]=new int[len];
            
            for(int l=0;l<len;l++){
               arr[l]=scn.nextInt();
               
            }
            findFreq(arr);
            
       }
    }
}
