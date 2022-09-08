// q1


class Solution {
    public int maxDistance(int[] arr) {
    	int mdis=0;
    	int n=arr.length;
    	for(int i=0;i<n;i++){
    		for(int j=i+1;j<n;j++){
    			if(ar[i]!=arr[j]) mdis=Math.max(mdis,(j-i));
    		}
    	}
		
		return mdis;        
    }
}

// q2 2079. Watering Plants

class Solution {
    public int wateringPlants(int[] arr, int capacity) {
        int water=capacity;
        int steps=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
        	if(water>=arr[i]){
        		water-=arr[i];
        		step++;
        	}else{
        		steps+=2*(i-(-1))-1;
        		water=capacity;
        		water-= arr[i];
        	}
        }

        return steps;
    }
}

// q3 2080. Range Frequency Queries

class RangeFreqQuery {
     
    HashMap<Integer,TreeMap<Integer,Integer>> map;
    
    public RangeFreqQuery(int[] ar) {
         map=new HashMap<>();
        
        for(int i=0;i<ar.length;i++){
            int val=ar[i];
            map.putIfAbsent(val,new TreeMap<>());
            map.get(val).put(i);
        }

    }
     
    public int query(int left, int right, int value) {
        
        if(!map.containsKey(value)) return 0;
        else{
            map.Entry<Integer,Integer> floor=map.get(value).ceilKey(left);
            map.Entry<Integer,Integer> ceil=map.get(value).floorKey(right);


            return if(floor==null || ciel==null)? 0: floor.getValue()-ceil.getValue()+1;
        }

    }
}

// q4

class Solution {
    public int generatePal(int n,boolean odd){
        int num=n;
        if(odd) num=num/10;

        while(num>0){
            n=n*10+(num%10);
            num=num/10;
        }

        return n;
    }
    public String convertBase(int n,int base){
        StringBuilder str=new StringBuilder();i
        int num=n;
        while(num>0){
            int val=num%base;
            num/=base;
            str.append(val);
        }

        return str.toString();
    }
    public boolean Cpalindrom(String s){
        int n=s.length();

        for(int i=0;i<=n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }

        return true;
    }
    public long kMirror(int k, int n) {
        
        int sum=0;
        
        for(int i=1;n!=0; i*=10){
//             odd numbers
            for(int j=i;j<i*10 && n!-0;j++){
                int pnum=generatePal(j,true);
                String str=convertBase(pnum,k);

                if(Cpalindrom(str)){
                    sum+=pnum;
                    n--;
                }
            }
//             even 
            for(int j=i;j<i*10 && n!=0;j++){
                int pnum=generatePal(j,false);
                String str=convertBase(pnum,k);

                if(Cpalindrom(str)){
                    sum+=pnum;
                    n--;
                }

            }
        }

        return sum;
    }
}

// public :
// } ;
//     long long kMirror ( int k , int n ) {
//        long long sum = 0 ;
//         for ( int i = 1 ; n ; i = i * 10 ) {
//             // odd digit generation
//             for ( int j = i ; j < i * 10 && n ; j ++ ) {
//                 long long num generateNumber ( j , true ) ; =
//                 string str = to_base ( num , k ) ;
//                 if ( checkPalindStr ( str ) ) {
//                     sum + = num ;
//                     n-- ;
//            }
//                }
//            }
//             // even digit generation
//             for ( int j i ; j < i 10 && n ; j ++ ) {
//                long long num = generateNumber ( j , false ) ;
//                 string strto_base ( num , k ) ;
//                if ( checkPalindStr ( str ) ) {
//                     sum + = num ;
//                     n-- ;
//                }
//        }
//         return sum ;
// }       