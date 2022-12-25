import java.io.*;
import java.util.*;
import java.util.Iterator;

public class oops {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }

    }




    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int a=scn.nextInt();
        int b=scn.nextInt();
        int arr1[]=new int[a];
        int arr2[]=new int[b];
         
        for(int i=0;i<a;i++){
             arr1[i]=scn.nextInt();
        }

        for(int i=0;i<b;i++){
             arr2[i]=scn.nextInt();
        }

         

        System.out.println(helper(arr1,arr2));
    }
    public static helper(int arr1[],int arr2[]){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n1=arr1.length;
        int n2=arr2.length;

        int sum=0;
        int i=arr1.length-1;
        int j=arr2.length-1;

        int idx=Math.min(n1,n2);
        int max=Math.max(n1,n2);

        while(idx-->0){
            sum+=arr[i]+arr[j];
            i--;
            j--;
        }

        if(j>=0){
         sum+=arr2[j];
        }
        

        return sum;

    }



    public static  int helper(List<Integer> list){
        int ans=0;

        for(int i=0;i<list.size();i++){
            int num=list.get(i);

            boolean flag=false;


            for(int n=1;n<=num/2;n++){

                if(n*(n+1)==num){
                    ans++;
                    break;
                }
            }
        }


        return ans;
    }


    public static String generateSubstring(String str){

         

        int arr[]=new int[26];

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);

            arr[c-'a']++;
        }


        for(int i=0;i<26;i++){
            if(arr[i]%2!=0) return "Not Possible";
        }

        StringBuilder s=new StringBuilder();

        for(int i=0;i<26;i++){
            if(arr[i]>0){
                int l=arr[i]/2;
                while(l-->0){
                    s.append((char)('a'+i));
                }
            }
        }

        return s.toString();

    }
 
}

 

 import java.util.*;
import java.lang.*;
import java.io.*;

 
public class Main
{
public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();
 
        for(int i=0;i<n;i++){
            int num=scn.nextInt();
            int arr[]=new int[num];

            for(int j=0;j<num;j++){
                 arr[j]=scn.nextInt();
            }
            long ftower=arr[0];
            for(int j=1;j<num;j++){
                if(arr[j]<=ftower) continue;
                  ftower=findMaxtower(ftower,arr[j]);    
                    
            }

            System.out.println(ftower);
            
        }
    }

    public static long findMaxtower(int ftower,int adtower){
        
        
         
        long ans=((adtower-ftower)/2)+1;


        return   ftower+ans;
    }
}