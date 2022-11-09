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

//leetcode  992. Subarrays with K Different Integers

class Solution {
    public int helper(int nums[],int k ){
        // HashMap<Integer,Integer> count=new HashMap<>();
        int n=nums.length;
        int j=0;
        int total=0;
        int diff=0;
        int count[]=new int[20001];
        for(int i=0;i<n;i++){
            if(count[nums[i]]==0){
                diff++;
                count[nums[i]]++;
            }else{ 
                count[nums[i]]++;

            }
            
            if(diff<=k){
                total+=(i-j+1);
            }else{
                while(j<n && j<=i && diff>k){
                    count[nums[j]]--;

                    if(count[nums[j]]==0){
                        diff--;
                    }
                    j++;
                }
                total+=(i-j+1);
            }
        }
        
        return total;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
         return (helper(nums,k)-helper(nums,k-1));
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
// leetcode 1081  Smallest Subsequence of Distinct Characters

class Solution {
    public String smallestSubsequence(String s) {
        int last[]=new int[26];
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            last[ch-'a']=i;
        }
        boolean seen[]=new boolean[26];
        Stack<Integer> st=new Stack();
        
        for(int i=0;i<s.length();i++){
           int curr=s.charAt(i)-'a';
            
            if(seen[curr]) continue;
            
            while(!st.isEmpty() && curr<st.peek() && i<last[st.peek()]){
                seen[st.pop()]=false;
            }
            st.push(curr);
            seen[curr]=true;
        }
        
        StringBuilder str=new StringBuilder();
         while(!st.isEmpty()){
            str.append((char)(st.pop()+'a'));
        }
        
        return str.reverse().toString();
    }
}
// leetcode 3   Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        
        int i=0;
        int j=0;
        int max=0;
        
        while(j<s.length()){
            char ch=s.charAt(j); 
            if(set.contains(ch)){
                set.remove(s.charAt(i++));
            }else{ // if ch is not in set
                set.add(ch);
                j++;
                max=Math.max(max,j-i);
            }
        }
        
        return max;
    }
}

//leetcode  1248. Count Number of Nice Subarrays
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
// leetcode 485. Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;
       int count=0;
      for(int i:nums){
        if(i==1){
          count++;
        }
        if(i==0){
          count=0;
        }
        maxCount=Math.max(count,maxCount);
      }
      return maxCount;
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

class Solution {
    public boolean queryString(String s, int n) {
        for(int i=1;i<=n;i++){
            String binary=Integer.toBinaryString(i);
            if(!s.contains(binary)) return false;
        }
        
        return true;
    }
}


// 

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

// leetcode 974. Subarray Sums Divisible by K

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;


        for(int e:nums){
            int sum+=e;

            int rem=sum%k;

            if(map.containsKey(rem)){
                ans+=map.get(rem);
            }

            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        return ans;
 
    }
}

// Longest subarray with sum divisible by K -> gfg 

class Solution{
    int longSubarrWthSumDivByK(int nums[], int n, int k)
    {
         int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int ans=0;


        for(int i=0;i<nums.length;i++){
            
            int e=nums[i];
             sum+=e;

            int rem=sum%k;

            if(rem<0) rem+=k;

            if(map.containsKey(rem)){
                
                ans=Math.max(ans,(i-map.get(rem)));
            }else{
                map.put(rem,i);
            }
            
            
            
        } 
        return ans; 
    }
 
}

// longest subarray with equal number of 0s 1s 


class Solution {
 
    int maxLen(int[] arr, int N)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i]==0?-1:1;

            if(sum==0){
                ans=Math.max(ans,(i-map.get(0)));
            }

        }

        return ans;
     
    }
}


// count subarray with equal 1s 0s

class Solution
{
     
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
         HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        map.put(0,1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i]==0?-1:1;

            if(map.containsKey(sum)){
                ans+=map.get(sum);
                map.put(sum,map.get(sum)+1);
            }else{
               map.put(sum,1);
            }


        }

        return ans;
    }
}

