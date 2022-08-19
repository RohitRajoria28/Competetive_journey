 

 class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int a[]:items1){
        	map.add(a[0],map.getOrDefault(a[0],0)+a[1]);
        }
        for(int a[]:items2){
        	map.add(a[0],map.getOrDefault(a[0],0)+a[1]);
        }

        List<List<Integer>> ans=new ArrayList<>((a,b)->{
        	return a.get(0)-b.get(0);
        });

        for(int key: map.keySet()){
            List<Integer> base =new ArrayList<>();
            base.add(key);
            base.add(map.get(key));
        	ans.add(base);
        }

        return ans;
    }
}

// 2nd questoin

class Solution {
    public long countBadPairs(int[] nums) {
        
        int count=0;
        for(int i=0;i<nums.length-1;i++){
        	for(int j=i+1;j<nums.length;j++){
        		if((j-i)!=nums[j]-nums[i]){
        			count++;
        		}
        	}
        }

        return count;
    }
}