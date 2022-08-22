// 

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int esum=0;
        for(int i:energy){
        	sum+=i;
        }
        int reqEnergy=0;
        if(esum+1>initialEnergy) reqEnergy=(esum+1)-initialEnergy;

        int exp=initialExperience;
        int ex=initialExperience;
        int reqEx=0;
//  initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]
        for(int i:experience){
        	if(ex<i){
        		reqEx=i+1;
        		ex=reqEx;
        		continue;

        	}
        	ex+=i;
        }  

        reqEnergy+=(reqEx- initialExperience);

        return reqEnergy;
    }
}

//2

	class Solution {
	    public String largestPalindromic(String num) {
	        
	        TreeSet<Integer> set=new TreeSet<>();
	        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

	        HashMap<Integer,Integer> map=new HashMap<>();

	        for(char c: num.toCharArray()){

	        	int val=c-'0';

	        	if(val!=0) map.put(val,map.getOrDefault(val,0)+1);
	        }
	        int even=0;
	        int oddVal=0;
	        for(int key: map.keySet()){
	        	if(map.get(key)%2!=0 ) set.add(key);
	        	else if(map.get(key)%2==0){
	        		pq.add(key);
	        		even+=map.get(key);
	        	}
	        	 
	        }
	        if(set.size()>0) oddVal=1;
	        int n=even+oddVal;
	        int arr[]=new int[n];
	        
	        arr[n/2]=set.last();
	        int e=n-1;
	        int s=0;
	        for(int val:pq){
	        	int freq=map.get(val);
	        	while(freq>0){

	        		if(s>e) break;
	        		arr[s++]=val;
	        		arr[e--]=val;

	        		freq-=2;
	        	}
	        }

	        return arr.toInt()

	    }
	} 

