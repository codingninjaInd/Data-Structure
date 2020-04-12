package HashMap;

import java.util.ArrayList;

public class LongestsubsetzerosumWithComplexityn2 {
	
	
	public static void largestSumZero(int[] arr)
	{
	
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++)
		{
			int sum=0;
			for(int j=i;j<arr.length;j++)
			{
				sum = sum+arr[j];
				
				if(sum==0)
				{
					max = Math.max(max,j-i+1);
				}
			}
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) {
		
		//int arr[] = {-223 ,-163 ,56 ,-375 ,352 ,148 ,-167 ,421 ,-365 ,189 ,20 ,-127 ,-283 ,187 ,218 ,-435 ,-123 ,388 ,-171 ,-372};
		int arr[] = {-1 ,1 ,-1 ,1};
		largestSumZero(arr);
		
		
	

	}

}
