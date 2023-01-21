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
                while(n-->0){
                    long a=scn.nextInt();
                    long b=scn.nextInt();
                     
                    
                    helper(a,b);  
                } 
        } 
       public static long findgcd(long a,long x){
            if(a==0) return x;

            return findgcd(x%a,a);
       } 

       public static long findLcm(long num1,long num2){
            long lcm = (num1 > num2) ? num1 : num2;
             
            while(true) 
            {
               if( lcm % num1 == 0 && lcm % num2 == 0 ) 
               {
                   return lcm;
                    
                }
             ++lcm;
            }
            
       }

       public static void helper(long a, long b){ 

            long lo=1L;
            long hi=1000000000L;

            long ans=1000000L;

            while(lo<=hi){
                long  mid=hi+lo>>1;
                long lcm=findLcm(a,mid);
                long gcd=findgcd(b,mid);

                System.out.println("gcd : "+gcd + "  lcm : "+lcm+"  ");
                long tans=lcm-gcd;
                if(tans<ans){
                    ans=tans;
                     hi=mid-1; 
                }else{
                  
                  lo=mid+1;
                     
                }
            }

            System.out.println(ans);
       }
          
}

 
