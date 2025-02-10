package JavaTeam;

import java.util.HashMap;

public class ContainKeyHash {

	public static void main(String[] args) {
		HashMap<Integer, String> Map = new HashMap<>();
		
		Map.put(1, "Ishan");
		Map.put(2, "Vaibhav");
		Map.put(3, "Arti");
		
		System.out.println(Map.containsKey(3));
		
	}

}
