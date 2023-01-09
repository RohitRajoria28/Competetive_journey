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

// 5 january

class Solution {
    public int findMinArrowShots(int[][] arr) {
        if(arr.length<=1) return arr.length;

        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        })

        int pst=arr[0][0];
        int pend=arr[0][1];
        List<Integer []> list=new ArrayList<>();
        list.add(new int[]{pst,pend});



        for(int ar[]:arr){
            int cst=ar[0];
            int cend=ar[1];

            
            if(pend>=cst ){
                list.remove(list.size()-1);
                pst=Math.max(pst,cst);
                pend=Math.min(pend,cend);
            }else{
                 pst= cst ;
                pend= cend ;
            }

           

            list.add(new int[]{pst,pend});

        }

        return list.size();
    }
} 


// 6 january 

class Solution {
    public int maxIceCream(int[] arr, int coins) {
        Arrays.sort(arr);
        int idx=0;
        while(coins>0){
            if(coins>arr[idx]){
                coins-=arr[idx++];
                ans++;
            }else{
                break;
            }
        }

        return idx;
    }
}

// 7 january 

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gtota=0;

        for(int i:gas){
            gtotal+=i;
        }
        int ctotal=0;
        for(int i:cost){
            cost+=ctotal;
        }
        if(gtotal<ctotal) return -1;

        for(int i=0;i<gas.length;i++){
            if(gas[i]-cost[i]>=0) return i;
        }

        return -1;
    }
}