package HashMap;

public class MapUse {

	public static void main(String[] args) {
	Map<String,Integer> map = new Map<>();
	
	map.insert("Pushpendra", 1);
	
	
	
	map.removeKey("Pushpendra");
	System.out.println(map.getValue("Pushpendra"));
	
	
	}

}
