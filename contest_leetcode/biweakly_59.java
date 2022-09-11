// 1974. Minimum Time to Type Word Using Special Typewriter
 class Solution {
    

    public int minTimeToType(String word) {
    	 	int time=0;
 	 		char prev='a';
    		
    		for(int i=0;i<word.length();i++){
    			char c=word.charAt(i);

    			tim=Math.min(Math.abs(prev-c),Math.min(pre-'a'+'z'-c,'z'-prev+ch-'a'));
    			time+=tim+1;
    			prev=c;
    		}


		return time;        
    }
}