package HashMap;



/*
 Longest consecutive Sequence
Send Feedback
You are given with an array of integers that contain numbers in random order. Write a program to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains consecutive elements. Order of elements in the output is not important.
Best solution takes O(n) time.
If two sequences are of equal length then return the sequence starting with the number whose occurrence is earlier in the array.
Input Format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 50000
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
Sample Output 1 :
8 
9 
10 
11 
12
Sample Input 2 :
 */

import java.util.ArrayList;
import java.util.HashMap;

public class LongestconsecutiveSequence {
	
	
	public static void longestConsecutiveIncreasingSequence(int[] arr)
	{
		
		int count = 0;
		
		int maxLength = Integer.MIN_VALUE;
		
		int currentStart = 0;
		
		HashMap<Integer,Boolean> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], true);
		}
		
	
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				boolean check = map.get(arr[i]);
				
				if(check==true)
				{
					int j=arr[i];
					
					while(map.containsKey(j))
					{
						map.put(j,false);
						j++;
						count++;
					}
					
					j=arr[i];
					
				
					
					
					
					//Now we will check to lover limit
					
					if(map.containsKey(arr[i]-1))
					{
						j = arr[i]-1;
						
						while(map.containsKey(j))
						{
							map.put(j,false);
							j--;
							count++;
							
								
							
						}
						j=j+1;
					}
					
					
					if(count>=maxLength)
					{
						maxLength = count;
						
						currentStart =j;
					}
					
					count = 0;
					
					
					
				}
			}
		}
		
		if(maxLength==1)
		{
			System.out.println(arr[0]);
			return;
		}
		for(int i=0;i<maxLength;i++)
		{
			System.out.println(currentStart);
			currentStart++;
		}

	
			
	}

	public static void main(String[] args) {
		//int arr[] = {693, 697 ,299 ,662, 290 ,288, 925 ,234 ,257 ,192 ,687 ,144 ,142 ,710 ,66 ,955 ,321 ,629 ,989 ,621};
		
		//int arr[] = {568};
		
		int arr[] = {11 ,13 ,14 ,5 ,4 ,12, 6, 8 ,10 ,7};
		
		longestConsecutiveIncreasingSequence(arr);
		
		
	}

}
