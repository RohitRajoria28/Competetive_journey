import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;

public class code {

       
        public static void main(String[] args) throws NumberFormatException, IOException {
            try {
                System.setIn(new FileInputStream("input.txt"));
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            } catch (Exception e) {
                System.err.println("Error");
            }
     
            Scanner scn=new Scanner(System.in);
            
            int n=scn.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
            }
             
            System.out.println(ArrayChallenge(arr));
            
        } 
        // public static boolean ArrayChallenge(String []arr){
          
        //     Collections.sort(arr,(a,b)->{
        //         if(a.substring(5,7)=="AM" && b.substring(5,7)=="AM"){

        //             if(Integer.parseInt(a.substring(0,2)) > Integer.parseInt(b.substring(0,2))){
        //                 return 1;
        //             }else if(Integer.parseInt(a.substring(0,2)) < Integer.parseInt(b.substring(0,2))){
        //                 return -1;
        //             }else{
        //                 if(Integer.parseInt(a.substring(3,5)) > Integer.parseInt(b.substring(3,5))){
        //                     return 1;
        //                 }else if(Integer.parseInt(a.substring(3,5)) < Integer.parseInt(b.substring(3,5))){
        //                     return -1;
        //                 }else{
        //                     return 1;
        //                 }
        //             }

        //         }else if(a.substring(5,7)=="PM" && b.substring(5,7)=="PM"){

        //                 if(Integer.parseInt(a.substring(0,2)) > Integer.parseInt(b.substring(0,2))){
        //                     return 1;
        //                 }else if(Integer.parseInt(a.substring(0,2)) < Integer.parseInt(b.substring(0,2))){
        //                     return -1;
        //                 }else{
        //                     if(Integer.parseInt(a.substring(3,5)) > Integer.parseInt(b.substring(3,5))){
        //                         return 1;
        //                     }else if(Integer.parseInt(a.substring(3,5)) < Integer.parseInt(b.substring(3,5))){
        //                         return -1;
        //                     }else{
        //                         return 1;
        //                     }
        //                 }

        //         }else if(a.substring(5,7)=="AM" && b.substring(5,7)!="PM"){
        //             return 1;
        //         }else {
        //             return -1;
        //         }
        //     })

        //     int n=arr.length();
        //     int max=-1;
        //     for(int i=0;i<n-1;i++){
        //         String s1=arr[i];
        //         String s2=arr[i+1];
        //         int ans=0;
        //         if(s1.substring(5,7).equalsTo(s2.substring(5,7))){
        //             ans+=Math.abs((Integer.parseInt(a.substring(0,2)) - Integer.parseInt(b.substring(0,2))));
                    
        //         }else{

        //         }


        //         max=Math.max(max,ans);
        //     }


           
        // }

       //  public static boolean ArrayChallenge(int []arr){
          
       //    int psum=arr[0];
       //    int n=arr.length;
       //    for(int i=1;i<n;i++){

       //      if(arr[i]<psum){
       //        return false;  
       //      } 

       //      psum+=arr[i];
       //    }

       //    return true;
       // } 

       public static boolean ArrayChallenge(int []arr){
         int s1=arr[0];
         int e1=arr[1];
         int s2=arr[2];
         int e2=arr[3];

         int st=Math.max(s1,s2);
         int ed=Math.min(e1,e2);

         int num=(ed-st+1);

         // System.out.print(num);

         return num>=arr[4];
       } 

}

 
