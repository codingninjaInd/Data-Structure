package HashMap;

import java.util.Arrays;

public class PairSunToZeroWithOutHashMap {
	
	public static void PairSum(int[] input, int size) 
	{
		Arrays.sort(input);
		
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				if(input[i]+input[j]==0)
				{
					System.out.println(input[i]+" "+input[j]);
					input[j] = Integer.MAX_VALUE;
				}
				
			}
			
		}
	}

	public static void main(String[] args) {
		
		int arr[] = {39,11,29,40,-16,9,-40,-66,-59,84,85,5,98,-20,-1,-55,-109,68,101,73};
		PairSum(arr,20);
		

	}

}
