// 

class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> map=new HashSet<>();

        for(int i:nums){
        	map.add(i);
        }
        int max=-1;
        for(int i: nums){
        	if(i>0 && map.contains(-i)){
        		max=Math.max(max,i);
        	}
        }

        return max;
    }
}

// 

class Solution {
	public int findrev(int num){
		if(num==0) return 0;


		int ans=0;

		while(num!=0){
			int rem=num%10;
			ans=ans*10+rem;

			num/=10;
		}

		return ans;
	}
    public int countDistinctIntegers(int[] nums) {

    	HashSet<Integer> list=new HashSet<>();

    	for(int n: nums){
    		list.add(n);
    		int nn=findrev(n);
    		list.add(nn);
    	}


    	return list.size();
        
    }
}


// 

class Solution {
	public int findrev(int num){
		if(num==0) return 0;


		int ans=0;

		while(num!=0){
			int rem=num%10;
			ans=ans*10+rem;

			num/=10;
		}

		return ans;
	}
    public boolean sumOfNumberAndReverse(int num) {
 		int l=0;
 		int r=num;

 		while(l<r){
 			int mid=(l+r-1)>>1;

 			if(mid+findrev(mid)==num) return true;

 			if(mid+findrev(mid)>num){
 				l=mid+1;
 			}else{
 				r=mid-1;
 			}
 		}

 		return  false;
    }
}

// 

class Solution {
    public long countSubarrays(int[] arr, int minK, int maxK) {
    	int i=0;
    	int j=0;
    	int n=arr.length;
    	boolean min=false;
    	boolean max=false;

    	// int minVal=0;
    	// int maxVal=(int)1e9;
    	int ans=0;

    	TreeSet<Integer> set=new TreeSet<>();

    	while(j<n){
    		minVal=Math.min(minVal,arr[j]);
		    maxVal=Math.max(minVal,arr[j]);

    		while(minVal>=minK && maxVal<=maxK){
    			minVal=Math.min(minVal,arr[j]);
    		    maxVal=Math.max(minVal,arr[j]);

    		    if(minVal==minK) min= true;
    		    if(maxVal==maxK) max= true;

    		    while(minVal && maxVal){
    		    	i++;
    		    	minVal=Math.min(minVal,arr[]);
    		        maxVal=Math.max(minVal,arr[j]);
    		    } 
    			
    		}
    		
 	 
    	}
			
		return ans;        
    }
}

class Solution {
    public long countSubarrays(int[] arr, int minK, int maxK) {
    	int i=0;
    	int j=0;
    	int n=arr.length;
    	boolean min=false;
    	boolean max=false;

    	 
    	long ans=0;

    	TreeSet<Integer> set=new TreeSet<>();

    	while(j<n){
		 	boolean flag=false;
		 	int val=arr[j];

    		while(i<j && val<minK && val>maxK && (set.first()==minK && set.last()==maxK)){
    			set.remove(arr[i]);
		    	i++;
		    	ans++;
		    	flag=true;
    		}
    		

    		set.add(val);
    		if(set.first()==minK && set.last()==maxK) ans++;
 	 		j++;
 	 		if(flag){
 	 			 i=j;
 	 			 set=new TreeSet<>();
 	 		}
    	}

    	while(i<j){
    			while(i<j && val<minK && val>maxK && (set.first()==minK && set.last()==maxK)){
    			set.remove(arr[i]);
		    	i++;
		    	ans++;
		    	flag=true;
    		}
    	}
			
		return ans;        
    	}
    }


// 

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
		long ans=0;
		int i=2;
		 
		for(int i=0;i<arr.length;i++){
			TreeSet<Integer> set=new TreeSet<>();
			for(int j=i;j<arr.length;j++){
				set.add(arr[j]);
			}
			if(set.first()==minK && set.last()=maxK) ans++;
		}    

		return ans;
    }
}