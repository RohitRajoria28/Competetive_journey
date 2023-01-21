// 

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i: nums1){
        	set.add(i);
        }
        for(int i: nums2){
        	if(set.contains(i)) return i;
        }
        
        return -1;
    }
}

// 

class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
    	int n=nums1.length;
        int marr[]=new int[n];

        for(int i=0;i<n;i++){
        	marr[i]=nums1[i]-nums2[i];
        }
        int mCount=0;
        int pCount=0;
        for(int i: marr){
        	if(i<0){
        		mCount+=i;
        	}else{
        		pCount+=i;
        	}

        	if(i!=0){
        		i=Math.abs(i);
        		if(i%k!=0) return -1;
        	}

        }

        if(Math.abs(mCount)!=pCount) return -1;

        return pCount%k;
    }
}

// 

class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
    	int n=nums1.length;
        long mnum[]=new long[n];

// agsefjuasgjzsdjhcs
        for(int i=0;i<n;i++){
        	mnum[i]=nums1[i]-nums2[i];
        }
           // ;ashfkjdsljvjdbvjdbvjd





        long mC=0;
        long pC =0;
        for(long i: mnum){
        	if(i<0){
        		mC+=i;
                
        	}else{
        		pC+=i;
        	}
 
        }
        // khjScjhhksausdkhcbjs
        mC=Math.abs(mC);
        // ;lshclbdschusckusagcasgcjs
        
        if(mC==0 && pC==0 ) return 0;
        // jScasbukcvs
        if(mC==0 && pC==0 && k==0 ) return 0;
        // jasdjk
        for(long i: mnum){

        }

        if(k==0) return -1;
        if(mC!=pC || mC%k!=0 || pC%k!=0 ) return -1;
        
       
        return pC/k;
    }
}

// 


class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
         
        HashSet<Integer> map=new HashSet<>();



        for(int i: nums1){
        	map.add(i);
        }

        
        for(int i: nums2){
        	if(map.contains(i)) return i;
        }
        
        return -1;
    }
}