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

// 

class Solution {
    int start=0;
    int max=1;
    public void oddevenpal(String s,int i,int j){
        if(i<0 || j>=s.length()) return ;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(max<(i-j+1)){
            max=(i-j+1);
            start=i;
        }
    }
    public String longestPalindrome(String s) {
         
         int n=s.length();
         for(int i=0;i<n;i++){
            oddevenpal(s,i-1,i+1); // odd length
            oddevenpal(s,i,i+1); // even length
         }

         return s.substring(start,start+max);
    }
}

// leetcode 13

class Solution {
    public int findVal(String s){
        int idx=0;
        while( idx<s.length() ){

            if(idx<s.length()-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                int minus=map.get(s.charAt(i));
                int cval=map.get(s.charAt(i+1));

                res+=(cval-minus);
                idx+=2;
            }else{
                int cval=map.get(s.charAt(i));
                res+=cval;
                idx++;
            }
        }
    }
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans=findVal(s);
    }
}