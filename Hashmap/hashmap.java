 //leetcode 560. Subarray Sum Equals K  
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int count=0;
        int n=nums.length;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}
 // leetcode 1497. Check If Array Pairs Are Divisible by k
class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int n: arr){
            int rem=n%k;
            if(rem<0) rem+=k;
            
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        for(int r: map.keySet()){
            if(r == 0){ 
                if(map.get(r) % 2 != 0) return false;
            } 
            else if(r * 2 == k){
                if(map.get(r) % 2 != 0) return false;
            }
            
            else{
                int c1=map.get(r);
                int c2=map.getOrDefault(k-r,0);
                
                if(c1!=c2) return false;
            }
        }
        
        return true;
    }
}
 

 // leetcode 525. Contiguous Array
class Solution {
    public int findMaxLength(int[] nums) {
//         map<sum,index>
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum-=1;
            }else{
                sum+=1;
            }
            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
             
        }
        return max;
    }
}


// leetcode 76. Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {
//  make Frequency map 
        String ans="";
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        
        int mct=0;
        int dmct=t.length();
        HashMap<Character,Integer> map1=new HashMap<>();
        
        int j=-1;
        int i=-1;
        while(true){
            boolean flag1=true;
            boolean flag2=true;
//             aquire
            
            while(i<s.length()-1 && mct<dmct){
                i++;
                flag1=false;
                char ch=s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
                    mct++;
                }
                
            }
//             collect ans and remove
            
            while(j<i  && mct==dmct){
                flag2=false;
                String pans=s.substring(j+1,i+1);
                if(ans.length()==0 || ans.length()>pans.length()){
                    ans=s.substring(j+1,i+1);
                }
                j++;
                char ch=s.charAt(j);
                if(map1.get(ch)==1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch )-1);    
                }
                
                
                if( map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0)){
                    mct--;
                }
            }
            
            if(flag1 && flag2 ) break;
        }
        
        return ans;
    }
}

// count of substring having all non repeated character

    public static int solution(String s) {
        HashMap<Character , Integer> map=new HashMap<>();

        int j=0;
        int i=0;
        int ans=0;
        while(j<s.length()){
            char ch=s.charAt(j);
// acquire 
            if(map.containsKey(ch)){
                while(map.containsKey(ch)){
                    map.remove(s.charAt(i++));
                }
            }else{// collect ans and move further until repeated found 
                map.put(ch,1);
                ans+=(j-i+1);
                j++;
            } 
        }
        
        return ans;
    } 

    // longest Substring with exactly k unique charcter - gfg

    class Solution {
    
     public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
         int max=-1;

         for(int i=0,j=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(map.size()==k){
                max=Math.max(max,(i-j+1));
            }else{
                while(map.size()>k){
                    char c=s.charAt(j);
                     int count=map.get(c);
                    if(count==1) map.remove(c);
                    else map.put(c,map.get(c)-1);
                    
                    j++;
                }
            }
         }
         return max;
        }
    }

 //Count Of Substrings With Exactly K Unique Characters- gfg

    public static int solution(String s, int k){
        // write your code here

      HashMap<Character,Integer> map=new HashMap<>();
      int ans=0;
       
      for(int i=0,j=0;i<s.length();i++){
          char ch=s.charAt(i);
          map.put(ch,map.getOrDefault(ch,0)+1);
          if(map.size()==k){
              ans++;
          }else{
              while(map.size()>k){
                  char c=s.charAt(i++);
                  
                  int count=map.get(c);
                  if(count==1) map.remove(c);
                  else{
                      map.put(c,map.get(c)-1);
                  }
              }
          }
      }
      return ans;
    } 
    // 1248. Count Number of Nice Subarrays

    class Solution {
    public int count(int []nums,int k){
        int i=0;
        int j=0;
        
        int res=0;
        int odd=0;
        
        while(j<nums.length){
            if(nums[j]%2!=0){
                odd++;
            }
            while(i<=j && odd>k){
                if(nums[i]%2!=0){
                    odd--;
                }
                i++;
            }
            res+=(j-i+1);
            j++;
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums,k)-count(nums,k-1);
    }
}

// gfg- > Equivalent SubArray

class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        HashSet<Integer> set=new HashSet<>();
        for(int i:arr){
            set.add(i);
        }

        int size=set.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        int diff=0;
        int ans=0;
        int i=0,j=0;
        while(j<arr.length){
            // acqiure
               if(!map.containsKey(arr[j])){
                  diff++;
               } 
               map.put(arr[j],map.getOrDefault(arr[j],0)+1);

               while(i<=j && diff==size){
                  ans+=((n-1)-j+1);
                  int count=map.get(arr[i]);
                  if(count==1){
                    map.remove(arr[i]);
                    diff--;
                  }else{
                    map.put(arr[i],map.get(arr[i])-1);
                  }
                  i++;
               }
              j++;
        }
       return ans; 

    }
}


//lintcode  883 · Max Consecutive Ones II

public class Solution {
     
    public int findMaxConsecutiveOnes(int[] nums) {
         
         
         int zero=0;

         int j=0,i=0;
         int max=0;
         while(j<nums.length){
             if(nums[j]==0){
                 zero++;
             }
             if(zero<=1){
                 max=Math.max((j-i+1),max);
             }else{
                 while(zero>1){
                     if(nums[i]==0){
                         zero--;
                     }
                     i++;
                 }
             }
             j++;
         }
         return max;
    }
}

//lintcode -> 386 · Longest Substring with At Most K Distinct Characters 


public class Solution {
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        HashMap<Character,Integer> map=new HashMap<>();

        int i=0;
        int j=0;
        int max=0;
        int uc=0;

