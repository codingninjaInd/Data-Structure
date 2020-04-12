package HashMap;


/*
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
7
3 7 2 1 9 8 1
Sample Output 2 :
7
8
9
Explanation: Sequence should be of consecutive numbers. Here we have 2 sequences with same length i.e. [1, 2, 3] and [7, 8, 9], but output should be [7, 8, 9] because the starting point of [7, 8, 9] comes first in input array.
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15 
16
 */

import java.util.HashMap;

public class longest {
	
	public static void longestConsecutiveIncreasingSequence(int[] arr)
	{
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			
			if(map.containsKey(arr[i]))
			{
				int fre = map.get(arr[i]);
				map.put(arr[i],fre+1);
			}
			else
			{
				map.putIfAbsent(arr[i],1);
			}
			
		}
		
		int maxLength = Integer.MIN_VALUE;
		
		int currentStart =0;
		int count=0;
		
		for(int i:arr)
		{
			
			if(map.containsKey(i) && !map.containsKey(i-1))
			{
				int j = i;
				
				while(map.containsKey(j))
				{
					j++;
					count++;
				}
				
				if(count>maxLength)
				{
					maxLength = count;
					
					currentStart = i;
				}
				count=0;
				
				}
		}
			
		
		
		for(int i=0;i<maxLength;i++)
		{
			System.out.println(currentStart++);
		}
	}

	public static void main(String[] args) {
		
		int arr[] = {15 ,24 ,23 ,12 ,19 ,11 ,16};
		
		//int arr[] = {2 ,12 ,9 ,16 ,10 ,5 ,3 ,20 ,25 ,11 ,1, 8, 6 };
		
		//int arr[] = {3 ,7, 2, 1, 9 ,8 ,1};
		
		 longestConsecutiveIncreasingSequence(arr);
		

	}

}
