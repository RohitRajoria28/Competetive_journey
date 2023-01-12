// 

class Solution {
    public int maximumCount(int[] nums) {
    	int n=0;
    	int p=0;

    	for(int i : nums){
    		if(i<0) n++;
    		if(i>=0) p++;
    	}

    	return Math.abs(n-p);
        
    }
}

// 


class Solution {
    public long maxKelements(int[] nums, int k) {
        int ans=0;

        Arrays.sort(nums);
        int n=nums.length;
        int idx=n-1;
        while(nums[n-1]>0 && k>0){
        	ans+=nums[n-1];
        	nums[n-1]=Math.ceil(nums[n-1]/3);
        	Arrays.sort(nums);
        	k--;
        }

        	
        for(int idx=n-1;idx>=0;idx--){
        	 ans+=(nums[i]);
        	// if( nums[idx]>nums[idx-1]){
	        // 	val=nums[idx];
	        // 	nums[idx]=Math.ceil(nums[idx]/3);

	        	 
        	// }else if(idx>0 nums[idx]<nums[idx-1]){
        	// 	val=nums[idx-1];
        	// 	idx--;
        	// }

        	// if(k>0){
        	// 	ans+=val;
        	// }

        }


        return ans;
    }
}

// 

class Solution {
    public long maxKelements(int[] nums, int k) {
        int ans=0;

        Arrays.sort(nums);
        int n=nums.length;
        int idx=n-1;
        while(nums[n-1]>0 && k>0){
        	ans+=(long)nums[n-1];
        	nums[n-1]=(int)Math.ceil((long)nums[n-1] /(long)3.0);
        	Arrays.sort(nums);
        	k--;
        }

        	
        // for(int idx=n-1;idx>=0;idx--){
        	 // ans+=(nums[i]);
        	// if( nums[idx]>nums[idx-1]){
	        // 	val=nums[idx];
	        // 	nums[idx]=Math.ceil(nums[idx]/3);

	        	 
        	// }else if(idx>0 nums[idx]<nums[idx-1]){
        	// 	val=nums[idx-1];
        	// 	idx--;
        	// }

        	// if(k>0){
        	// 	ans+=val;
        	// }

        // }


        return ans;
    }
}
// 

class Solution {
    public long maxKelements(int[] nums, int k) {
        int ans=0;

        PriorityQueue<Long> pq=new PriorityQueue<>((a,b)->{
        	return b-a;
        });

        for(int i: nums){
        	pq.add((long)i);
        }

        while(k>0  ){
        	long val=pq.poll();
        	ans+=val;
        	pq.add(Math.ceil(val/3.0));
        }

        return ans;
    }
}

// /

class Solution {
    public boolean isItPossible(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        List<Character> list=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(Character c: s1.toCharArray()){
        	list.add(c);
        	map.put(c,map.getOrDefault(c,0)+1);

        }

        for(Character c: s2.toCharArray()){
        	list.add(c);
        	map.put(c,map.getOrDefault(c,0)+1);
        }
        Collections.sort(list);
        HashMap<Character> map2=new HashMap<>();

        for(int i=0;i<n;i++){
        	Character c=list.get(i);
        	int fval=map.get(c);
        	if(fval==1){
        		map.remove(c);
        	}else{
        		map.put(c,map.get(c)-1);
        	}
        	map2.put(c,map2.getOrDefault(c,0)+1);
        }

        if(map2.size()== map.size() ) return true;

        return false;

    }
}

// 

class Solution {
    public boolean isItPossible(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        List<Character> list=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(Character c: s1.toCharArray()){
        	list.add(c);
        	map.put(c,map.getOrDefault(c,0)+1);

        }
        HashMap<Character,Integer> map2=new HashMap<>();

        for(Character c: s2.toCharArray()){
        	list.add(c);
        	map2.put(c,map2.getOrDefault(c,0)+1);
        }
         
        if(Math.abs(map1.size()-map2.size())!=1) return false;


         HashSet< Character>set1=new HashSet<>();

         for(Character key: map1.keySet()){
         	if(map1.get(key)>1){
         		set.add(key);
         	}
         }
         HashSet<Character> set2=new HashSet<>();

         for(Character key: map2.keySet()){
         	if(map2.get(key)>1){
         		if(!set.contains(key)){
         			set.add(key);
         		}
         	}
         }

        if(set.size()>1) return true;

        return false;

    }
}

// 

class Solution {
	public void remove(HashMap<Character,Integer> map,Character c2){
		map.put(c2,map.get(c2)-1);
		if(map.get(c2)==0){
			map.remove(c2);
		}
	}
    public boolean isItPossible(String word1, String word2) {
         

        HashMap<Character,Integer> map1=new HashMap<>();
        for(Character c: s1.toCharArray()){
        	 
        	map1.put(c,map1.getOrDefault(c,0)+1);

        }
        HashMap<Character,Integer> map2=new HashMap<>();

        for(Character c: s2.toCharArray()){
        	 
        	map2.put(c,map2.getOrDefault(c,0)+1);
        }


        for(char c1='a' ; c1<='z';c1++){
        	if(!map.containsKey(c1)) continue;
        	for(char c2='a';c2<='z';c2++){
        		if(!map2.containsKey(c2)) continue;

        		// put c1 in map2 and remmove c2;
        		remove(map2,c2);
        		map2.put(c1,map2.getOrDefault(c1,0)+1);
        		// put c2 in map1 and remove c1
        		map1.put(c2,map1.getOrDefault(c2)+1);
        		remove(map1,c1);

        		if(map1.size()==map2.size()) return true;

        		// put c1 in map1 and remove c2
        		map1.put(c1,map1.getOrDefault(c1,0)+1);
        		remove(map1,c2);

        		// put c2 in map2 and remove c1;

        		map2.put(c2,map.getOrDefault(c2,0)+1);
        		remove(map2,c1);
        	}
        }


        return false;
    }
}

// 

class Solution {
    public int maxPoints(int[][] arr) {
         HashMap<Integer,Integer> map=new HashMap<>();

         Arrays.sort(arr,(a,b)->{
            return b[1]-a[1];
         });

         HashSet<int[]> set=new HashSet<>();
         for(int i=0;i<n;i++){
            int y2=arr[i][1];
            int x2=arr[i][0];

            for(int j=i+1;j<n;j++){
                int y1=arr[j][1];
                int x1=arr[j][0];
                int slop=0;
                
                if(x2==x1){
                    slop=10000+1;
                }else{
                  slop=(y2-y2)/(x2-x1);
                }

                int pair=new int[]{i,j};
                if(!set.contains(pair)){
                    map.put(slop,map.getOrDefault(slop,0)+1);
                    set.add(pair);                    
                }
            }
         }

         int max=-1;

         for(int k:map.keySet()){
            max=Math.max(max,map.get(k));
         }

         return max;
    }
}