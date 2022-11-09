// 2062. Count Vowel Substrings of a String

class Solution {
	
	public boolean isVowel(String s){
		 
		 
		HashSet<Character> set=new HashSet<>();

		 

		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);

			if(c=='a' || c=='i' || c=='o' || c=='e' || c=='u'){
				set.add(c);
			}
		}
        // System.out.print((set.contains('a') && set.contains('e') && set.contains('i') && set.contains('o') && set.contains('u'))+" ");

		return (set.contains('a') && set.contains('e') && set.contains('i') && set.contains('o') && set.contains('u'));
	}
    public int countVowelSubstrings(String s) {
    	int n=s.length();
    	if(n<5) return 0;
        int ans=0;

         HashSet<Character> set=new HashSet<>();
         set.add('a') ;
          set.add('e') ;
           set.add('i'); 
            set.add('o');
              set.add('u');

         int i=0;
         int j=0;

         while(j<n){
         	char c=s.charAt(j);
         	char c2=s.charAt(i);
         	if(!set.contains(c)){
         		 
                
                while(i<j && (j-i)>=5 && set.contains(s.charAt(i))){
                    ans+=(isVowel(s.substring(i,j))?1:0);
                    set.remove(s.charAt(i));
                    i++;
                }
                 
                j++;
         		continue;
         	}

         	while(i<j && !set.contains(c2)){
         		i++;
         	}

         	if(j-i+1>=5){
         		ans+=(isVowel(s.substring(i,j+1))?1:0);
         	}
         	
         	j++;
         }
        
        return ans;
    }
}

// 

class Solution {
    public long countVowels(String s) {
    	int n=s.length;
    	int arr[]=new int[n];
    	HashSet<Character> set=new HashSet<>();
         set.add('a') ;
          set.add('e') ;
           set.add('i'); 
            set.add('o');
              set.add('u');


    	for(int i=0;i<n;i++){
    		char c=s.charAt(i);
    		if(set.contains(c)) arr[i]=1;
    	}
		
    	long ans=0;

		for(int i=0;i<n;i++){
			if(arr[i]==i){
				ans+=(i-0+1) + (n-i+1);
			}
		}    

		return ans;    
    }
}