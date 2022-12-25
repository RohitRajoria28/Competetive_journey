class Solution {
	public boolean isValidStrings(String s1,String s2){



		TreeSet<Character> saatt1=new TreeSet<>();


		TreeSet<Character> saatt2=new TreeSet<>();
		 
		char arr1[]=s1.toCharArray();
		char arr2[]=s2.toCharArray();

		for(char c: arr1){
			saatt1.add(c);
		}
		for(char c:arr2){
			saatt2.add(c);
		}
		if(saatt1.size()!=saatt2.size()) return false;

		while(saatt1.size()>0 && saatt2.size()>0){
			char c1=saatt1.pollFirst();
			char c2=saatt2.pollFirst();

			if(c1!=c2) return false;
		}
		return true;

	}
    public int similarPairs(String[] nums) {

    	int ans=0;
       
    	for(int i=0;i<nums.length;i++){
    		String string1=nums[i];
    		for(int j=i+1;j<nums.length;j++){
    			String string2=nums[j];


    			if(isValidStrings(string1,string2)) ans++;
    		}
    	}

    	return ans;
        
    }
}

// 

class Solution {
	public int primeFactors(int n)
    {
         int ans=0;
        while (n%2==0)
        {
            ans+=2;;
            n /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                ans+=i;
                n /= i;
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
             ans+=n;


        return ans;
    }
    public int smallestValue(int n) {
        
    	boolean flag=true;
    	int val=n;
        int ans=n;
        while(flag){
        	int ansList=primeFactors(val);
            if(ansList==val){
              ans= ansList;  
                flag=false;
            } 
            val=ansList;
        }
        return ans;
        
    }
}




// 


class Solution {
	public int GivePrimeFactors(int value)
    {
    	 
         int MyAns=0;
        while (value%2==0)
        {
            MyAns+=2;;
            value /= 2;
        }
 
        
        for (int i = 3; i <= Math.sqrt(value); i+= 2)
        {
            while (value%i == 0)
            {
                MyAns+=i;
                value /= i;
            }
        }
  
        if (value> 2){
             MyAns+=value;

        }


        return MyAns;
    }
    public int smallestValue(int n) {
        
    	boolean isValid=true;
    	int value=n;
        int myans=n;
        while(isValid){
        	int list=GivePrimeFactors(value);
            if(list==value){
              myans= list;  
                isValid=false;
            } 
            value=list;
        }
        return myans;
        
    }
}