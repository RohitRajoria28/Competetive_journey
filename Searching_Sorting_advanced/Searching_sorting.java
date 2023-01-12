// BUBBLE SORT

	public static void swap(int arr[],int i,int j){
	            int t=arr[i];
	            arr[i]=arr[j];
	            arr[j]=t; 
    }
    // Time Complexity -> O(n2)

	public static void BubbleSort(int []arr){
	    int n=arr.length;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n-i-1;j++){
	            if(arr[j+1]<arr[j]){
	                swap(arr,j,j+1);
	            }
	        }
	    }
	    for(int i:arr){
	        System.out.print(i+" ");
	    }
	}

// Selection Sort Algorithm 

	public static void selectionSort(int arr[]){

	          int min_idx=0;
	          int n=arr.length;
	          for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                if(arr[i] > arr[j]){
	                    swap(arr,i,j);
	                }
	            }
	          }

	          for(int i:arr){
	            System.out.print(i+" ");
	          }

	} 

	// Insertion Sort 

	public static void InsertionSort(int arr[]){

          int min_idx=0;
          int n=arr.length;
          for(int i=1;i<n;i++){
             if(arr[i]<arr[i-1]){
                for(int j=i;j>0;j--){
                    if(arr[j]<arr[j-1]){
                        swap(arr,j,j-1);
                    }
                }
             }
          }

          for(int i:arr){
            System.out.print(i+" ");
          }

       }



// MERGE SORT 
// leetcode 912

class Solution {
	public int[] mergeTwoSorted(int arr1[],int arr2[]){
		int i=0;
		int j=0;	
		int n=arr1.length;
		int m=arr2.length;
    int idx=0;
		int ans[]=new int[n+m];
		while(i<n && j<m){
			if(arr1[i]<=arr2[j]){
				ans[idx++]=arr1[i++];
			}else{
				ans[idx++]=arr2[j++];
			}

		}

		while(i<n && idx<n+m){
			ans[idx++]=arr1[i++];
		}
		while(j<n && idx<n+m){
			ans[idx++]=arr2[j++];
		}

		return ans;
	}
	public int[] mergeSort(int nums[],int lo,int hi){

		if(lo==hi){
			return new int[]{nums[lo]};
		}

		int mid=(lo+hi)/2;
		int left[]=mergeSort(nums,lo,mid);
		int right[]=mergeSort(nums,mid+1,hi);

		return mergeTwoSorted(left,right);
	}
    public int[] sortArray(int[] nums) {
 		 int lo=0;
 		 int hi=nums.length-1;
            
        return mergeSort(nums,0,hi);

    }
} 

// 

class Solution {
	public void swap(int arr[],int i,int j){
		int t=arr[i];
		arr[i]==arr[j];
		arr[j]=t;
	}
    public void sortColors(int[] nums) {
 		int i=0;
 		int j=0;
 		int n=nums.length;
 		int k=n-1;

 		while(j<=k){
 			 if(arr[j]==1){
 			 	j++;
 			 }else if(arr[j]==0){
 			 	swap(i,j);
 			 	i++;
 			 	j++;
 			 }
 			 else if(arr[j]==2){
 			 	swap(arr,j,k);
 			 	k--;
 			 }
 		}     

 		return arr;  
    }
}