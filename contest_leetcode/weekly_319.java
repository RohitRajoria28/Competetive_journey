 // q1

class Solution {
    public double[] convertTemperature(double celsius) {
//         Kelvin = Celsius + 273.15
// Fahrenheit = Celsius * 1.80 + 32.00
        return new double[]{celsius + 273.15,celsius * 1.80 + 32.00}
    }
}

// 

 class Solution {
    public int helper(List<Integer> list){
        int count =0;

        int n=list.size();
        int sorted[]=new int[n];
        int idx=0;
        
        for(int i: list){
            sorted[idx++]=i;
        }

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(list.get(i),i);
        }

        Arrays.sort(sorted);
        for(int i=0;i<n;i++){
             if(list.get(i)!=sorted[i]){
                count++;
                map.put(list.get(i),map.get(sorted[i]));
                list.set(map.get(sorted[i]),list.get(i));
             }
             
        }
        return count;
    }
    public int minimumOperations(TreeNode root) {

        if(root==null) return 0;

        LinkedList<TreeNode> list=new LinkedList<>();
        list.add(root);

        int count =0;
        while(list.size()!=0){
            int size=list.size();
            List<Integer> sort=new ArrayList<>();
            while(size-->0){
                TreeNode rnode=list.removeFirst();

                sort.add(rnode.val);

                if(rnode.left!=null) list.add(rnode.left);
                if(rnode.right!=null) list.add(rnode.right);
            }

            count+=helper(sort);

        }

        return count;
        
    }
}

// 

class Solution {
    public int helper(int arr[],int si,int ei,int k){
        int max=-1;
        for(int i=si;i<=ei;i++){
            max=Math.max(arr[i],max);
        }
        int ans=0;
        while(true){
            boolean flag=false;
            for(int i=si;i<=ei;i++){
                if(max%arr[i]!=0){
                    flag=true;
                }
            }
            if(!flag){
                return (k==max)?1:0;
                
            }
            max++;
        }

         
    }
    public int subarrayLCM(int[] nums, int k) {
        int ans=0;
    int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>k) continue;

            for(int j=i;j<n;j++){
                if(nums[j]>k) break;

                ans+=(helper(nums,i,j,k));
            }
        }
        return ans;
    }
}

// optimal 

class Solution {
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    puclic int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public int subarrayLCM(int[] nums, int k) {
        int ans=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            int c=1;
            for(int j=i;j<n;j++){
                c=lcm(c,nums[j]);
                ans+=(c==k?1:0);
            }

        }
        return ans;
    }
}