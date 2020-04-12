package HashMap;

public class PrintInterSection {
	
	public static void intersection(int[] arr1, int[] arr2)
	{
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
				{
					arr2[j] = -1;
					System.out.println(arr1[i]);
				}
			}
				
		}
	}

	public static void main(String[] args) {
		
		int arr1[] = {1,2,3,4,2,5};
		int arr2[] = {2,4,2,4,5};
		
		intersection(arr1,arr2);
	

	}

}
