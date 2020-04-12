import java.util.ArrayList;
import java.util.HashMap;
public class Longestsubsetzeroum {
	
	 public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) 
	 {
		 int max = 0;
		 
		 HashMap<Integer,Integer> map = new HashMap<>();
		 
		 int sum = 0;
		 
		 for(int i=0;i<arr.size();i++)
		 {
			 
			 if(map.containsKey(sum))
			 {
				 int l = map.get(sum);
				 max = Math.max(max,i);
			 }
			 sum = sum+arr.get(i);
			 
			 map.put(sum,i);
			 
			 
			 
 }
		 
		 return max;
	 }

	public static void main(String[] args) {
	
		ArrayList<Integer> a = new ArrayList<>();
		
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		for(int i=0;i<arr.length;i++)
		{
			a.add(arr[i]);
			
		}
		
		System.out.println(lengthOfLongestSubsetWithZeroSum(a));

	}

}
