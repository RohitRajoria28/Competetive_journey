// 78. Subsets
class Solution {
	public void backTracking(List<List<Integer>> ans,List<Integer> list,int []nums,int i){
		List<Integer> smallans=new ArrayList<>(list);
		ans.add(smallans);

		for(int j=i;j<nums.length;j++){
			list.add(nums[j]);
			backTracking(ans,list,nums,j+1);
			list.add(list.size()-1);
		}
	}
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();

        backTracking(ans,new ArrayList<>(),nums,0);

        return ans;
    }
}

// 90. Subsets II
class Solution {
	public void backTracking(List<List<Integer>> ans,List<Integer> list,int []nums,int i,HashSet<List<Integer>> set){
		
		if(!set.contains(list)){
			List<Integer> smallans=new ArrayList<>(list);
			set.contains(list);
			ans.add(smallans);
		}
		 
		for(int j=i;j<nums.length;j++){
			list.add(nums[j]);
			backTracking(ans,list,nums,j+1);
			list.add(list.size()-1);
		}
	}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set=new ArrayList<>();

        List<List<Integer>> ans=new ArrayList<>();
        backTracking(ans,new ArrayList<>(),nums,0,set);
        return ans;
    }
}

// gfg 

class Solution{
	public int helper(ArrayList<Integer> ans,ArrayList<Integer> arr,int sum , int idx){
		if(idx>=n) return 0;
		 
		 ans.add(helper(ans,arr,sum,idx+1)+arr.get(idx));
		 ans.add(helper(ans,arr,sum,idx+1));
	}
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
      	ArrayList<Integer> ans=new ArrayList<>();

      	helper(ans,arr,0,0);
      	return ans;
    }
}

// combination sun

class Solution {
	public void helper(int[] arr,List<List<Integer>> ans,List<Integer> smallans,int idx,int val,int target){
		if(idx==arr.length) return ;
		if(val==target){
			
			List<Integer> fans=new ArrayList<>(smallans);
			ans.add(fans);
			return ;
		}
		smallans.add(arr[idx]);
		helper(arr,ans,smallans,idx+1,val+arr[idx],target);
		smallans.add(smallans.size()-1);
		helper(arr,ans,smallans,idx+1,val,target);

	}
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();

        helper(arr,ans,new ArrayList<>() ,0,0,target);
        return ans;
    }
}

// 

class Solution
{	public int helper(int mat[][],boolean []vis,int sr,int sc,int er,int ec){
		if(sr==es && sc==ec){
			return 1;
		}
		if(mat[sr][sc]==1) return 0;

		vis[sr][sc]=true;

		ans+=helper(mat,vis,sr+1,sc,er,ec);
		ans+=helper(mat,vis,sr,sc+1,er,ec);
		vis[sr][sc]=false;
		
		return ans;
	}
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
       
        boolean vis[][]=new boolean[n+1][m+1];
        int mat[][]=new int[n+1][m+1];

    	for(int a[]: blocked_cells){
    		int r=a[0];
    		int c=a[1];
    		mat[r][c]=1;
    	}

        int ans=helper(mat,vis,0,0,n,m);	

        return ans;
    }
}