// longest subarray with equal number of 0s 1s 2s
    public static  String findCode(int []arr){
        String ans="";

        ans+=(arr[1]-arr[0])+"#"+(arr[2]-arr[1])+"";

        return ans;

    }
    public static int solution(int[] arr) {
        HashMap<String , Integer> map=new HashMap<>();
        int count[]=new int[3];
        map.put("0#0",-1);
        int ans=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==0) count[0]++;
            else if(arr[i]==1) count[1]++;
            else count[2]++;


            String code=findCode(count);

            if(map.containsKey(code)){
                ans=Math.max(ans,i-map.get(code));
            }else{
                map.put(code,i);
            }
        }



        return ans;
    }
    

// count  of subarrays with equal number of 0s 1s 2s -> gfg
    
class Solution 
{ 
    public String findCode(int []arr){
        String ans="";

        ans+=(arr[1]-arr[0])+"#"+(arr[2]-arr[1])+"";

        return ans;

    }
    long getSubstringWithEqual012(String str) 
    { 
        int arr[]=new int[str.length()];
        
        for(int i=0;i<str.length();i++){
            int val=str.charAt(i)-'0';
            arr[i]=val;
        }
        HashMap<String , Integer> map=new HashMap<>();
        int count[]=new int[3];
        map.put("0#0",1);
        int ans=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==0) count[0]++;
            else if(arr[i]==1) count[1]++;
            else count[2]++;


            String code=findCode(count);

            if(map.containsKey(code)){
                ans+=map.get(code);
                map.put(code,map.get(code)+1);
            }else{
                map.put(code,1);
            }
        }
        return ans;
    }
} 


// HashMap Day 7

// leetcode 781 Rabbits in Forest
class Solution {
    public int numRabbits(int[] ans ) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int v:ans){
            map.put(v,map.getOrDefault(v,0)+1);
        }
        int anss=0;
        for(int key: map.keySet()){
            int group=key+1;
            int count=map.get(key);
            double val=(count*1.0/group*1.0);
            int ceil=(int)Math.ceil(val);
            
            anss+=(group*ceil);
        }
        
        return anss;
    }
}
// 

// leetcode 954 Array of Doubled Pairs

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length%2!=0 || arr.length==0 ) return false;
        
        
        HashMap<Integer,Integer> map=new HashMap<>();
        Integer ar[]=new Integer[arr.length];
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1); 
            ar[i]=arr[i];
        }
        
        Arrays.sort(ar,(a,b)->{
            return Math.abs(a)-Math.abs(b);
        });
        
         for(Integer ele: ar){
             if(map.get(ele)==0) continue;
             
             if(map.getOrDefault(2*ele,0)==0) return false;
             
             map.put(ele,map.get(ele)-1);
             map.put(2*ele,map.get(2*ele)-1);

         }
        
        return true;
    }
}

// leetcode 1502 check arithmetic sequence 


class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        HashSet<Integer> map=new HashSet<>();
        
        int min=(int)1e9;
        int max=-(int)1e9;
        
        for(int i:arr){
            min=Math.min(min,i);
            max=Math.max(max,i);
            
            if(map.contains(i) ) return false;
            map.add(i);
        }
        int n=arr.length;
        int d=(max-min)/(n-1);
        
        for(int i=0;i<n;i++){
            int val=min+i*d;
            if(!map.contains(val)) return false;
        }
        return true;
    }
}

// GFG ->   Smallest subarray with all occurrences of a most frequent element


class Solution{
    
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> sidx=new HashMap<>();

        int si=0;
        int ei=0;
        int hfreq=0;
        int  len=(ei-si+1);

        for(int i =0;i<a.length;i++){
            if(map.containsKey(a[i])){
               map.put(a[i],map.get(a[i])+1);
            }else{
                map.put(a[i],1);
                sidx.put(a[i],i);
            }

            if(map.get(a[i])>hfreq){
                si=sidx.get(a[i]); 
                ei=i;
                len=(ei-si+1);
                hfreq=map.get(a[i]);
            }else if(map.get(a[i])==hfreq){
                int clen=i-sidx.get(a[i])+1;
                if(clen<len ){
                     hfreq=map.get(a[i]);
                    si=sidx.get(a[i]); 
                    ei=i;
                    len=(ei-si+1);
                }
            }
        }
        

