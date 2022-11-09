// https://leetcode.com/contest/weekly-contest-313/problems/number-of-common-factors


class Solution {
    public int commonFactors(int a, int b) {

    	int max=Math.max(a,b);
    	int ans=0;

    	for(double i=1;i<=max;i++){
    		if(a%i==0 && b%i==0) ans++;
    	}
     	
     	return ans;   
    }
}

// 

class Solution {
    public int maxSum(int[][] arr) {

        int row=arr.length;
        int col=arr[0].length;


        int max=0;


        for(int r=0;r+2<row;r++){
        	for(int c=0;c+2<col;c++){
        		int a1=arr[r][c];
        		int a2=arr[r][c+1];
        		int a3=arr[r][c+2];
        		int b=arr[r+1][c+1];
        		int c1=arr[r+2][c];
        		int c2=arr[r+2][c+1];
        		int c3=arr[r+2][c+2];

        		int val=a1+a2+a3+b+c1+c2+c3;
        		ans=Math.min(val,ans);
        	}
        }

        return ans;
    }
}

// 

class Solution {
    
    public  int countSetBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public int minVal(int a, int b)
    {
         
        int setBits1 = countSetBits(b);
        int setBits2=countSetBits(a);
        
        int ans = 0;

        for (int i = 30; i >= 0; i--)
        {
            int mask = 1 << i;

            
            if ((a & mask) > 0 && setBits > 0)
            {
                ans |= (1 << i);

                 
                setBits--;
            }
        }
        return ans;
    }
    public int minimizeXor(int num1, int num2) {
        int count1=0;
        int count2=0;
        int a=num1;
        int b=num2;
        while(a!=0){
            int rsb=a&(-a);
            count1++;
            a=a^rsb;
        }
        while(b!=0){
            int rsb=b&(-b);
            count2++;
            b=b^rsb;
        }
        
        int mbit=Math.ma(count1,count2);
        
        int ans=minVal(num1,num2);
        return ans;
        
        
    }
}