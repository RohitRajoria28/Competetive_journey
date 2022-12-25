import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;

public class code {
    public static int  findValue(String s1){
         
         
        int min=100000;
        int max=-1;
        char arr[]= s1.toCharArray();
        boolean even=false;
        boolean odd=false;
        
        for(int i=0;i<arr.length;i++){
              if(arr[i]-'0'==1){
                if( i%2==0){
                    even=true;
                }else {
                    odd=true;
                }
              }

              if(even && odd) return 1;
        }

         
        
        return 2;
    }
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
            int len=scn.nextInt();

            
            int arr[]=new int[len];
            
            for(int l=0;l<len;l++){
               arr[l]=scn.nextInt();
               
            }
            findFreq(arr);
            
       }

    }
   
}

 
