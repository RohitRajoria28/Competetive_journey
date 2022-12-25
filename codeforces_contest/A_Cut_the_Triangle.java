import java.util.*;
import java.lang.*;
import java.io.*;

 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in);

		int n=scn.nextInt();
 
		for(int i=0;i<n;i++){
			int arr[][] =new int[3][2];

			for(int r=0;r<3;r++){
				for(int c=0;c<2;c++){
					arr[r][c]=scn.nextInt();
				}
			}

			System.out.println(isValidTriangle(arr));
			
		}
	}

	public static String isValidTriangle(int [][]arr){
		int count=0;

		for(int r=0;r<3;r++){
			int x1=arr[r][0];
			int y1=arr[r][1];

			for(int r2=r+1;r2<3;r2++){
				int x2=arr[r2][0];
				int y2=arr[r2][1];
				if(x1-x2==0){
					count++;
				}
				if(y1-y2==0){
					count++;
				}

				if(count>=2) return "NO";

			}
		}

		return "YES";

		 
	}
}