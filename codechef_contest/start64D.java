import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{	
	public static String find(String s){
		int n=s.length();

		int i=0;
		int j=n/2;

		while(j<n){
			if(s.charAt(i)!=s.charAt(j)){
				return "NO";
			}
			i++;
			j++;
		}
		return "YES";
	}
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();

        for(int i=0;i<n;i++){
        	int w=scn.nextInt();
        	String s=scn.nextLine();

        	System.out.print(find(s));
        }
	}
}


// q2

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
        	int b=scn.nextInt();
        	int max=-1;
        	for(int j=0;j<b;j++){
        		int ball=scn.nextInt();
        		max=Math.max(max,ball);
        	}
        	System.out.println(max);
        }
        
	}
}
