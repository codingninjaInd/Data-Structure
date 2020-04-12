
public class BinarySearchR {
	
	public static int binary(int arr[],int start,int end,int ele)
	{
		if(start>end)
		{
			return start;
		}
		
		int mid = (start+end)/2;
		
		if(arr[mid]==ele)
		{
			return mid;
		}
		else if(arr[mid]<ele)
		{
			start = mid+1;
			
		}
		else{
			end = mid-1;
		}
		
		return binary(arr,start,end,ele);
	}

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6};
		System.out.println(binary(arr,0,arr.length-1,4));
		

	}

}
