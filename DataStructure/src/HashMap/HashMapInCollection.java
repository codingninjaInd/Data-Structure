package HashMap;

import java.util.HashMap;

public class HashMapInCollection {

	public static void main(String[] args) {
		
		HashMap<String,Integer> map = new HashMap<>();
		
		//Now will start to add new value on hash map
		
		map.put("abc",1);
		map.put("abc2",2);
		map.put("abc3",3);
		System.out.println(map.containsKey("abc"));
		
		//Now if we want to get the value from hash  map
		
		
		
		System.out.println(map.get("oef"));
	

	}

}
