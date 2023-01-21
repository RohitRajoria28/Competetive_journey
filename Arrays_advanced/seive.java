	
// seive in first N numbers

	public static void findPrimeInRangeN(int n){
	    boolean seive[]= new boolean[n];

	    Arrays.fill(seive,true);
	    // seive[i]=true -> means prime
	    // i*i< n becouse we have to start the factors count from i*i and no need to count before that
	    
	    // complexity -> O(N(log(log(N))))

	    for(int i=2;i*i<n;i++){
	        if(seive[i]){
	            for(int j=i*i;j<n;j+=i){
	                seive[j]=false;
	            }
	        }
	    }
	    for(int i=2;i<seive.length;i++){
	        if(seive[i]){
	            System.out.print(i+" ");
	        }
	    }
	}


// https://www.spoj.com/problems/TDKPRIME/
// find Kth prime

	boolean seive[]= new boolean[86028122];
  	List<Integer> list=new ArrayList<>();
    public   void KthPrime( ){
        

        Arrays.fill(seive,true);
         
         
        for(int i=2;i*i<=86028121;i++){
            if(seive[i]){
                
                for(int j=i*i;j<=86028121;j+=i){
                    seive[j]=false;
                }
            }
        }
        
         for(int i=0;i<=86028121;i++){
            if(seive[i]){
                list.add(i);
            }
         }
    }

// How many numbers in a range (0,1000000) have minimum prime factor as P;
// constrains-> P is always a prime number;

 public static void findMinNumberPrime(int p){
            Arrays.fill(seive,1); 
           
            for(int i=2;i*i<=1000000;i++){

                if(seive[i]!=0){
                    for(int j=i*i;j<=1000000;j+=i){
                        seive[j]=0;
                        seive[i]+=1;

                    }                    
                }
            }

            System.out.println(seive[p] );
        }


// Prime Factorization in any Integer number
	 int n=1000000+1;
 	 int seive[]=new int[n];

    public   void findPrintPrimeFactor(int num){
        while(num!=1 ){
            int val=seive[num];
             if(val==0) {
                System.out.print(num+" ");    
                break;
             }
             num/=val;
            System.out.print(val+" ");    
        }
    }

    public   void findPrimeFactor( ){

        for(int i=2;i*i<n;i++){
            if(seive[i]==0){
                for(int j=i*i;j<n;j+=i){
                    if(seive[j]==0) seive[j]=i;
                }
            }
        } 
    }


//  SEGMENTED SEIVE -> VERY IMPORTANT

      boolean gseive[]=new boolean[1000000];

        public   void createSeive(){
            for(int i=0;i<1000000;i++){
                gseive[i]=true;
            }
            for(int i=2;i<1000000;i++){
                if(gseive[i]){
                    for(int j=i*i;j<1000000;j+=i){
                        gseive[j]=false;
                    }
                }
            }
        }
        public   void SegmentedSeive(int r,int l){
           
            // step1 - find factors till right range using seive black box
             ArrayList<Integer> plRange=findPrimeInRange(r);
            
             // step 2 - make array of (r-l+1) and mark all in range as true(prime)
            int n=r-l+1;
            boolean []seive=new boolean[n+1];

            for(int i=l;i<=r;i++){
                seive[i-l]=true;
            }
            // setp3- mark all the multiples of prime from step 1 false in range

            for(int pr: plRange){
                int firstElement=(l/pr)*pr;

                if(firstElement<l) firstElement+=pr;

                for(int i=Math.max(firstElement,pr*pr);i<=r;i+=pr){
                    seive[i-l]=false;
                }
            }
            //step - 4  print all the prime in range -> Your answer  
            for(int i=l;i<=r;i++){
                if(seive[i-l]){
                    System.out.print(i+" ");
                }
            } 
        }
        public   ArrayList<Integer> findPrimeInRange(int r){
             ArrayList<Integer> ans=new ArrayList<>();

             for(int i=2;i*i<r;i++){
                if(gseive[i]){
                    ans.add(i);
                }
             }
             return ans;
        }

// 

	class Solution {
		public int numPrimeArrangements(int n) {
		    int pr=0;

		    boolean pr[]=new int[n+1];
		    
		    Arrays.fill(pr,true);
		    int prime=0;
		    
		    for(int i=1;i*i<=n;i++){
		    	if(pr[i]==true){
		    		prime++;
		    		for(int j=i*i;j<=n;j+=i){
		    			pr[i]=false;
		    		}
		    	}
		    }

		    int res=1;

		    for(int i=2;i<=prime;i++){
		    	res*=(res*i);
		    }

		    for(int i=2;i<=n-prime;i++){
		    	res*=(res*i);
		    }

		    return res;
		}
	}

    // 


 

 //  CoderByte

