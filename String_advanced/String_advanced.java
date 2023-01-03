// 1108. Defanging an IP Address

class Solution {
    public String defangIPaddr(String ad) {
        
        // String arr[]=ad.split('.');

        // StringBuilder str=new StringBuilder();
        
        // for(int i=0;i<arr.length;i++){
        // 	str.append(arr[i]);
        // 	str.append("[.]");
        // }
    	List<String> list=new ArrayList<>();
    	for(int i=0;i<ad.length;i++){
    		if(ad.charAt(i)=="."){
    			list.add("[.]");
    		}else{
    			list.add(ad.charAt(i)+"");
    		}
    	}
        return list.toString();
    }
}

// 6. Zigzag Conversion

class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows<=1) return s;

        StringBuilder[] sbs=new StringBuilder[numRows+1];

        for(int i=0;i<numRows;i++) sbs[i]=new StringBuilder();

        int idx=0;
        int dir=-1;

        char arr[]=s.toCharArray();

        for(char c: arr){
            sbs[idx].append(c);
            if(idx==0 || idx==numRows-1) dir=-dir;
            idx+=dir;
        }

        StringBuilder sb=new StringBuilder();
        for(StringBuilder s: sbs){
            sb.append(s);
        }
        return sb.toString();
    }
}

// 151. Reverse Words in a String


class Solution {
    public String reverseWords(String s) {
        String arr[]=s.split(" ");
        int n=arr.length;
        int i=0;
        int j=n-1;
        
        StringBuilder str=new StringBuilder();

       for(String s: arr){
            str.append(s);
       }

        return str.toString();
    }
}
// 

class Solution {
    public String reverseWords(String s) {
        String res="";
         int n=arr.length;
         for(int i=0;i<n;i++){
            String curr="";

            while(i<n && s.charAt(i)!=' '){
                curr+=s.charAt(i);
                i++;
            }
            if(curr.length()>0){
                res=(curr)+(res.length()==0?"":" ")+res;
            }

         }

         return res;
    }
}