        ArrayList<Integer> ans=new ArrayList();

        for(int i=si;i<=ei;i++){
            ans.add(a[i]);
        }
        return ans;

    }
  
}


// task Completetion


public static void completeTask(int n, int m, int[] arr) {
         boolean p1=true;
         boolean p2=false;
         
         List<Integer> a1=new ArrayList<>();
         List<Integer> a2=new ArrayList<>();
         HashSet<Integer> set=new HashSet<>();
         
         for(int e: arr){
            set.add(e);    
         }
         
         for(int i=1;i<=n;i++){
             if(set.contains(i)) continue;
             
             if(p1){
                 a1.add(i);
                 p1=false;
                 p2=true;
             }else if(p2){
                 a2.add(i);
                 p1=true;
                 p2=false;
             }
         }
         
         for(int e:a1){
             System.out.print(e+" ");
         }
         System.out.println();
         for(int e:a2){
             System.out.print(e+" ");
         }

    }


// 

    class Solution {
        int countPairs(int mat1[][], int mat2[][], int n, int x) {
           HashSet<Integer> set=new HashSet<>();

           for(int a[]:mat1){
            for(int e:a){
                set.add(e);
            }
           }  

           int count=0;


           for(int a[]:mat1){
            for(int e:a){
                
                if(e && set.contains(Math.abs(e-x))){
                    count++;
                }
            }
           } 

           return count;
        }
    }


    //leetcode  454. 4Sum II


    class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();
        
        HashMap<Integer,Integer> set=new HashMap<>();
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int val=nums1[i]+nums2[j];
                arr1.add(val);
                set.put(val,set.getOrDefault(val,0)+1);
            }
        }
        
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int val=nums3[i]+nums4[j];
                arr2.add(val);                
            }
        }
        int count=0;
        for(int e: arr2){
              
                count+=set.getOrDefault(-e,0);
            
        }
        
        return count;
         
    }
}

// leetcode 970. Powerful Integers

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=1;i<bound;i*=x){
            for(int j=1;i+j<=bound;j*=y){
                set.add(i+j);
                if(y==1) break;
            }
            if(x==1) break;
        }
    }
}

// leetcode 811. Subdomain Visit Count

class Solution {
    public List<String> subdomainVisits(String[] dom) {
        HashMap<String,Integer> map=new HashMap<>();
        
        for(String s:dom){
            String []temp=s.split(" ");
            int count=Integer.parseInt(temp[0]);
            String []words=temp[1].split("\\.");
            
            StringBuilder st=new StringBuilder();
            for(int i=words.length-1;i>=0;i--){
              
                if(i==words.length-1){
                    st.append(words[i]);
                }else{
                    st.insert(0,".");
                    st.insert(0,words[i]);
                }
                String str=st.toString();
                 map.put(str,map.getOrDefault(str,0)+count);
                 System.out.print(str+" "+map.get(str)+" ");
            }
        }
        
        
        
        
        List<String> ans=new ArrayList<>();
        
        for(String key:map.keySet()){
            String str=map.get(key)+" "+key+"";
           
            ans.add(str);
        }
        
        return ans;
    }
}


// leetcode 387. First Unique Character in a String

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,int[]> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int []ar=map.getOrDefault(c,new int[2]);
            ar[0]+=1; // frequency
            ar[1]=i; //first index
            map.put(c,ar);
        }
        
        int ansidx=1000000;
        for(char key:map.keySet()){
            int ar[]=map.get(key);
            
            if(ar[0]==1){
                ansidx=Math.min(ansidx,ar[1]);
            }
        }
        
        return ansidx==1000000?-1:ansidx;
    }
} 
// Leetcode lru
class LRUCache {
    class Node{
        int value;
        Node prev,next;
    }
    
    Node head;
    Node tail;
    
    HashMap<Integer,Node> map;
    int cap;
    int size=0;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        cap=capacity;
        head=new Node();
        tail=new Node();
       
        head.next=tail
        tail.prev=head;
    }
    
    public void addFirst(Node node){
        Node nbr=head.next;
        
        head.next=null;
        nbr.prev=null;
        
        node.next=nbr;
        node.prev=head;
        head.next=node;
        nbr.prev=node;
        size++;
    }
    
    public void remove(Node node){
        Node prev=node.prev;
        Node nbr=node.next;
        
        node.next=null;
        node.prev=null;
        head.next=nbr;
        nbr.prev=prev;
        size--;
        
        
    }
    
    public void moveTofirst(Node node){
        remove(node);
        addFirst(node);
    }
    
    
    
    public int get(int key) {
        if(!map.containsKey(key)){
           return -1;
        }else{
           int val=map.get(key).value;
           moveTofirst(map.get(key));
           return val;
        }

    }
    
    public void put(int key, int value) {
        Node node=map.get(key);
        if(node==null){
            Node newNode=new Node();
            newNode.value=value;
            newNode.key=key;
            
            if(size==cap){
                Node lru=tail.prev;
                remove(lru);
            }
            
            map.put(key,newNode);
        }else{
            Node rnode=map.put(key);
            rnode.value=value;
            map.put(key,rnode);
            moveTofirst(rnode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// leetcode 914. X of a Kind in a Deck of Cards

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length==1) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int e: deck){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        
        int ans=0;
        
        for(int key:map.keySet()){
            ans=gcd(ans,map.get(key));
        }
        if(ans<2) return false; 
        return true;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        
        return gcd(b,a%b);
    }
}

// leetcode 554. Brick Wall 

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n=wall.size();
        int sum=0;
        int tempsum=0;
        
        for(List<Integer> list: wall){
            for(int e: list){
                tempsum+=e;
            }
            break;
        }
        System.out.print(tempsum+": temps");
        HashMap<Integer,Integer> map=new HashMap<>();
        for(List<Integer> list:wall){
            sum=0;
            for(int i=0;i<list.size();i++){
                sum+=list.get(i);
                if( sum!=tempsum){
                  map.put(sum,map.getOrDefault(sum,0)+1);
                }  
            }
        }
        int maxf=0;
        for(int key: map.keySet()){
            int freq=map.get(key);
            if(freq>maxf){
                maxf=freq;
            }
        }
        System.out.print(maxf+" ");
        
        return n-maxf;
    }
}

// leetcode 895. Maximum Frequency Stack

class FreqStack {
    HashMap<Integer,LinkedList<Integer>> map;
    HashMap<Integer,Integer> freq;

    int maxf;

    public FreqStack() {
        map=new HashMap<>();
        freq=new HashMap<>();
        maxf=0;
    }
    
    public void push(int val) {
        int cf=freq.getOrDefault(val,0)+1;
        freq.put(val,cf);
        
        if(!map.containsKey(cf)){
            map.put(cf,new LinkedList<>());
        }
        
        map.get(cf).addFirst(val);
        
        maxf=Math.max(cf,maxf);
         
    }
    
    public int pop() {
        int ans=map.get(maxf).removeFirst();

        
        
        int cfreq=freq.get(ans);
        cfreq--;
        freq.put(ans,cfreq);
         
        

        if(map.get(maxf).size()==0){
            map.remove(maxf);
            maxf--;
        } 
        return ans;
    }
}

 // leetcode 218. The Skyline Problem

 class Solution {

    public List<List<Integer>> getSkyline(int[][] arr) {
        List<pair> list=new ArrayList<>();

        for(int []a : arr){
            int st=a[0];
            int ed=a[1];
            int ht=a[2];

            list.add(new pair(st,-ht));
            list.add(new pair(ed,ht));
        } 

        Collections.sort(list);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseorder());
        List<List<Integer>> ans=new ArrayList<>();
        int cht=0;
        for(int i=0;i<list.size();i++){
            pair p=list.get(i);
            int x=p.x;
            int ht=p.ht;

            if(ht<0){
               pq.add(-ht);
            }else{
               pq.remove(ht);
            }

            if(cht!=pq.peek()){
                List<Integer> smallans=new ArrayList<>();
                smallans.add(x);
                smallans.add(pq.peek());

                ans.add(smallans);
                cht=pq.peek();
            }
        }

        return ans;

    }

    public class pair implements Comparable<pair>{
        int x;
        int ht;
        pair(int x,int ht){
            this.x=x;
            this.ht=ht;
        }

        #Override
        public int compareTo(pair o){
            if(this.x!=o.x){
                return this.x-o.x;
            }else{
                return this.ht-o.ht;
            }
        }
    }
    
}

// leetcode 380. Insert Delete GetRandom O(1)

class RandomizedSet {
    
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        r=new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
           return false;
        }

        map.put(val,list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int ridx=map.get(val);
        map.remove(val);

        if(ridx=list.size()-1){
            list.remove(list.size()-1);
            return true;
        } 
            list.set(list.get(ridx),list.get(list.size()-1));
            list.remove(list.size()-1);

            map.put(list.get(ridx),ridx);
         

       
       return true;


    }
    
    public int getRandom() {
        int ridx=r.nextInt(list.size());

        return list.get(ridx);
    }
}

// leetcode 381 Insert , Delete , Getrandom 
class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> map ;
    Random r;
    List<Integer> list=new ArrayList<>();
    public RandomizedCollection() {
        map=new HashMap<>();
        r=new Random();
    }
    
    public boolean insert(int val) {
         HashSet<Integer> set;
         boolean flag;
         if(map.containsKey(val)){
            
            set=map.get(val);

            flag=false;
         }else{
            set=new HashSet<>();
            flag=true;
         }

            set.add(list.size());
            list.add(val);
            map.put(val,set);


            return flag;

     }
    
    public boolean remove(int val) {
         HashSet<Integer> set;
         boolean flag ;
         if(!map.containsKey(val)){
            return false;
         } 

         set=map.get(val);

         int ridx=-1;
         for(int i:set){
            ridx=i;
            break;
         }
         
         set.remove(ridx);
        map.put(val,set);
         if(map.get(val).size()==0){
             map.remove(val);
         }


         if(ridx==list.size()-1){
             list.remove(list.size()-1);
         }else{
             list.set(ridx,list.get(list.size()-1));
             list.remove(list.size()-1);
            
            int newval=list.get(ridx);
             

             
            HashSet<Integer> rset=map.get(newval);
            rset.remove(list.size());
            rset.add(ridx);
            map.put(newval,rset);
         }

         return true;

    }
    
    public int getRandom() {
        int idx=r.nextInt(list.size());

        return list.get(idx);
    }
}

// leetcode 710. Random Pick with Blacklist


class Solution {
    HashMap<Integer,Integer> map;
    int top;
    Random r;
    HashSet<Integer> set;
    public Solution(int n, int[] blacklist) {
        map=new HashMap<>();
        set=new HashSet<>();
        top=n-blacklist.length;
        r=new Random();

        for(int e:blacklist){
            set.add(e);
        }
        int idx=n;
        idx--;
        for(int e: blacklist){
            if(e<top){
                
                while(set.contains(idx)){
                    idx--;
                }
                map.put(e,idx);
                idx--;
            }
        }

    }
    
    public int pick() {
        int ridx=r.nextInt(top);

        if(map.containsKey(ridx)){
            return map.get(ridx);
        }

        return ridx;

    }
}

// leetcode 1488. Avoid Flood in The City
 class Solution {

    public int[] avoidFlood(int[] rains) {
         HashMap<Integer,Integer> map=new HashMap<>();
         TreeSet<Integer> set=new TreeSet<>();

         int ans[]=new int[rains.length];

         for(int i=0;i<rains.length;i++){
            int lake=rains[i];

            if(lake==0){
                ans[i]=1;
                set.add(i);
            }else{
 //             lake present 
                if(map.containsKey(lake)){
                    Integer srinkDay=set.higher(map.get(lake));

                    if(srinkDay==null){
                        return new int[];
                    }
                     ans[srinkDay]=map.get(lake);
                     map.remove(lake);

                     ans[i]=-1;

               }else{
                   map.put(lake,i);
                   ans[i]=-1;
               }
            }
         }
    }
}

