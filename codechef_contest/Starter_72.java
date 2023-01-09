/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner scn=new Scanner(System.in);

       int n=scn.nextInt();

        for(int i=0;i<n;i++){

	       	int v1=scn.nextInt();
	       	int v2=scn.nextInt();
	       	int v3=scn.nextInt();

	       	 findVal(v1,v2,v3);
       	 
       	}
       
       	
   }
   public static void findVal(int v1,int v2,int v3){

   		for(int i=1;i<=100;i++){
   			if(v1%i!=0 && v2%i!=0 && v3%i!=0){
   				System.out.print(i);
   				break;
   			}
   		}
   }

} 

// 

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner scn=new Scanner(System.in);

       int n=scn.nextInt();

        for(int i=0;i<n;i++){

	       	int v1=scn.nextInt();
	       	int v2=scn.nextInt();
	       	 

	       	 findVal(v1,v2);
       	 
       	}
       
       	
   }
   public static void findVal(int v1,int v2,int v3){

   		for(int i=1;i<=100;i++){
   			if(v1%i!=0 && v2%i!=0 && v3%i!=0){
   				System.out.print(i);
   				break;
   			}
   		}
   }

} 

// 

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n=scn.nextInt();

        for(int i=0;i<n;i++){

	       	int v1=scn.nextInt();
	       	  
	       	 findVal( );
       	 
       	}
	}
	public static void findVal(int v){
		int a=0;
		int b=0;
		int c=0;
		int mcount=0;
		int t=v;
   		for(int i=2;i<=t;i++){
   			if(v%i==0){
   				if(mcount==0){
   					a=i;
   					mcount++;
   					v/=i;
   				}
   				else if(mcount==1){
   					b=i;
   					v/=i;
   					mcount++;
   				}
   				else if(mcount==2){
   					c=i;
   					v/=i;
   					mcount++;
   				}
   			}

   			if(mcount==3 ){
   				
   				if(c<v) System.out.println(a+" "+b+" "+c);

   				break;
   			}
   		}

   		System.out.println(-1);
   }
}


// 

	public static void main(String[] args) {
		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();
			ArrayList<Integer> factors = new ArrayList<>();
			for (int i = 1; i <= Math.sqrt(N); i++) {
				if (N % i == 0) { 
					if (N / i == i) {
						factors.add(i);
					} else {
						factors.add(i);
						factors.add(N / i);
					}
				}
			}
			Collections.sort(factors);
			int A = factors.get(0), B = factors.get(1), C = N / (A * B);
			if (N == 4 || A == C || B == C || factors.size() < 3) {
				out.println(-1);
				continue;
			}
			out.println(A + " " + B + " " + C);
		}
	}