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

// Quick Sort -> gfg


class Solution
{
    //Function to sort an array using quick sort algorithm.
    public static void swap(int arr[],int i,int j){
	            int t=arr[i];
	            arr[i]=arr[j];
	            arr[j]=t; 
    }
    static void quickSort(int arr[], int lo, int hi )
    {
         if(lo==hi) return;
         
         int pi=partition(arr,lo,hi);
            
         quickSort(arr,lo,pi-1);
         quickSort(arr,pi+1,hi);

    }
    static int partition(int arr[], int lo, int hi)
    {
         if(lo==hi) return lo;

         int i=lo-1;

         for(int j=lo;j<=hi;j++){
         	if(arr[j]<arr[hi]){
         		i++;
         		swap(arr,i,j);
         	}

         }
         swap(i+1,hi);
         return i+1;
    } 
}
// COUNT SORT 

class Solution {
    public int[] sortArray(int[] nums) {
        int min=(int)1e9;
        int max=-1;

        for(int i:nums){
        	max=Math.max(max,i);
        	min=Math.min(min,i);
        }
        int rg=max-min+1;
        int range[]=new int[max-min+1];

        // index= (number - min)
        for(int i: nums){
        	range[i-min]++;
        }
        //prefixSum array make a array of Range until the index
        for(int i=0;i<rg;i++){
        	if(i==0){
        		continue;
        	}
        	range[i]+=range[i-1];
        }
//  make a maximum index of a value in range
        for(int i=0;i<rg;i++){
        	range[i]-=1;
        }
        int ans[]=new int[nums.length];
//         putting al; the value and updating the indx
        for(int i=nums.length-1;i>=0;i--){
        	int val=nums[i];
        	int idx=range[val-min];
        	ans[idx]=val;
        	range[val-min]-=1;
        }

        return ans;

    }
}