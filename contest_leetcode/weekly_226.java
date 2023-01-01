class Solution {
    public int countDigits(int num) {
        int ans=0;

        int t=num;

        for(int t>0){
        	int rem=t%10;
        	if(num%rem==0){
        		ans++;
        	}
        	t=t/10;
        }
        return ans;
    }
}

// 

class Solution {
	public int  distinctPrimeFactors(int N)
  {
    if (N < 2) {
      System.out.print(-1);
    }
 
    int c = 2;
 
   int ans=0;
    HashMap<Integer, Boolean> visited = new HashMap<>();
 
    for(int i = 0; i < N; i++) {
      visited.put(i, false);
    }
 
    while (N > 1) {
      if (N % c == 0) {
        if(visited.containsKey(c)){
          if (!visited.get(c)) {
            ans++;
            visited.put(c, true);
          }
        }
        N /= c;
      }
      else
        c++;
    }

    return ans;
  }
    public int distinctPrimeFactors(int[] nums) {
        int pro=1;

        for(int i:nums){
        	pro*=i;
        }
        return distinctPrimeFactors(pro);
    }
}


// 



class Solution {
    HashSet<Integer> set=new HashSet<>();
	
	public void findN(int num)
  {
    if (num < 2) {
      System.out.print(-1);
    }
 
    int c = 2;
 
     
    while (num> 1) {
      while(num%c==0){
          num=num/c;
        set.add(c);
      }
         
        c++;
    }
       
  }
    public int distinctPrimeFactors(int[] arr) {
        
        for(int i:arr){
        	 findN(i);
        }
         
        return set.size();
    }
}

// 

class Solution {
    public int countDigits(int number) {
        int smallans=0;

        int temp=number;

        while( temp>0){
        	int rem=temp%10;
        	if(number%rem==0){
        		smallans++;
        	}
        	temp=temp/10;
        }
        return smallans;
    }
}

// 

class Solution {
	int idx=0;
	public int dist(char []arr){
		int ans=0;
		 
		int cval=0;
		while(cval<k && idx<arr.length){
			int val=arr[idx]-0;
			cval=cval*10+val;
			
			if(cval>k){
				ans++;
				cval=0;
				 
			}else{
			 idx++;				
			}
		}
		 
		return ans;
	}
    public int minimumPartition(String s, int k) {
        char arr[]=s.toCharArray();
        return dist(arr,k);
    }
}


class Solution {
	
	public int dist(int num,int k){
		int ans=0;
		 int idx=0;
		int cval=0;
		while( num>0 && idx<arr.length){
			int val=num%10;
			cval=cval*10+val;
			num=num/10;
			if(cval>=k){
				ans++;
				cval=0;
				if(cval>k){
					idx--;
				}
			}
			idx++;
		}
		 
		return ans;
	}
    public int minimumPartition(String s, int k) {
        int num=Integer.parseInt(s);
        return dist(num,k);
    }
}

class Solution {
	
	public int dist(String s,int k){
		int ans=0;
		 int idx=0;
		int cval=0;
         char arr[]=s.toCharArray();
		while( idx<arr.length ){
			int val=arr[idx]-'0';
			 cval=cval*10+val;
			 
            idx++;
			if(val>k) return -1;
            
            if(cval>=k){
				ans++;
				 
				if(cval>k){
                   idx--
                }
                cval=0;
			}else{

            	if(idx==arr.length && val!=0) ans++;
                
            }
           
			 
		}
         
		 
		return ans;
	}
     
    public int minimumPartition(String s, int k) {
         
        
        return dist(s,k);
    }
}

class Solution {
    public int minimumPartition(String s1, int k) {
        char s[]=s1.toCharArray();
        int ans=0;int n=s.length;
        long prev=0;
        for(int i=0;i<n;i++)
        {
            long ch=s[i]-'0';
            prev=prev*10L+ch;
            if(prev>k)
            {
                ans++;prev=ch;
                if(prev>k)
                    return -1;
            }
        }
        ans++;
        return ans;
    }
}

// 


class Solution {
    public int minimumPartition(String s, int k) {
        int ans=0;
        long pval=0L;
        for(int i=0;i<s.length;i++){
        	long val=s.charAt(i)-'0';
        	pval=pval*10L+val;
        	if(pval>k){
        		ans++;
        		pval=val;
        		if(val>k) return -1;
        	}


        }
        ans++;

        return ans;
    }
}

// 

class Solution {
    public int[] closestPrimes(int left, int right) {
        
    }
}