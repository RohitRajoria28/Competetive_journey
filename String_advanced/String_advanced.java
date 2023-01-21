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

// 

class Solution {
    public int myAtoi(String s) {

        int sign=1;
        int i=0;
        int res=0;

        while(s.charAt(i)==' ') i++;

        if(s.charAt(i)=='-' || s.charAt(i)=='+') sign=(s.charAt(i)=='+'?1:-1);

        while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
            if(res>Integer.MAX_VALUE/10 || (res>Integer.MAX_VALUE/10 &&  s.charAt(i)-'0'>7))
            {
                return sign==1?Integer.MAX_VALUE?Integer.MIN_VALUE;
            }

            res=res*10+(c-'0');
                i++;
         }
         

        
        return  res;
    }
}

// 

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder st=new StringBuilder();

        int i=0;

        for(i=0;st.length()<b.length();i++){
            st.append(a);
            if(st.toString().contains(b)) return 1;
        }
        if(st.append(a).toString().contains(b)) return i;

        return -1;
    }
}

// 28. Find the Index of the First Occurrence in a String

class Solution {
    public int strStr(String s1, String s2) {
         if(s1.length()<s2.length()) return -1;

         for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(0)){
                int idx=0;
                while(i<s1.length() && idx<s2.length() && s1.charAt(i)==s2.charAt(idx)){
                    i++;
                    idx++;
                }

                if(idx+1==s2.length()) return i-idx;
            }
         }

         return -1;
    }
}

// ROBIN KARP METHOD STRING MATCING

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder st=new StringBuilder(a);
        int count=1;
        while(st.size()<b){
            st.append(a);
            count++;
        }

        if(searchStringByRobinKarpMethod(st.toString(),b)) return count;
        st.append(a);
        if(searchStringByRobinKarpMethod(st.toString(),b)) return count+1;


        return false;

    }

    public boolean searchStringByRobinKarpMethod(String txt,String pat){
        int p=0;
        int t=0;
        int d=256;
        h=0;
        int q=11;

        int m=pat.length();
        int n=txt.length();

        for(int i=0;i<m-1;i++){
            h=(h*d)%q;
        }

        for(int i=0;i<m;i++){
            p=(p*d+pat.charAt(i))%q;
            t=(t*d+txt.charAt(i))%q;
        }


        for(int i=0;i<n+m;i++){
            if(p==t){
                boolean flag=true;

                for(int j=0;j<m;j++){
                    if(txt.charAt(j+i)!=pat.charAt(j)){
                        flag=false;
                        break;
                    }
                }
                if(flag) return true;
            }

            if(i<n-m){
                t=(d*(t-h*txt.charAt(i))+txt.charAt(i+m))%q;
                if(t<0) t+=q;
            }
        }

        return false;
    }
}

//1312. Minimum Insertion Steps to Make a String Palindrome

class Solution {
    public int longestPalindromicSubsequence(String s,int i,int j,int [][]dp){
        int n=s.length();

        if(j<0 || i>=n ) return 0;

        if(dp[i][j] !=-1) return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=1+longestPalindromicSubsequence(s,i+1,j-1,dp);
        }else{

            dp[i][j]=Math.max(longestPalindromicSubsequence(s,i+1,j,dp),longestPalindromicSubsequence(s,i,j-1,dp));
        }

        return dp[i][j];
    }
    public int minInsertions(String s) {
        
        int n=s.length();

        int dp[][]=new int[n][n];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }

        return n-longestPalindromicSubsequence(s,0,n-1,dp);
    }
    
}    

// STRING ANDS

// q1

public class LongestWord {
    final static  String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final static String ALPHABET_UPPER = ALPHABET.toUpperCase();

    public static String LongestWord(String sen) {
        String[] words = sen.split("\\s");
        String longestWord = null;
        int longestWordLength = 0;

        for (String word : words) {
            int wordLength = getWordLength(word);
            if (longestWord == null || wordLength > longestWordLength) {
                longestWord = word;
                longestWordLength = wordLength;
            }
        }

        return longestWord;
    }

    int getWordLength(String str) {
        int length = 0;

        for (char c : str.toCharArray()) {
            if (ALPHABET.indexOf(c) > -1 || ALPHABET_UPPER.indexOf(c) > -1) {
                length++;
            }
        }
        return length;
    }

    // q2 UPPER-> lower

    final static String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String LOWER = UPPER.toLowerCase();

    public static String SwapCase(String str) {
        StringBuilder result = new StringBuilder("");

        for (char c : str.toCharArray()) {
            int index = UPPER.indexOf(c);
            if (index != -1) {
                result.append(LOWER.charAt(index));
            } else {
                index = LOWER.indexOf(c);

                if (index != -1) {
                    result.append(UPPER.charAt(index));
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    // q4

#include <iostream>
#include <string>
#include<stack>
using namespace std;

int RemoveBrackets(string str) {
  stack<char> list;

  for(int x=0;x<str.length();x++){
    if(str[x]=='('){
      list.push(str[x]);
    }else if(str[x]==')'){
      if(!list.empty() && list.top()=='('){
        list.pop();
      }else{
        list.push(str[x]);
      }
    }
  }
     
  return list.size();

}

int main(void) { 
   
  // keep this function call here
  cout << RemoveBrackets(coderbyteInternalStdinFunction(stdin));
  return 0;
    
}