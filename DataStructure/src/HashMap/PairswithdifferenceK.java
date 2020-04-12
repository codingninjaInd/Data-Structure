package HashMap;

import java.util.HashMap;

public class PairswithdifferenceK {
	
	public static void findPairsDifferenceK(int[] input, int k)
	{
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<input.length;i++)
		{
			if(map.containsKey(input[i]))
			{
				int freq = map.get(input[i]);
				
				map.put(input[i],freq+1);
			}
		
			else
			{
				map.putIfAbsent(input[i],1);
			}
		}
		
		
		for(int i=0;i<input.length;i++)
		{
			if(map.containsKey(input[i]-k))
			{
				int freq = map.get(input[i]);
				map.put(input[i],0);
				int fre2 = map.get(input[i]-k);
				map.put(input[i]-k,0);
				
				for(int j=0;j<freq*fre2;j++)
				{
					System.out.print(input[i]-k+" "+input[i]);
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) {
		//int arr[] = {-334 ,108 ,35 ,-154, 58 ,-185 ,8 ,-111 ,-91 ,45 };
		int arr[] = {5 ,3 ,4, 2 ,6 ,4 ,6 ,4};
		
		findPairsDifferenceK(arr,2);
		

	}

}
