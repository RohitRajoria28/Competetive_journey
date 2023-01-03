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
        
        for(String s:strs){
            boolean inc=false;
            boolean dec=false;
            boolean isSort=true;
            for(int i=0;i<s.length();i++){
                int curr=s.charAt(i)-'a';
                int next=s.charAt(i+1)-'a';
                if(i==0 && curr<next){
                    inc=true;
                }else if(i==0 && curr>next){
                    dec=true;
                }

                if(inc && next<cur){
                    isSort=false;
                    break;
                }

                if(dec && next>cur){
                    isSort=false;
                    break;
                }
            }

            if(isSort) ans++;
        }
    }
}