// 
class Solution {
    public int deleteGreatestValue(int[][] ar) {
   			
   			int sum=0;
            
   			 while(arr[0].length-->0){
   			 	int row=arr.length;
   			 	int col=arr[0].length;
   			 	for(int r=0;r<row;r++){
   			 		int max=-1;
   			 		int mr=-1;
   			 		int mc=-1;
   			 		for(int c=0;c<col;c++){
   			 			if(max<arr[r][c]){
   			 				max=arr[r][c];
   			 				mr=r;
   			 				mc=c;
   			 			}
   			 		}

   			 		sum+=max!=-1?max:0;
   			 		arr[mr][mc]=-1;
   			 	}
   			 }
                   
           

   			return sum;  
   	}
}

// 

class Solution {
    public int longestSquareStreak(int[] arr) {
    	Arrays.sort(nums);

    	HashSet<Integer> set=new HashMap<>();

    	for(int i: arr){
    		set.add(i);
    	}
    	int maxl=1;
    	for(int i:arr){
    		int len=1;
    		int val=i;
    		while(set.contains(val)){
    			val*=i;
    			len++;
    		}
    		maxl=Math.max(len,maxl);
    	}

    	return maxl==1?-1:maxl;
        
    }
}

// 


class Solution {
    public int longestSquareStreak(int[] nums) {

    	Arrays.sort(nums);

    	HashSet<Integer> map=new HashSet<>();

    	for(int i: nums){
    		map.add(i);
    	}

    	int maxlen=1;
    	for(int i:nums){
    		int len=0;

    		int value=i;
    		while(value<=nums[nums.length-1] && map.contains(value)){
    			value*=value;
    			len++;
    		}
            System.out.print(value+" "+i+" "+len+" ,");
    		maxlen=Math.max(len,maxlen);
    	}

    	return (maxlen==1?-1:maxlen);
        
    }
}

// 

class Solution {
    public int deleteGreatestValue(int[][] nums) {
   			  
   			int summ=0;
   			 
            int len=nums[0].length;
   			 while(len-->0){
   			 	int row=nums.length;
   			 	int col=nums[0].length;
   			  
                 int mx=-1;
   			 	for(int r=0;r<row;r++){
   			 		int max=-1;
   			 		   
   			 		int mrow=-1;
   			 		int mccol=-1;



   			 		for(int c=0;c<col;c++){
   			 			if(max<nums[r][c]){


   			 				max=nums[r][c];
   			 				mrow=r;



   			 				mccol=c;
   			 			}
   			 		}
                    mx=Math.max(max,mx);
                    



   			 		nums[mrow][mccol]=-1;
   			 	}


                 summ+=mx;
   			 }
                   
           

   			return summ;  
   	}
}


// 


class Allocator {
    int arr[];
    HashMap<Integer,List<Integer>> map;
    
    public Allocator(int n) {
        arr=new int[n];
        map=new HashMap<>();
    }
    
    public int allocate(int size, int mID) {
        int fidx=-1;
        for(int i=0;i<arr.length;i++){
            int sz=size;
            int len=0;
            int idx=i;
            while( idx<arr.length && arr[idx]==0 && sz-->0){
                len++;
                idx++;
            }
            if(len==size){
                fidx=i;
                break;
            }
        }
          
        if(!map.containsKey(mID)){
                List<Integer> list=new ArrayList<>();
                map.put(mID,list);
        }
        if(fidx==-1) return -1;
        
        for(int i=fidx;i<fidx+size;i++){
            arr[i]=mID;
            List<Integer> mlist=map.get(mID);
            mlist.add(fidx);
            map.put(mID,mlist);
        }
        
        return fidx;
    }
    
    public int free(int mid) {
        if(!map.containsKey(mid)) return 0;
        List<Integer> list=map.get(mid);
        
        for(int i=0;i<list.size();i++){
            int idx=list.get(i);
            arr[i]=0;
        }
        return list.size();
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */