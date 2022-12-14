// q1 
class Solution {
	public int helper(String s){
		boolean isNumeric=true;
		for(char c: s.toCharArray()){
			if(c-'0' >=0 && c-'0'<=9){

			}else{
				isNumeric=false;
			}
		}
		return isNumeric? Integer.parseInt(s): s.length();
	}
    public int maximumValue(String[] arr) {
       int max=1;
       for(String s: arr){
       		ing len=helper(s);
       		max=Math.max(len,max);
       }   
       return max;
    }
}

// 


class Solution {
	public int helper(String str){
         
		boolean isNum=true;
		for(char ch: str.toCharArray()){
			if(ch-'0' >=0 && ch-'0'<=9){

			}else{
				isNum=false;
			}




		}



		return isNum? Integer.parseInt(str): str.length();
	}
    public int maximumValue(String[] a ) {
       int maxxx=0;
       for(String strr: a ){
       		int len=helper(strr);

       		
       		maxxx=Math.max(len,maxxx);
       }   



       return maxxx;
    }
}