#include <iostream>
#include <string>
#include <iomanip>
#include <sstream>
using namespace std;

#include <iostream>
#include <string>
#include <iomanip>
#include <sstream>
using namespace std;

 
double timeDifference(string currentEvent, string nextEvent, string time1, string time2)
{
    double currentTime, nextTime;
    currentEvent[2] = nextEvent[2] = '.';
    istringstream(currentEvent) >> currentTime;
    istringstream(nextEvent) >> nextTime;

    if (currentEvent.substr(currentEvent.length() - 2) != "00" && nextEvent.substr(nextEvent.length() - 2) == "00")
    {
        nextTime += 0.60;
        nextTime -= 1;
    }
    
    
    if (time1 == time2 && (currentEvent.substr(0, 2) == "12" && nextEvent.substr(0, 2) != "12"))
    {
        return (nextTime + 12.00) - currentTime;
    }
    else if (time1 == time2)
    {
        return nextTime - currentTime;
    }
    else
    {
        return (nextTime + 12.00) - currentTime;
    }
}

string MostFreeTime(string strArr[], int size) {
    int index;
    string current, current2, current3, temp, temp2, temp3;
    bool swap;

     
    do
    {
        swap = false;
        for (int x = 0; x < size-1; x++)
        {
            current = strArr[x].substr(0, 2); // current hour
            current2 = strArr[x].substr(5, 2); // current time frame
            current3 = strArr[x].substr(3, 2); // current minute
            temp = strArr[x+1].substr(0, 2); // next event hour
            temp2 = strArr[x+1].substr(5, 2); //  next event time frame
            temp3 = strArr[x + 1].substr(3, 2); // next event minute

             
            if (current == temp && current2 == temp2 && current3 > temp3)
            {
                temp = strArr[x];
                strArr[x] = strArr[x + 1];
                strArr[x + 1] = temp;
                swap = true;
            }
            if ((temp < current && current != "12") && ((current2 == "AM" && temp2 == "AM") || (current2 == "PM" && temp2 == "PM")))
            {
                temp = strArr[x];
                strArr[x] = strArr[x + 1];
                strArr[x + 1] = temp;
                swap = true;
            }
            else if ((temp > current && temp == "12") && ((current2 == "AM" && temp2 == "AM") || (current2 == "PM" && temp2 == "PM")))
            {
                temp = strArr[x];
                strArr[x] = strArr[x + 1];
                strArr[x + 1] = temp;
                swap = true;
            }
            else if ((temp < current || temp > current) && current2 == "PM" && temp2 == "AM")
            {
                temp = strArr[x];
                strArr[x] = strArr[x + 1];
                strArr[x + 1] = temp;
                swap = true;
            }
        }
    } while (swap);

    double value;
    double high = 0;
     
    for (int y = 0; y < size-1; y++)
    {
         
        value = timeDifference(strArr[y].substr(8, 5), strArr[y + 1].substr(0, 5), strArr[y].substr(strArr[y].length() - 2), strArr[y+1].substr(5,2));

        if (value > high) // Keep track of which provides the most free time
        {
            high = value;
        }
    }
    
    
    stringstream convert;
    convert << fixed << setprecision(2) << high;
    string freeTime = convert.str();
 
    if (freeTime.length() != 5)
    {
        freeTime.insert(0, "0");
    }
    freeTime[2] = ':';

    return freeTime;
}
 
int main() {
     
    string A[] = { "12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM" };
    string B[] = { "12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM" };
    string C[] = { "10:00AM-12:30PM", "02:00PM-02:45PM", "09:10AM-09:50AM" };
    string D[] = { "06:00AM-08:00PM", "09:09PM-09:11PM", "08:10PM-09:00PM", "08:02PM-08:04PM" };
    
    string ans=MostFreeTime(A, sizeof(A) / sizeof(A[0])) ; 
    cout<<ans<<endl;
    // string token="w2x19yvu6bb";
    
    int i=0;
    int j=0;
    // string ans="03:01";
    string token="w2x19yvu6bb";
    string fans="";
    int idx=0;
    while(i<ans.length() || j<token.length() ){
        if(i<ans.length()){
            fans+=(ans[i]);
            i++;
        }
        if(j<token.length()){
            fans+=(token[j]);
            j++;
        }
    }
    
    cout <<fans<< endl; 
    cout << MostFreeTime(B, sizeof(B) / sizeof(B[0])) << endl; // 00:04
    cout << MostFreeTime(C, sizeof(C) / sizeof(C[0])) << endl; // 01:30
    cout << MostFreeTime(D, sizeof(D) / sizeof(D[0])) << endl; // 00:09

    return 0;
}