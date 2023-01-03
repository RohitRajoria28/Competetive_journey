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

