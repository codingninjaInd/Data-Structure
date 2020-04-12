package HashMap;

import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyHashMap {
	
	public static int maximumFrequency(int[] arr)
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
		int key = arr[i]; 
        if(!map.containsKey(key)) 
        { 
            map.put(key,1);
        } 
        else
        { 
          int fre = map.get(key);
          fre = fre+1;
          
          map.put(key,fre);
        } 
		}
		
		 int maxValue=0;
	        int maximum=Integer.MIN_VALUE;

	   
	        for(int i:arr){
	            if(map.get(i)>maxValue){
	                maxValue = map.get(i);
	                maximum = i;
	            }
	        }
	        return maximum;
	}

	public static void main(String[] args) {
		
int arr[] = {675,28,-429,-290,444,-949,992,-850,280,810 };
		
		System.out.println(maximumFrequency(arr));
		
	}

}
