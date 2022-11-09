// 

class Solution {
    public boolean equalFrequency(String word) {

    	HashMap<Character,Integer> map=new HashMap<>();

    	for(char c: word.toCharArray()){
    		map.put(c,map.getOrDefault(c,0)+1);
    	}
        
        int max=-10;
        int min=(int)1e9;
         
        HashMap<Integer,Integer> set=new HashMap<>();

         List<Integer> list=new ArrayList<>();

        for(char c: map.keySet()){
        	list.add(map.get(c)); 
        }

        Collections.sort(list);

        if(list.size()>2) return false;

        if((list.get(1)-list.get(0))>1) return false;


        return true; 
         
    }
}



// 

class Solution {
    public boolean equalFrequency(String word) {

    	char arr[]=word.toCharArray();


        
    }
}

// 


class Solution {
    public boolean equalFrequency(String word) {

    	HashMap<Character,Integer> map=new HashMap<>();

    	for(char c: word.toCharArray()){
    		map.put(c,map.getOrDefault(c,0)+1);
    	}

    	 HashMap<Character,Integer> map2=new HashMap<>();

    	 for(char c: map.keySet()){
    	 	map2.put(c,map.get(c)-1);
    	 }

    	 int val=map2.get(word.charAt(0));
    	 for(char c : map2.keySet()){
    	 	if(val!=map2.get(c)) return false;
    	 }
        


        return true; 
         
    }
}


// 

class LUPrefix {
    TreeSet<Integer> set;
    int length;
    public LUPrefix(int n) {
        set=new TreeSet<>();
        length=n;
        for(int i=1;i<=n;i++){
            set.add(i);
        }
    }
    
    public void upload(int video) {
        set.remove(video);
    }
    
    public int longest() {
        if(set.isEmpty()) return length;

        return set.first()-1;
    }
}


// 

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {

        int x=0;
        int y=0;
        
        for(int a: nums1){
            x^=a;
        }
       
        for(int b:nums2){
            y^=b;
        }

        return ((nums1.length%2)*y) ^ ((nums2.length%2)*x) ;
        
    }
}