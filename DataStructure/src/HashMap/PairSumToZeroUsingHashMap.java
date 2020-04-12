package HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class PairSumToZeroUsingHashMap {
	
	public static void PairSum(int[] input, int size)
	{
		Arrays.sort(input);
	
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<input.length;i++)
		{
			if(map.containsKey(input[i]))
			{
				int frequency = map.get(input[i]);
				map.putIfAbsent(input[i],frequency+1);
			}
			else
			{
				map.putIfAbsent(input[i],1);
			}
		}
		
		for(int i:input)
		{
			if(map.containsKey(i))
			{
				if(map.containsKey(-(i)))
				{
					int fre1 = map.get(i);
					int fre2 = map.get(-i);
					
					if(fre1 >0 && fre2>0)
					{
						System.out.println(i+" "+-i);
						
						map.putIfAbsent(i, fre1-1);
						
						map.putIfAbsent(-i,fre2-1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		int arr[] = {-2,2,6,-2,2,-6,3};
		
		 PairSum(arr,7);

	
	}
}
