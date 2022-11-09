// q1 

class Solution {
    public int[] applyOperations(int[] nums) {
     	int n=nums.length;
     	for(int i=0;i<n-1;i++){
     		if(nums[i]==nums[i+1]){
     			nums[i]=nums[i]*2;
     			nums[i+1]=0;
     		}
     	}   

     	int ans[]  =new int[n];
     	int idx=0;

     	for(int i: nums){
     		if(i>0) ans[idx++]=i;
     	}
     	return ans;
    }
}

// q2

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
     	HashMap<Long,Long> set=new HashSet<>();

     	long n=nums.length;
     	long max=0;
     	List<Integer> arr=new ArrayList<>();

     	for(int i=0;i<n-1;i++){
     		if(nums[i]==nums[i+1]){
     			continue;
     		}else{
     			list.add(nums[i]);
     		}

     	}

     	list.add(nums[n-1]);

     	if(list.size()<k){
     		return 0;
     	}

     	for(int i=0;i<list.size();i++){
     		int val=list.get(i);
     		if(i<k){
     			set.add(val);
                 if(i==k-1 && set.size()==k){
                    int cs=0;

                    for(int v: set ){
                        cs+=v;
                    }

                    max=Math.max(max,cs);
                 }
     			continue;
     		}

     		set.remove(list.get(i-k));
     		set.add(val);

     		if(set.size()==k){
     			int cs=0;

     			for(int v: set ){
     				cs+=v;
     			}

     			max=Math.max(max,cs);
     		}

     	}

     	return max;

    }
}

// 

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> set=new HashSet<>();

     	int n=nums.length;

     	long max=0;

     	for(int i=0;i<n;i++){
     		int val=nums[i];
     		if(i<k){
     			  map.put(val,map.getOrDefault(val,0)+1);

	 			if((i==k-1) && map.size()==k){
		 			long cs=0L;

		 			for(int v: map.keySet() ){
		 				cs+=(long)v;
		 			}

		 			max=Math.max(max,cs);
	 			}
     			  continue;
     		}

     		int rval=nums[i-k];


     		 if(map.get(rval)==1){
     		 	map.remove(rval);
     		 }else{
     		 	map.put(rval,map.get(rval)-1);
     		 }

     		 map.put(val,map.getOrDefault(val)+1);

     		if(map.size()==k){
     			long cs=0L;

     			for(int v: map.keySet() ){
     				cs+=(long)v;
     			}

     			max=Math.max(max,cs);
     		}

     	}

     	return max;
    }
}


// 

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

     	int n=nums.length;

     	long max=0;
     	long sum=0;
     	for(int i=0;i<n;i++){
     		sum+=nums[i];
     		map.put(nums[i],map.getOrDefault(nums[i],0)+1);

     		if(i>=k-1){
     			if(map.size()==k){
     				max=Math.max(sum,max);
     			}
     			sum-=nums[i-k+1];
     			map.put(nums[i-k+1],map.get(nums[i-k+1])-1);
     			if(map.get(nums[i-k+1])==0){
     				map.remove(nums[i-k+1]);
     			}
     		}
     	}
     	return max;
    }
}