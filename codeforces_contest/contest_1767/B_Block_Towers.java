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
            int num=scn.nextInt();
			int arr[]=new int[num];

			for(int j=0;j<num;j++){
				 arr[j]=scn.nextInt();
			}
            int ftower=arr[0];
            for(int j=1;j<num;j++){
                  ftower=findMaxtower(ftower,arr[j]);     
            }

            System.out.println(ftower);
			
		}
	}

	public static int findMaxtower(int ftower,int adtower){
        
        if(ftower>=adtower) return ftower;
         
        int ans=((adtower-ftower)/2)+1;


        return ftower+ans;
	}
}