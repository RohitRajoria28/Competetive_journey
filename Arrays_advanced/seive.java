	
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