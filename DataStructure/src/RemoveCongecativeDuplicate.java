import java.util.ArrayList;


public class RemoveCongecativeDuplicate {
	
	public static ArrayList<Integer> remove(int[] arr)
	{
		ArrayList<Integer> result = new ArrayList<>();
		result.add(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i] != arr[i-1])
			{
				result.add(arr[i]);
			}
		}
		return result;
	
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {10,10,20,20,20,39,31,32,33};
		
		System.out.println(remove(arr));

	}

}
