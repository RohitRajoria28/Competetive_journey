 // q1 

class Solution {
    public boolean findSubarrays(int[] arr) {
        HashSet<Integer> map=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n-2;i++ ){
        	int sum=arr[i]+arr[i+1];
        	if(map.contains(sum)) return true;
        	else map.put(sum);
        }

        return false;
    }
}

// q2 6172. Strictly Palindromic Number

class Solution {
	public boolean checkPalindrom(String str){
		int n=str.length;
		int i=0;
		int j=n-1;

		while(i<=j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
		}

		return true;
	}
	public String convertToBinary(int n,int base){
		StringBuilder str=new StringBuilder();

			 
		    while(n>0){
		    	int digit=n%base;
		    	str.append(digit);
		    	n/=base;	
		    }

		    return str.reverse().toString();
	}
    public boolean isStrictlyPalindromic(int n) {
        

        for(int i=2;i<=n-2;i++){
        	 
        	String str=convertToBinary(n,i);

        	if(!checkPalindrom(str))	return false;
        }

        return true;
    }
}
// q3 6173. Maximum Rows Covered by Columns

 
class Solution {
	 ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
     ArrayList<Integer> tmp = new ArrayList<>();
     public  void makeCombiUtil(int n, int left, int k)
    {
       
        // Pushing this vector to a vector of vector
        if (k == 0) {
            ans.add(tmp);
            for(int i = 0; i < tmp.size(); i++)
            {
                System.out.print(tmp.get(i) + " ");
            }
            System.out.println();
            return;
        }
  
        // i iterates from left to n. First time
        // left will be 1
        for (int i = left; i <= n; ++i)
        {
            tmp.add(i-1);
            makeCombiUtil(n, i + 1, k - 1);
  
            // Popping out last inserted element
            // from the vector
            tmp.remove(tmp.size() - 1);
        }
    }
  
    // Prints all combinations of size k of numbers
    // from 1 to n.
    public  ArrayList<ArrayList<Integer>> makeCombi(int n, int k)
    {
        makeCombiUtil(n, 1, k);
        return ans;
    }
    public int FindRes(ArrayList<Integer> smallans,int [][]mat){
    	HashSet<Integer> set=new HashSet<>();

    	for(int i:smallans){
    		set.add(i);
    	}
    	int res=0;
    	for(int r=0;r<mat.length;r++){
    		int temp=1;
    		for(int c=0;c<mat[0].length;c++){
    			if(mat[r][c]==1){
    				if(!set.contains(c)) temp=0;
    			}
    		}
    		res+=temp;
    	}
    	return res;
    }
    public int maximumRows(int[][] mat, int cols) {
        ArrayList<ArrayList<Integer>> ans=makeCombi(mat[0].length,cols);

        int res=-1;
        for(ArrayList<Integer> smallans: ans){
        		res=Math.max(res,FindRes(smallans,mat));
         
        }
        

        return res;

    }
}


       
    

// q4 

class Solution {
    public int maximumRobots(int[] ct, int[] rc, long bd ) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseorder());
        int cost=0;
        int res=-1000;
        int n=ct.length;
        for(int i=0,j=0;i<n ; i++){
            pq.add(rc[i]);
            cost+=rc[i];

            while(i<=j &&  (pq.peek()+pq.size()*(cost))){
                cost-=rc[i];
                pq.remove(ct[i]);
                i++;
            }

            res=Math.max(res,pq.size());
        }

        return res;
        
    }
}