class Solution {
    public  String findDiff(String s){
        int n=s.length();
        int ans[]=new int[n-1];
        
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n-1;i++){
            ans[i]=s.charAt(i+1)-s.charAt(i);
                    

            str.append(ans[i]+"");
        }
        System.out.println(str);
        return str.toString();
    }
    public String oddString(String[] words) {
        
        HashMap<String,Integer> set=new HashSet<>();
        HashMap<String,String> kv=new HashMap<>();
        
        String [] arr=new String[words.length];
        
        for(String s: words){
           String st=findDiff(s);
            kv.put(st,s);
            map.put(st,map.getOrDefault(st,0)+1);
        }

         
         for(String stt: map.keySet()){
            if(map.get(stt)>1){
                map.remove(stt);
            }
         }
         
         System.out.print(map.size()+": size");
         for(String stt: map.keySet()){
             return kv.get(stt);
         }
         return words[0];
    }
}

// q2

class Solution {
    public boolean findDiff(String s,String []dictionary){
        for(String temp: dictionary){
            int count=0;
            for(int i=0;i<s.length();i++){

                if(s.charAt(i)!=temp.charAt(i)){
                    count++;
                }
            }
            if(count<=2) return true;
        }
        return false;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        
        List<String> list=new ArrayList<>();
        for(String s : queries){
            if(findDiff(s,dictionary)){
                list.add(s);
            }
        }

        return list;
    }
}




// Given n email addresses of different domains, please send an email to the first
 // address(in alphabetical order) of each domain. Please assume a function sendmail() to send the emails.

// Input Array = ['ghi@hotmail.com', 'def@yahoo.com', 'ghi@gmail.com', 'abc@channelier.com', 'abc@hotmail.com',
 // 'def@hotmail.com', 'abc@gmail.com', 'abc@yahoo.com', 'def@channelier.com','jkl@hotmail.com', 'ghi@yahoo.com', 
// 'def@gmail.com'].

// Expected Output - Below is the  order of address in which sendmail function is going to send mail.
//                                 abc@channelier.com
//                                 abc@yahoo.com
//                                 abc@gmail.com
//                                 abc@hotmail.com



import java.util.*;
import java.util.ArrayList;

    public static class pair {
            String ba;
            String aa;
            
            pair(String ba,String aa){
                this.ba=ba;
                this.aa=aa;
            }
    }
    public static String[] sendmail(String ar[]){
        String temp[][]=new String[ar.length][2];

        int idx=0;
        
        List<pair> list=new ArrayList<>();

        for(String s: ar){
            String tp[]=s.split("@");
            list.add(new pair(tp[0],tp[1]));
        }

        Collections.sort(list,(a,b)->{
            return a.aa.compareTo(b.aa);
        });


        String ans[]=new String[ar.length];

        for(int i=0;i<temp.length;i++){
            pair tpair=list.get(i);
            ans[i]=tpair.ba+"@"+tpair.aa;
        }

        return ans;
    }



    public static int findCount(int []arr){

        int sum=0;

        for(int i: arr){
            sum+=i;
        }
        int n=arr.length;
        int avg=sum/n;

        int ans=0;
        for(int i:arr){
            if(i==avg) ans++;
        }
        return ans;
    }


    public static double findAvg(int arr[]){
        int max=-1000000;
        int min=1000000;

        for(int i=0;i<arr.length;i++){
            min=Math.min(arr[i],min);
            max=Math.max(arr[i],max);

        }
        int count=0;
        int maxSum=0;
        int minSum=0;
        for(int i: arr){
            if(i==max){
                count++;
                 maxSum+=i;
            }
            if(i==min){
              minSum+=i;
              count++;  
            } 
        }

        return (double)(maxSum+minSum)/count;
    }

    // q3

    class Solution {
        public int findMaxTarget(int nums[], int sp,int pa){
            int count=0;

            for(int tar: nums){
                if(tar-pa < 0) continue;
                else{
                    if((tar-pa)%sp==0){
                        count++;
                    }
                }
            }
            return count;
        }
        public int destroyTargets(int[] nums, int space) {
            Arrays.sort(nums);

            int ans=100000000000;
            int maxt=-1;
            for(int pa: nums){
                int tfound=findMaxTarget(nums,space,pa);
                if(maxt<tfound && ans>pa){
                    ans=pa;
                    maxt=tfound;
                }
            }

            return ans;
        }
    } 


// 

    class Solution {
    public int destroyTargets(int[] nums, int space) {
            HashMap<Integer,Integer> map=new HashMap<>();

            for(int a : nums){
                map.put(a%space , map.getOrDefault(a%space,0)+1);
            }
            int maxc=Collections.max(map.values());
            int res=-1;
            for(int a : nums){
                if(map.get(a%space)==maxc){
                    res=Math.min(res,a);
                }
            }       

            return res;
    }
}

// q4 Next Greatest element 4

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n=nums.length;
        int ng[]=new int[n];

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        Stack<Integer> st=new Stack<>();
        ng[n-1]=-1;
        st.push(nums[n-1]);
        
        for(int i=n-2;i>=0;i--){
            int val=nums[i];
            while(!st.empty() && st.peek()<=nums[i]){
                st.pop();
            }
            if(st.empty()){
                ng[i]=-1;
            }else{
                ng[i]=st.peek();
            }

            st.push(nums[i]);
        }

        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=map.get(ng[i]);
        }

        return ans;
    }
}

// q2 Next greater 4

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.empty() && nums[st.peek()]<nums[i]){
                list.get(i).add(st.pop());
            }
            st.push(i);
        }
         
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        })
        int ans[]=new int[n]
        for(int i=0;i<n;i++){
            while(!pq.empty() && pq.peek()[0]<nums[i]){
                ans[pq.pop()[1]]=nums[i];
            }

            for(int j: list.get(i)){
                pq.add(new int[]{nums[j],j});
            }
        }

        return ans;
    }
} 

