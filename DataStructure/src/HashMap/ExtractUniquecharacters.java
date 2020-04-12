package HashMap;

import java.util.HashMap;

public class ExtractUniquecharacters {
	
	public static void uniqueChar(String str)
	{
		String result="";
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				if(map.containsKey(result))
				{
					int freq = map.get(result);
					map.put(result,freq+1);
					
				}
				else
				{
				map.put(result,1);
				}
				result ="";
			}
			else
			{
			result = result+str.charAt(i);
			}
		}
		
		String output ="";
		
		result ="";
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				if(map.containsKey(result))
				{
					int fre = map.get(result);
					if(fre>0)
					{
					output = output+result+" ";
					
					map.put(result,0);
					}
					
					result="";
				}
			}
				
			else
			{
			
			result = result+str.charAt(i);
			}
			
			
	}
		
	if(output=="")
	{
		System.out.println(str);
	}
	else
	{
		System.out.println(output);
	}
			
	}

	public static void main(String[] args) {
	String str = new String("G");
	uniqueChar(str);
	
	

	}

}
