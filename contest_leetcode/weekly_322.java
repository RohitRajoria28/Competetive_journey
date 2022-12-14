// 

class Solution {
    public boolean isCircularSentence(String sen) {
         

        String arr[]=sen.split(' ');

        if(arr.length==1){
        	return arr[0].charAt(0)==arr[0].charAt(arr[0].length()-1);
        }

        String fir=arr[0];

        for(int i=1;i<arr.length;i++){
        	String sec=arr[i];

        	if(fir.charAt(fir.length()-1)!=sec.charAt(0)){
        		return false;
        	}
        	fir=sec;
        }
        if(arr[0].charAt(0)!=arr[arr.length-1].charAt(arr[arr.length-1].length()-1)){
        	return false;
        }
        return true;
    }
}

// 

class Solution {
    public long dividePlayers(int[] arr) {
        int sum=0;

        for(int i:skill){
        	sum+=i;
        }
        int teams=arr.length/2;
        
        int tsize=sum/(teams);

        if(tsize%2!=0) return long(-1);


        Arrays.sort(arr);

        int i=0;
        int j=arr.length-1;

        long ans=0;
        long nans=-1;
        while(i<j){

        	if(arr[i]+arr[j]!=tsize){
        		return nans;
        	}
        	ans+=(long)(arr[i]*arr[j]);
        }

        return ans;

    }
}

// 


class Solution {
    public long dividePlayers(int[] ar) {
        int tar=0;
        
         
         
       if(ar.length==2) return (long)(ar[0]*ar[1]); 
        
        for(int i:ar){
        	tar+=i;
        }
        int  ms=ar.length/2;
        
        int tsize=tar/(ms);
        Arrays.sort(ar);

        int i=0;
        int j=ar.length-1;

        long an=0;

        long na=-1;
        while(i<j){

        	if(ar[i]+ar[j]!=tsize){
        		return na;
        	}
        	an+=(long)(ar[i]*ar[j]);
            i++;
            j--;
        }

        return ans;

    }
}

// 

class Solution {
    public boolean isCircularSentence(String sentence) {
         
    	  
        String arrayy[]=sentence.split(" ");

        if(arrayy.length==1){
        	return arrayy[0].charAt(0)==arrayy[0].charAt(arrayy[0].length()-1);
        }

        String f=arrayy[0];

        for(int i=1;i<arrayy.length;i++){
        	String s=arrayy[i];

        	if(f.charAt(f.length()-1)!=s.charAt(0)){
        		return false;
        	}
        	f=s;
        }
        if(arrayy[0].charAt(0)!=arrayy[arrayy.length-1].charAt(arrayy[arrayy.length-1].length()-1)){
        	return false;
        }
        return true;
    }
}