// question 1

class Solution {
    public int minimumRecolors(String blocks, int k) {

        int ans=10000;
        int n=blocks.length;

        for(int i=0;i+k<=n;i++){
            int count=0;
            for(int j=i;j<i+k;j++){
                char c=blocks.charAt(j);
                if(c=='W'){
                    count++;
                }
            }
            ans=Math.min(count,ans);
        }

        // HashMap<Character,Integer> map=new HashMap<>();

        // int i=-1;
        // int j=0;
        // int n=blocks.lengt();
        // int bval=0;
        // int wval=0;
        // while(j<n){
        //     char c=blocks.charAt(j);
            
        //     if(c=='B'){
        //         map.put(c,map.getOrDefault(c,0)+1);
        //         bval=map.get('B');
        //     }else{
        //         // w
        //         map.put(c,map.getOrDefault(c,0)+1)
        //         wval=map.get('W');
        //     }


        //     if(bwal+wval==k){
        //         ans=Math.min(ans,map.get('W');
        //         i++;
        //     }
        //     if(i>=0) map.put(blocks.charAt(i),map.get(blocks.charAt(i))-1);
        //     j++;
        // }

        return ans;
    }
}

// q2

class Solution {
    public String countAns(String st,int count[],boolean flag[]){

        StringBuilder sn=new StringBuilder();
        flag[0]=false;
        for(int i=0;i<st.length-1;i+=2){
                int c1=st.charAt(i)-'0';
                int c2=st.charAt(i+1)-'0';

                if(c1==0 && c2==1){
                  count[0]++;
                  flag[0]=true;
                }  
                sn.append("10");  
        }
         
        return sn.toString();
    }
    public int secondsToRemoveOccurrences(String s) {
        int count[]=new int[1];
        boolean flag[]=new int[1];
        flag[0]=true;

        while(flag[0]){
            String str=countAns(s,count,flag);    
        }
        
        return count[0];
    }
}

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        

        boolean flag=true;
        
        while(flag){
            int count=0;
            String st=sp.toString();
            boolean ozp=false;
            String st=sb.toString();
            sb.setLength(0);
            for(int i=0;i<st.length-1;i+=2){
                int c1=st.charAt(i)-'0';
                int c2=st.charAt(i+1)-'0';

                if(c1==0 && c2==1){
                  count++;
                  ozp=true;
                  sn.append("10");  
                }else{
                  sn.append("10");    
                } 
            }

            StringBuilder sb=new StringBuilder(sn.toString());
            sn.setLength(0);
            if(ozp==false) flag=false;
        }

        return count;
           
    }
}