// 

class Solution {
    public int differenceOfSum(int[] nums) {
        int sum=0;
        for(int i: nums){
        	sum+=i;
        }
        int digit =0;

        for(int i=0;i<nums.length;i++){
        	int val=nums[i];

        	while(val>0){
        		digit+=val%10;
        		val=val/10;
        	}
        }

        return Math.abs(sum-digit);
    }
}

// 6292. Increment Submatrices by One

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
    	int mat[][]=new int[n][n];
        for(int i=0;i<queries.length;i++){
        	int qr[]=queries[i];
        	int r1=qr[0];
        	int c1=qr[1];
        	int r2=qr[2];
        	int c2=qr[3];

        	for(int r=r1;r<=r2;r++){
        		for(int c=c1;c<=c2;c++){
        			mat[r][c]+=1;
        		}
        	}
        	
        }
        return mat;
    }
}



// 

class Solution {
	public int getpair(int p){
		int val=0;
		int pval=p-1;
		while(p>0){
			val+=p;
			p-=1;
		}	
		return val;
	}
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int i=0;
        int j=0;
        int pairs=0;
        int ans=0;
        int n=nums.length;
        while(j<n){
        	int val=nums[j];

        	map.put(val,map.getOrDefault(val,0,)+1);

        	if(map.containsKey(val) && map.get(val)>=2){
        		int p=map.get(val);
        		pair+=p;
        		
        	}
        	if(pair>=k){
        		ans++;
        	}
        	 
        	if(pair>k){
        		while(i<nums.length && pairs>=k){
	        		int val=nums[i];

	        		int gval=map.get(val);
	        		if(gval>=2){
	        			  
	        			pair-=1;
	        			map.put(val,gval-1);
	        		}else if(gval==1){
	        			map.remove(val);
	        		}
	        		if(pair>=k) ans++;
	        		i++;
	            }
        	}
        	j++;
        }
    }
}

// LinkedIn clone is a clone of professional networking site. It provides a huge platform for millions of professionals to exchange views, information, opportunity & ideas related to the business world professionals.
// It is a web application clone of Excel, created using HTML, CSS and Javscript entirely.
// You can add text, change styling like bold, italics and underline of the text

// Tinder Clone is a white-label dating app solution that is based on the popular on-demand dating app Tinder. As the term 'Tinder Clone' suggests, it is a replica of the standard app, which contains the biggest share of its features and functionality.
// Chatting app allows you to communicate with your customers in web chat rooms. It enables you to send and receive messages. Chatting apps make it easier, simpler, and faster to connect with everyone and it is also easy to use.
class Solution {
    public long countGood(int[] nums, int k) {
        int i = 0;
        int j = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(nums[0], 1);
        int pairs = 0;
        long ans = 0L;
        int n = nums.length;
        while (true) {
            if (pairs < k) {
                j++;
                if (j >= n) break;
                int c = count.getOrDefault(nums[j], 0) + 1;
                count.put(nums[j], c);
                pairs += (c - 1);
            } else {
                ans += (n - j);
                int c = count.get(nums[i]);
                pairs -= (c - 1);
                if (c == 1) 
                    count.remove(nums[i]);
                else
                    count.put(nums[i], c - 1);
                i++;
            }
        }
        return ans;
    }
}

// 


class Solution {
    public long countGood(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        long ans=0;

        int pair =0;
        int i=0;
        int j=0;
        int n=arr.length;
        while(j<arr.length){
        	int val=arr[j];
        	if(pair<k){
        		map.put(val,map.getOrDefault(val,0)+1);
        		pair+=(map.get(val)-1);
        		j++;
        	}else {
        		ans=(n-j);
        		int rval=map.get(arr[i]);
        		pair-=rval-1;
        		if(rval>=2){
        			
        			map.put(arr[i],rval-1);	
        		}else{
        			map.remove(arr[i]);
        		}
        		i++;
        	}
        }

        return ans;
    }
}