// 

class Solution {
    public int countTime(String time) {
        //h1-> 0 ,1 - 2 (h2<5) 
        int h1=1;
        // h2-> 0-9 ()
        int h2=1;
        // m1-> (0,6);
        int m1=1;
        // m2-> (0,9) , if(i==2 == 6 ) 1 choice ;
        int m2=1;

        if(time.charAt(0)=='?' &&  ){
        	if( time.charAt(1)-'0'< 4){
        		h1=3;	
        	}else{
        		h1=2;
        	}
        }
        if(time.charAt(1)=='?'){
        	h2=10;
        }
        if(time.charAt(2)=='?'){
        	m1=6;
        }
        if(time.charAt(3)=='?'){
        	m2=10;
        }


        return h1*h2*m1*m2;

    }
}

// 

class Solution {
	public int findNum(int idx){
		int num=1;

		for(int i=1;i<=idx;i++){
			num=num*2;
		}

		return num;
	}
    public int[] productQueries(int n, int[][] queries) {
        
        String s=Integer.toBinaryString(n);
        List<Integer> list=new ArrayList<>();

        int idx=0;
        int n=s.length();
        for(int i=n-1;i>=0;i--){
        	if(s.charAt(i)=='1'){
        		int num=findNum(n-(i+1));
        		list.add(num);
        	}
        }

        Collections.sort(list);
        int mod=(int)1e9+7;
        int ans[]=new int[queries.lenth];
        for(int a[]: queries){
        	int si=a[0];
        	int ei=a[1];
        	long val=1;
        	for(int i=si;i<=ei;i++){
        		val=val*list.get(i)%mod;
        	}
        	ans[idx++]=val;
        }


        return ans;
    }
}