// 2 janauary

class Solution {
	public int isCapitle(char c){
		return (c >='A' &&  c<='Z')?1:0;
	}

    public boolean detectCapitalUse(String word) {
        
        int n=word.length();
        
        if(n==1  ) return  isCapitle(word)==1?true:false;

        for(int i=0;i<word.length;i++){
        	int ft=isCapitle(word.charAt(i));

        	if(i==0)  {
        		val=(ft==0)?2:3;  
        	} 

        	if( i >0 && val==2 && ft==1){
        		return false;
        	} 
        }

         return true; 
    }
} 



// 3 january

class Solution {
    public int minDeletionSize(String[] strs) {
        int ans=0;
        
        for(int i=0;i<strs[0].length;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}

// jan 4

class Solution {
    public int minimumRounds(int[] arr) {
        if(arr.length<2) return -1;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i: arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans=0;

        for(int i: map.keySet()){
            int tasks=map.get(i);
            if(tasks<2) retrun -1;

            ans+=(Math.ceil((double)tasks/3.0));
        }

        return ans;
    }
}