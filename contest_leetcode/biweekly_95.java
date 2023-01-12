// 
// The box is "Bulky" if:
// Any of the dimensions of the box is greater or equal to 104.
// Or, the volume of the box is greater or equal to 109.
// If the mass of the box is greater or equal to 100, it is "Heavy".
// If the box is both "Bulky" and "Heavy", then its category is "Both".
// If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
// If the box is "Bulky" but not "Heavy", then its category is "Bulky".
// If the box is "Heavy" but not "Bulky", then its category is "Heavy".

class Solution {
    public String categorizeBox(int l, int w, int h, int m) {
        long v=(l*w*h);

        if((v>=1000000000 ||  l>=10000 || w>=10000 || h>=10000) && mass>=100){
            return "Both";
        }
        else if(v>=1000000000 ||  l>=10000 || w>=10000 || h>=10000){
          return "Bulky";  
        }else if(mass<100 &&  !(v>=1000000000 ||  l>=10000 || w>=10000 || h>=10000)){
            return "Neither";
        } else if(v>=(int)(1e9) && !(mass>=100)){
            return "Bulky";
        }else {
            return "Heavy";
        }
        
    }
}

// 

class DataStream {

    int val;
    int k;
    TreeSet<Integer> tree;
    int index;
    List<Integer> list=new ArrayList<>();
    public DataStream(int value, int con) {
        val=value;
        k=con;
        index=1;
        tree=new TreeMap<>();
    }
    
    public boolean consec(int num) {
        if(index<k){
            if(num!=val){
             list.add(index);
            }

            index++;
            return false;
        } 

        if(num!=val){
            list.add(index);
        }
        if(list.size()>0 && list.get(0)==(index-k)){
            list.remove(0);
        }
        index++;
        if(list.size()>0)return false;
        
        
        return true; 
    }
}

// 

class DataStream {

    int val;

    int kval;
     
    int idx;

    List<Integer> anslist=new ArrayList<>();



    public DataStream(int value, int con) {
        val=value;
        kval=con;
        idx=1;
          
    }
    
    public boolean consec(int number) {

        if(idx<kval){
            if(number!=val){
             anslist.add(idx);
            }

            idx++;
            return false;
        } 

        if(number!=val){
            anslist.add(idx);
        }
        if(anslist.size()>0 && anslist.get(0)==(idx-kval)){
            anslist.remove(0);
        }
        idx++;
        if(anslist.size()>0)return false;
        
        
        return true; 
    }
}

// 

class Solution {

    public String categorizeBox(int l, int w, int h, int masssss) {
        long v=Math.abs((long)((long)(l*w)*(long)h));
            // sdfvbjhsbdvjbsdjfvbjdbjvhbxdjvj

        System.out.print(v+" ");
        if((v>=(int)1e9 ||  l>=10000 || w>=10000 || h>=10000) && masssss>=100){
            return "Both";
        }
        else if(v>=1000000000 ||  l>=10000 || w>=10000 || h>=10000){
          return "Bulky";  
        }else if(masssss<100 &&  !(v>=1000000000 ||  l>=10000 || w>=10000 || h>=10000)){
            return "Neither";
        } else if(v>=(int)(1e9) && !(masssss>=100)){
            return "Bulky";
        }else {
            return "Heavy";
        }
        
    }
}

// 

class Solution {
    public long maxPower(int[] arr, int r, int k) {
        long lo=0;
 
        long hi=Arrays.stream().asLongStream(arr).sum();
        long ans=0;

        while(lo<=hi){
            // long mid=(lo+hi)>>1;
            long mid=lo+(hi-lo+1)/2;

            if(checkIfPossibleToObtainMinimumPower(arr,r,k,mid)){
                ans=mid;
                lo=mid+1;
            }else{
                hi=mid-1;
            }

        }

        return ans;
    }
    public boolean checkIfPossibleToObtainMinimumPower(int []stations,int range,int addPower,long minPower){
       long power=0;
       int []arr=stations.clone();
       for(int i=0;i<r;i++){
          power+=arr[i];
       }

       for(int i=0;i<n;i++){
        if(i+r<n){
            power+=arr[r];
        }

         if(power<minPower){
            long reqPower=minPower-power;

            if(addPower<reqPower){
                return false;
            }

            // add the additonal power to he farthest station
            arr[Math.min(n-1,i+r)]+=reqPower;
            addPower-=reqPower;
            power+=reqPower;
         }
       }
       if(i-r>=0) power-=arr[i-r];
    }

    return true;
}