        while(j<s.length()){
            char ch=s.charAt(j);
            
            if(!map.containsKey(ch)){
                uc++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(uc>k){
                char c=s.charAt(i);
                int count=map.get(c);
                if(count==1){
                    map.remove(c);
                    uc--;
                }else{
                    map.put(c,map.get(c)-1);
                }
                i++;
            }
            max=Math.max(max,(j-i+1));
            j++;
        }

        return max;
        
    }
}

// leetcode 1016 Binary String with Substring 


 public static  boolean compare(HashMap<Character,Integer> pmap, HashMap<Character,Integer> smap)
    {
          
            for(char key: smap.keySet()){
                 if(pmap.getOrDefault(key,0)!=smap.get(key)){
                     return false;
                 }
            }
            return true;
        
    }
    public static void findAnagrams(String s, String p) {
       HashMap<Character,Integer> pmap=new HashMap<>();
        HashMap<Character,Integer> smap=new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            char sh=s.charAt(i);
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);             
            smap.put(sh,smap.getOrDefault(sh,0)+1);
        }
        
        int i=0;
        int j=p.length();
        int cc=0;
        // List<Integer> ans=new ArrayList<>();
        String ans="";
        while(j<s.length()){
              
            if(compare(pmap,smap)==true){
                cc++;
                ans+=(j-p.length())+" ";
                // ans.add(j-p.length());
            }
             
            char sj=s.charAt(j); 
            smap.put(sj,smap.getOrDefault(sj,0)+1); 
            
            char si=s.charAt(j-p.length());
            int count=smap.get(si);
            if(count==1){
                smap.remove(si);
            }else{
                smap.put(si,smap.get(si)-1);
            }
            
            j++; 
        }
        
          
            if(compare(pmap,smap)){
                 cc++;
                ans+=(j-p.length())+" ";
                // ans.add(j-p.length());
            }
            
        
        
         System.out.println(cc+" ");
         System.out.print(ans+ " ");
        
    }

    // Check if two strings are k-anagrams or not -> gfg


class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
       if(s2.length()!=s1.length()) return false;
       HashMap<Character,Integer> map=new HashMap<>();
       
       
       for(int i=0;i<s1.length();i++){
         map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
       }
       for(int i=0;i<s2.length();i++){
           char ch=s2.charAt(i);
           
           if(map.getOrDefault(ch,0)>0){
               map.put(ch,map.get(ch)-1);
           } 
       }

       int count=0;

       for(Character key : map.keySet()){
          count+=map.get(key);
       }

        return (count<=k);
    }
}

// 49. Group Anagrams

class Solution {
    public HashMap<Character,Integer> Creat(String s){
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            map.put(c,map.getOrDefault(c,0)+1); 
        }
        
        return map;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> map=new HashMap<>();
        
        
        for(String s: strs){
            HashMap<Character,Integer> freq=Creat(s);
            
            if(map.containsKey(freq)){
                List<String > base=map.get(freq);
                base.add(s);
                map.put(freq,base);
            }else{
                map.put(freq,new ArrayList<>());
                List<String > base=map.get(freq);
                base.add(s);
                map.put(freq,base);
            }
        }
        
        List<List<String>> ans=new ArrayList<>();
        
        for(HashMap<Character,Integer> key : map.keySet()){
            
            ans.add(map.get(key));
            
        }
        
        return ans;
    }
}

// group shifted Strings

   public static  String findCode(String s){
          String ans="";

          for(int i=0;i<s.length()-1;i++){
              int val=(s.charAt(i)-s.charAt(i+1));
              if(val<0){
                  val=val+26;
              }
              ans+=val+"";
              ans+="#";
          }

          return ans;
    } 
    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
        
        HashMap<String ,ArrayList<String>> map=new HashMap<>();
        
        for(int i =0;i<strs.length;i++){
            String code=findCode(strs[i]);
            
            if(!map.containsKey(code)){
                ArrayList<String> base=new ArrayList<>();
                base.add(strs[i]);
                map.put(code,base);
            }else{
               
                ArrayList<String> base= map.get(code);
                base.add(strs[i]);
                map.put(code,base);
            }
            
        }

        ArrayList<ArrayList<String>> ans=new ArrayList<>();

        for(ArrayList<String> smallans: map.values()){
            ans.add(smallans);
        }

        return ans;
    }

    // leetcode 205. Isomorphic Strings

    class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length());
        HashMap<Character,Character> m1=new HashMap<>();
        HashMap<Character,Boolean>  m2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(m1.containsKey(ch)){
                if(map.get(ch)!=t.charAt(i)){
                   return false;
                }
            }else{
                if(m2.containsKey(t.charAt(i))){
                    if(m2.get(t.charAt(i))) return false;
                }
                m1.put(ch,t.charAt(i));
                m2.put(t.charAt(i),true);

            }
        }

        return true;
    }
}




// word pattern leetcode 
class Solution {
    public boolean wordPattern(String pattern, String s) {
        // pattern = "a   b   b   a   c", 
        // s =       "dog cat cat dog dog"
        String arr[]=s.split(" ");
        
        if(pattern.length()!=arr.length) return false;

        HashMap<Character,String> m1=new HashMap<>();
        HashMap<String , Boolean > m2=new HashMap<>();
        
        
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);

            if(m1.containsKey(ch)){
// check if position in string arr is same as value

                if(!m1.get(ch).equals(arr[i])) return false;
            }else{
                
                if(m2.containsKey(arr[i])){
                    return false;
                }

                m1.put(ch,arr[i]);
                m2.put(arr[i],true);
            }
        }


        return true;


    }
}