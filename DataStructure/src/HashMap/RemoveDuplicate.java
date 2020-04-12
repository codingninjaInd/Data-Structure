package HashMap;

import java.util.ArrayList;

import java.util.HashMap;

public class RemoveDuplicate {
	
	
	public static ArrayList<Integer> remove(int[] arr)
	{
		
		ArrayList<Integer> output = new ArrayList<>();
		
		HashMap<Integer,Boolean> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				continue;
			}
			
			output.add(arr[i]);
			map.put(arr[i],true);
		}
		return output;
		
	}

	public static void main(String[] args) {
		int arr[] = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5};
		
		ArrayList<Integer> result = remove(arr);
		
		System.out.println(result);
		
		
				
				

	}

}
