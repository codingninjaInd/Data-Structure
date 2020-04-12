package HashMap;

import java.util.HashMap;
import java.util.Set;

public class PairSumto0 {
	
	public static void PairSum(int[] input)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<input.length;i++)
		{
			if(map.containsKey(input[i]))
			{
				int fre = map.get(input[i]);
				map.put(input[i],fre+1);
			}
			else
			{
				map.put(input[i],1);
			}
		}
		
		Set<Integer> keys = map.keySet();
		
		for(int i:keys)
		{
			if(map.containsKey(0-i))
			{
				int fre1 = map.get(i);
				int fre2 = map.get(0-i);
				int m,n;
				
				if(0-i>i)
				{
					 m = 0-i;
					 n=i;
				}
				else {
					m = i;
					n=0-i;
				}
				
				for(int j=0;j<fre1*fre2;j++)
				{
					
					System.out.println(n+" "+m);
				}
				
				map.put(i,0);
				map.put(0-i,0);
			}
			
		}
	}

	public static void main(String[] args) {
		
		//int arr[] = {2 ,1 ,-2, 2 ,3};
		
		//int arr[] = {39 ,11 ,29 ,40 ,-16 ,9 ,-40 ,-66 ,-59 ,84 ,85 ,5 ,98 ,-20 ,-1 ,-55 ,-109 ,68 ,101 ,73};
		int arr[] = {48 ,111 ,-48 ,62 ,-82 ,55 ,-78 ,82 ,-26 ,-38};
		
		PairSum(arr);

	}

}
