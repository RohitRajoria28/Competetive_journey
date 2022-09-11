//  q1

class Solution {
    public int mostFrequentEven(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>();
      int maxFreq=0;
      int ans=-1;
      for(int i: nums){
        map.put(i,map.getOrDefault(i,0)+1);
        int freq=map.get(i);
        if(i%2==0){
            if(maxFreq==freq){
                ans=Math.min(ans,i);
            }

            else if(maxFreq<freq){
                maxFreq=freq;
                ans=i;
            }
        }

      } 

      return ans; 
    }
}

// q2
// sliding window

class Solution {
    public int partitionString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=1;

        int i=0,j=0;
        int n=s.length();
        while(j<n){
            boolean flag=false;
            char c=s.charAt(j);
            
            
            while(i<=j  &&  map.containsKey(c)){
                
                char ch=s.charAt(i);
                
                int fre=map.get(ch);
                
                if(fre==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                flag=true;
                i++;
                
            }
            while(flag && i<j){
                char ch=s.charAt(i);
                
                int fre=map.get(ch);
                
                if(fre==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                 
                i++;
            }
             
             
            map.put(c,map.getOrDefault(c,0)+1);
             if(flag){
              
               ans++;  
             } 
            j++;
        }
        
        // if(map.size()>=1) ans++;

        return ans;
    }
}

//  


class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return a-b;
        });    


        for(int i=0;i<intervals.length;i++){
            int st=intervals[i][0];
            int end=intervals[i][1];

            if(pq.size()>0 && pq.peek()<st){
                pq.remove();
            }

             pq.add(end);

        }


        return pq.size();
    }
}