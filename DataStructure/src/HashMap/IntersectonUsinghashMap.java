package HashMap;
import java.util.HashMap;
public class IntersectonUsinghashMap {
	
	public static void intersection(int[] arr1, int[] arr2)
	{
		HashMap<Integer,Integer> map  = new HashMap<>();
		
		for(int i=0;i<arr1.length;i++)
		{
			if(map.containsKey(arr1[i]))
			{
				
				int value = map.get(arr1[i]);
				
				map.put(arr1[i],value+1);
				
			}
			else
			{
				map.put(arr1[i],1);
			}
			
						
			
		}
		
		for(int i=0;i<arr2.length;i++)
		{
			if(map.containsKey(arr2[i]))
			{
				int freq = map.get(arr2[i]);
				
				if(freq>0)
				{
					System.out.println(arr2[i]);
					map.put(arr2[i],freq-1);
					
				}
			}
		}
		
		
		
	}

	public static void main(String[] args) {
		
		int arr1[] = {2,6,1,2};
		
		int arr2[] = {1,2,3,4,2};
		
		intersection(arr1,arr2);
				
		}
		

	}


