// q1

class Solution {
    public int captureForts(int[] arr) {
      // -1
    

      // [1,0,0,-1,0,0,-1,0,0,1]
      int one=-1;
      int mone=-1;
        int max=0;
      for(int i =0;i<arr.length;i++){
         if(arr[i]==1){
            one=i;
         }
         if(arr[i]=mone){
            mone=i;
         }
         if(one!=-1 && mone!=-1){
            max=Math.max(max,Math.abs(one-mone)-1);
            one=-1;
            mone=-1;
         }
      }

       
      

      return max;
    }
}

// 

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        HashSet<String> pos=new HashSet<>();
        HashSet<String> neg=new HashSet<>();

        for(String s : positive_feedback){
            pos.add(s);
        }
        for(String s: negative_feedback){
            neg.add(s);
        }
        int idx=0;
        int ans[][]=new int[report.length][2];

        for( String s : report){
            String arr[]=s.split(' ');
            int points=0;
            for(String str: arr){
                if(pos.contains(str)){
                    points+=3;
                }else if(neg.contains(str)){
                    points-=1;
                }
            }
             
            ans[idx][0]=points;
            ans[idx][1]=idx;
            idx++;
        }

        Collections.sort(ans,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
           
        })

        List<Integer> fans=new ArrayList<>();

        for(int i=0;i<k;i++){

            fans.add(ans[i][1]);

        }
        return fans;

    }
}

// 

class Solution {
    public List<Integer> topStudents(String[] arr1, String[] arr2, String[] arr2, int[] student_id, int k) {
        HashSet<String> position=new HashSet<>();
        HashSet<String> negative=new HashSet<>();
         
           
        for(String s : arr1){
            position.add(s);
        }
        for(String s: arr2){
            negative.add(s);
        }

        int idxxx=0;
         
        int sanns[][]=new int[arr3.length][2];



         int id=0;
        for( String s : arr3){
            String arr[]=s.split("\\s");
            int points=0;
            for(String str: arr){
                if(position.contains(str)){
                    points+=3;
                }else if(negative.contains(str)){
                    points-=1;
                }
            }
             


            sanns[idxxx][0]=points;
            sanns[idxxx][1]=student_id[id];
            id++;
            idxxx++;
        }



        Arrays.sort(sanns,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
               return  b[0]-a[0];
            }
        });

 

        List<Integer> fans=new ArrayList<>();

        for(int i=0;i<k;i++){




            fans.add(sanns[i][1]);

        }
        return fans;

    }
}

// 

class Solution {
    public int captureForts(int[] nums) {
        
      int eon=-1;
      int mone=-1;



        int great=0;
      for(int i =0;i<nums.length;i++){
         if(nums[i]==1){
            eon=i;
         }
         if(nums[i]==-1){
            mone=i;
         }

         // iasdfashdfjhsavdkvsgud
         if(eon!=-1 && mone!=-1){



            great=Math.max(great,Math.abs(eon-mone)-1);
             if(eon>mone){
                mone=-1;             
             }else {
                eon=-1;



                 
             }
         }
      }

       
      

      return great;
    }
}