// gfg- > Pairs of Non Coinciding Points

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        HashMap<Integer,Integer> xmap=new HashMap<>();
        HashMap<Integer,Integer> ymap=new HashMap<>();
        HashMap<String,Integer> xymap=new HashMap<>();
        int sum=0;
        for(int i=0;i<N;i++){
           int x=X[i];
           int y=Y[i];

           String xy=""+x+"*"+y+"";

           int xfreq=xmap.getOrDefault(x,0);
           int yfreq=ymap.getOrDefault(y,0);
           int xyfreq=xymap.getOrDefault(xy,0);

           sum+=xfreq+yfreq-2*xyfreq;
            
            xmap.put(x,xfreq+1);
            ymap.put(y,yfreq+1);
            xymap.put(xy,xyfreq+1)

        }

        return sum;

    }
};

// lintcode line reflection


public class Solution {
     
    public boolean isReflected(int[][] arr) {
        HashMap<Long,Long> map=new HashMap<>();

        int min=(int)1e9;
        int max=-(int)1e9;

        for(int a[] : arr){
            min=Math.min(min,a[0]);
            max=Math.max(max,a[0]);

            Long xval=(long)a[0];
            long yval=(long)a[1];
            long v=xval*(int)1e8+yval;
            map.put(v,1L);
        }

        int mirror=min+max;
        for(int a[]:arr){
            int x=a[0];
            int y=a[1];

            Long xval=(long)(mirror-x);
            Long yval=(long)y;

            if(!map.containsKey(xval*(int)1e8+yval)){
                return false;
            }
        }

        return true;

    }
}
// lintcode Longest substring with 2 distinct character 
public class Solution {
 
    public int lengthOfLongestSubstringTwoDistinct(String s) {
         int len=0;

         HashMap<Character,Integer> map=new HashMap<>();

         int i=0;
         int j=0;
         int count=0;
         while(j<s.length()){
            char c=s.charAt(j);

            if(!map.containsKey(c)){
                count++;
            }

            map.put(c,map.getOrDefault(c,0)+1);
            while(count>2){
                char ch=s.charAt(i);

                int n=map.get(ch);
                if(n==1){
                    map.remove(ch);
                    count--;
                }else{
                    map.put(ch,n-1);
                }
                i++;
            }

            len=Math.max(len,j-i+1);
            j++;
         }

         return len;
    }
}

// lintcode Minimum cost to connect sticks 

public class Solution {
    
    public int minimumCost(List<Integer> sticks) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return a-b;
        });
        for(int e:sticks){
            pq.add(e);
        }
        
        int cost=0;
        while(pq.size()>1){
            int v1=pq.remove();
            int v2=pq.remove();
            int stick=(v1+v2);
            cost+=stick;
            pq.add(stick);
        }
        
        return cost;
     }
}


// gfg -> Ticky Sorting Cost

class Solution{
    static int sortingCost(int N, int arr[]){
        
        HashMap<Integer,Integer> map=new HashMap<>();

        int max=0;

        for(int e:arr){
            
            int len=0;
            if(map.containsKey(e-1)){
                len=map.get(e-1)+1;
                map.put(e,len);
            }else{
                map.put(e,1);
                len=1;
            }
            max=Math.max(len,max);

        }

        return N-max;
    }
}

// 

class Solution {
    
    public class pair{
        char ch;
        int f;
        
        pair(char ch,int f){
            this.ch=ch;
            this.f=f;
        }
    }
    public String reorganizeString(String s) {
        int map[]=new int[26];

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map[c-'a']++;
        }

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });

        for(int i=0;i<s.length();i++){
            int f=map[s.charAt(i)-'a'];

            if(f>0){
                pq.add(new pair(s.charAt(i),f));
            }
        }
        StringBuilder st=new StringBuilder();

        pair block=pq.poll();
        


    }
}


// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit


class Solution {
    public int longestSubarray(int[] nums, int lim) {
        TreeSet<Integer> set=new TreeSet<>();
        int n=nums.length;
        int i=0;
        int j=0;

        while(j<n){
            int val=nums[j];

            set.add(val);

            while(i<=j && set.last()-set.first() >lim) {
                int rem=nums[i];
                set.remove(rem);
                i++;
            }

            res=Math.max(res,(j-i+1));
            j++;
        }

        return res;
    }
}