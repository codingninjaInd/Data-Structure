package HashMap;

public class MaximumFrequencyNo {
	
	public static int maximumFrequency(int[] arr)
	{
		int output[] = new int[100];
		
		for(int i=0;i<arr.length;i++)
		{
			output[arr[i]]++;
		}
		int maximum = Integer.MIN_VALUE;
			
		for(int j=0;j<output.length;j++)
		{
			if(output[j]>maximum)
			{
				maximum = output[j];
				
			}
		}
		
		for(int i=0;i<output.length;i++)
		{
			if(output[i]==maximum)
			{
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		
		int arr[] = {2,12,2,2,14,12,31,2};
		
		System.out.println(maximumFrequency(arr));

	}

}
