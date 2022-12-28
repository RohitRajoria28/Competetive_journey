

// leetcode q1 

class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        if (tools[startIndex].equals(target)) {
		return 0;
		}
		int left = startIndex - 1, right = startIndex + 1, steps = 1;
		if (left < 0) {
			left = tools.length - 1;
		}
		if (right > tools.length - 1) {
			right = 0;
		}
		while (left >= 0 && left < tools.length && right >= 0 && right < tools.length) {
			if (tools[left].equals(target) || tools[right].equals(target)) {
				return steps
				break;
			}
			left--;
			if (left < 0) {
			 left = tools.length - 1;
			 }
				right++;
			if (right > tools.length - 1) {
			  right = 0;
			  }
			 steps++;
			 }
			return -1;
		}
}


// 

class Solution {
    public int takeCharacters(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        char car[] = s.toCharArray()
        int n=car.length;
        for(int i=0,j=n-1;i<n && j>=0 ; i++,j--){
        	char fr=car[i];
        	char end=car[j];
        	map.put(fr,map.getOrDefault(fr,0)+1);
        	map.put(end,map.getOrDefault(end,0)+1);


        	if(map.get('a')==k && map.get('b')==k && map.get('c')==k){
        		return (i+1)+(n-j+1);
        	}


        }
        return -1;
    }
}

class Solution {
    public int takeCharacters(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        char car[] = s.toCharArray();
        int n=car.length;
        for(int i=0,j=n-1;i<n && j>=0 && i<=j ; i++,j--){
        	char fr=car[i];
        	char end=car[j];
        	map.put(fr,map.getOrDefault(fr,0)+1);
        	map.put(end,map.getOrDefault(end,0)+1);


        	if(map.get('a')>=k && map.get('b')>=k && map.get('c')>=k){
        		return (i+1)+(n-j+1);
        	}


        }
        System.out.print( (map.get('a')+" ," +map.get('b')+ "  ," +map.get('c') ));
        return -1;
    }
}
//dp
class Solution {

	public int findABC(char arr[],int k,int ans[],int st,int end,HashMap<Character,Integer> map,int idx){
		
		if(st>=arr.length || end<0){
			if(map.get('a')>=k && map.get('b')>=k && map.get('c')>=k){
				return 1;
			}
			return ;
		}

		if(map.get('a')>=k && map.get('b')>=k && map.get('c')>=k){
			return 1;
		}

		 
		map.put(arr[idx],map.getOrDefault(arr[idx],0)+1);
		 
		int smallans=0;
		int a1=findABC(arr,k,ans[0]+1,st+1,end,map,st+1);
		int a2=findABC(arr,k,ans[0]+1,st,end-1,map,end-1);

		return Math.min(a1,a2);
	}
    public int takeCharacters(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int ans[]=new int[1];
         
       int a= findABC(s.toCharArray(),k,ans,0,n-1,map,0);

        if(map.get('a')>=k && map.get('b')>=k && map.get('c')>=k){
				return a;
		} 
		return -1;
    }
}


class Solution {
    public int closetTarget(String[] arr, String tar , int st) {

    	  
        if (arr[st].equals(tar)) {
		return 0;
		}
		 for(int i=1;i<6;i++){
		 	tt++;


		 }
		int lt = st - 1, rt = st + 1, steps = 1;



		if (lt < 0) {
			lt = arr.length - 1;
		}
		if (rt > arr.length - 1) {
			rt = 0;
		}
        int ans=0;
            boolean flag=false;
          
		while (lt >= 0 && lt < arr.length && rt >= 0 && rt < arr.length) {
			if (arr[lt].equals(tar) || arr[rt].equals(tar)) {
				ans=steps;
				flag=true;
                break;
			}
			lt--;



			if (lt < 0) {
			 lt = arr.length - 1;
			 }
				rt++;
			    if (rt > arr.length - 1) {
			   rt = 0;
			  }
            


            
            if(steps==arr.length) return -1;
			 steps++;
			 }
			return flag?ans:-1;
		}
}

// 

class Solution {
    public int takeCharacters(String s, int k) {
        int ca=0;
        int cb=0;
        int cc=0;

        char ch[]=s.toCharArray();

        for(char c: ch){
        	if(c=='a') ca++;
        	if(c=='b') cb++;
        	if(c=='c') cc++;
        }

        if(ca<k || cb<k || cc<k) return -1;
        int n=ch.length;
        int i=n-1;
        int j=n-1;
        int ans=100000;
        while(i>=0){
        	char c=ch[i];
            
        	if(c=='a') ca--;
        	if(c=='b') cb--;
        	if(c=='c') cc--;

        	while(ca<k || cb<k || cc<k ){
                char caa=ch[j];
        		if(caa-'a'==0) ca++;
	        	if(caa-'a'==1) cb++;
	        	if(caa-'a'==2) cc++;
	        	j--;
        	}
        	ans=Math.min(ans,i+n-1-j);
        	i--;
        }

        return ans;
    }
}