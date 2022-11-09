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