// 1

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in)

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			int val=scn.nextInt();

			if(val<3){
				System.out.println("LIGHT");
			}else if(val>=3 && val<7) {
				System.out.println("MODERATE");

			}else{
				System.out.println("HEAVY");

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
		Scanner scn=new Scanner(System.in)

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			int s1=scn.nextInt();

			int s2=scn.nextInt();
			int s3=scn.nextInt();
			if(s1!=s2 && s1!=s3 && s2!=s3){
				System.out.println("YES");
			} else{
				System.out.println("NO");

			}
		}
	}
}

// 

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in)

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			 int num=scn.nextInt();
			 int arr[]=new int[num];
			 int countMax=0;
			 int sum=0;
			 int esum=0;
			 for(int j=1;j<=num;j++){
			 	arr[j-1]=scn.nextInt();
			 	sum+=arr[j-1];
			 	esum+=j;

			 	if(arr[j]==num){
			 		if(++countMax>=2) return -1;
			 	} 
			 }
			 System.out.println(esum-sum);
		}
	}
}

// 

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public int finMinTime(int []carr,int []time,int k){
		int list[][]=new int[carr.length][2];
		List<Integer> list=new ArrayList<>();

		for(int i=0;i<carr.length;i++){
			int arr[]=new int[2];
			arr[0]=time[i];
			arr[1]=carr[i];
		}
		Collections.sort(list,(a,b)->{
			return a[0]-b[0];
		});
		HashSet<Integer> set=new HashSet<>();
		int ans=0;
		for(int i=0;i<carr.length;i++){
			int arr[]=list.get(i);
			int tym=arr[0];
			int cat=arr[1];

			if(set.contains(cat)) continue;

			ans+=time;
			if(set.size()==k) return ans;
		}

		return -1;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner scn=new Scanner(System.in)

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			 int cat=scn.nextInt();
			 int k=scn.nextInt();

			 int carr[]=new int[cat];
			 int time[]=new int[cat];
			 for(int j=0;j<cat;j++){
			 	carr[j]=scn.nextInt();
			 }
			 
			 for(int j=0;j<cat;j++){
			 	time[j]=scn.nextInt();
			 }

			 int ans=finMinTime(carr,time,k);
			 System.out.println(ans);
		}
	}
}

// CHEFDINE
 
 
class Codechef
{
	public static long finMinTime(int []carr,int []time,int k){
	 
		List<int[]> list=new ArrayList<>();

		for(int i=0;i<carr.length;i++){
			int arr[]=new int[2];
			arr[0]=time[i];
			arr[1]=carr[i];
			
			list.add(arr);
		}
		Collections.sort(list,(a,b)->{
			return a[0]-b[0];
		});
		HashSet<Integer> set=new HashSet<>();
		long ans=0;
		for(int i=0;i<carr.length;i++){
			int arr[]=list.get(i);
			int tym=arr[0];
			int cat=arr[1];

			if(set.contains(cat)){
			    continue;
			}else{
			    set.add(cat);
			}

			ans+=(long)tym;
			if(set.size()==k) return ans;
		}

		return -1;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner scn=new Scanner(System.in);

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			 int cat=scn.nextInt();
			 int k=scn.nextInt();
            
			 int carr[]=new int[cat];
			 int time[]=new int[cat];
			 for(int j=0;j<cat;j++){
			 	carr[j]=scn.nextInt();
			 }
			 
			 for(int j=0;j<cat;j++){
			 	time[j]=scn.nextInt();
			 }

			 
			 System.out.println(finMinTime(carr,time,k));
		}
	}
}



// 

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{	
	public static long helper(long arr[]){
		long sum=0;
		long esum=0;

		for(long i=0;i<arr.length;i++){
			esum+=i;
			sum+=arr[i];

			if(arr[i]>arr.length) return (long)-1;

			if(arr[i]==arr.length){
				if(++count>=2) return -1;
			}

		}

		return (esum-sum);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in);

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			 long num=scn.nextLong();
			 long arr[]=new long[ num];
			  
			 for(int j=1;j<=num;j++){
			 	arr[j-1]=(long)(scn.nextInt());
			 }
			 System.out.println(helper(arr))
			  
		}
	}
}


class Codechef
{	
	public static long helper(int arr[]){
		 long ans=0;
		 Arrays.sort(arr);

		for(int i=1;i<arr.length;i++){
			if(arr[i]>i) return -1;
			if(arr[i]>arr.length) return (long)-1;
			 
			 sum+=(i-arr[i]);

		}

		return  ;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in);

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			 int num=scn.nextInt();
			 int arr[]=new int[ num];
			  
			 for(int j=1;j<=num;j++){
			 	arr[j-1]=scn.nextInt();
			 }
			 System.out.println(helper(arr));
			  
		}
	}
}
