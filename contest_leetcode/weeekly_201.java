// 

class Solution {
    public String makeGood(String s) {

    	char arr[]=s.toCharArray();
    	boolean flag=true;
    	while(flag){
    		char c1=s.charAt(i);
    		flag=false;
    		 
    		for(int i=1;i<s.length()-1;i++){
	    		if(  c1+32 == s.charAt(i-1) ){
	    			s=s.substring(0,i-1)+ s.substring(i+2,s.length());
	    			flag=true;
	    		}
	    		if(  c1+32 == s.charAt(i+1)){
	    			 s=s.substring(0,i)+ s.substring(i+2,s.length());
	    			flag=true;
	    		}
    		}

    		
    	}


    	 return s;
        
    }
}

// 

class Solution {
	public string revIn(String s){
		char ar[]=s.toCharArray();

		int i=0;
		int j=s.length()-1;

		while(i<j){
			char t=arr[i];

			arr[i]=arr[j];
			arr[j]=t;
		}

		
		for(int i=0;i<arr.length;i++){
			if(arr[i]=='0') arr[i]='1';
			else if(arr[i]=='1') arr[i]=='0';
		}

		return arr.toString();

	}
    public char findKthBit(int n, int k) {


    	if(n==1) return "0";

    	String sm1=Integer.toBinaryString(n-1);
    	String ans= findKthBit(n-1)+"1"+revIn(n-1);

    	for(int i=0;i<=ans.length;i++){
    		if(i==k){
    			return ans.charAt(i);
    		}
    	}
        return 'a';
    }
}