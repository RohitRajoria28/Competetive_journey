// q1  6184. Count Days Spent Together

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String alarive[]=arriveAlice.split('-');
        String alleave[]=leaveAlice.split('-');
     	String bba[]=arriveBob.split('-');
     	String bbl[]=leaveBob.split('-');
// ------------Alice 
		// arriving month-day 
     	int ala[]=new int[2];
		// leaving month and day  
     	int alv[]=new int[2];


     	ala[0]=Integer.parseInt(alarive[0]);
     	ala[1]=Integer.parseInt(alarive[1]);

     	
     	alv[0]=Integer.parseInt(alleave[0]);
     	alv[1]=Integer.parseInt(alleave[1]);


		// ---------BOB

     	// ariving month-day 
     	int bbav[]=new int[2];
     	// leavng month-day
     	int bblv[]=new int[2];

     	bbav[0]=Integer.parseInt(bba[0]);
     	bbav[1]=Integer.parseInt(bba[1]);

     	bblv[0]=Integer.parseInt(bbl[0]);
     	bblv[0]=Integer.parseInt(bbl[1]);






     	int months[]=[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];



      	HashSet<Integer,Integer> map=new HashMap<>();
      	if(ala[0]==alv[0]){
      		int month=alv[0];
      		int days=months[i-1];
      		int st=ala[1];
      		int end=alv[1];

      		for(int i=st;i<=end;i++){
      			map.put(month,i);
      		}
      	}else{
      		int stm=ala[0];
      		int alm=alv[0];

      		for(int i=stm;i<=alm;i++){
      			int days=months[i-1];
      			if(i==alm){
      				int leaveDate=alv[1];
      				for(int j=1;j<=leaveDate;j++){
      					map.put(i,j);
      				}
      			}else{
      				for(int j=1;j<=days;j++){
      				map.put(i,j);
      			    }
      			}
      		}

      	}
      	int ans=0;

      // 	// ariving month-day 
     	// int bbav[]=new int[2];
     	// // leavng month-day
     	// int bblv[]=new int[2];

      	if(alv[0]>=bbav[0] && bbav[0]==bblv[0] ){
      		int month=bbav[0];
      		int days=months[i-1];
      		int st=bbav[1];
      		int end=bblv[1];

      		for(int i=st;i<=end;i++){
      			if(map.contains())
      		}
      	}else if(alv[0]>=bbav[0]){
      		int stm=ala[0];
      		int alm=alv[0];

      		for(int i=stm;i<=alm;i++){
      			int days=months[i-1];
      			if(i==alm){
      				int leaveDate=alv[1];
      				for(int j=1;j<=leaveDate;j++){
      					map.put(i,j);
      				}
      			}else{
      				for(int j=1;j<=days;j++){
      				map.put(i,j);
      			    }
      			}
      		}
      	}

    }
}

// q2

class Solution {
    public int matchPlayersAndTrainers(int[] parr, int[] tarr) {
        
        Arrays.sort(parr);
        Arrays.sort(tarr);

        int pn=parr.length;
        int tn=tarr.length;
        int ans=0;
        int j=tn-1;
        for(int i=pn-1;i>=0;i--){
        	int player=parr[i];
        	 
			if(j>=0 && tarr[j]>=player){
				ans+=1;	
				j--;
			}else if(j>=0 && tarr[j]<player){
				continue;
			} 
        	 
        }

        return ans;
    }
}

// 

class Solution {
    public int[] smallestSubarrays(int[] nums) {
    	int n=nums.length;
 		int ans[]=new int[nums.length];       
    
 		for(int i=0;i<n;i++){
 			int max=-1;
 			int mlen=1;
 			int val1=nums[i];
 			for(int j=i+1;j<n;j++){
 				int val2=nums[j];

 				if((val1 | val2)> max){
 					mlen=Math.max(mlen,j-i+1);
 					max=(val1 | val2);
 				}
 			}

 			ans[i]=mlen;
 		}


 		return ans;
    }
}