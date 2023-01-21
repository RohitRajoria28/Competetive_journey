// 


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
		while(n-->0){
			int value=scn.nextInt();
			int amt=scn.nextInt();

			System.out.println(amt/val);
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
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		while(n-->0){
			int value=scn.nextInt();
			int likes[]=new int[value];
			int comt[]=new int[value];

			int midx=0;
			 
			for(int i=0;i<value;i++){
				int lk=likes[i];
				int cm=comt[i];

				if(likes[midx]<lk){
					midx=i;
					 
				}else if(likes[midx]==lk){
					if(comt[midx]<cm){
						 
						midx=i;
					}
				}
			}

			System.out.println(max);
		}
	}
}