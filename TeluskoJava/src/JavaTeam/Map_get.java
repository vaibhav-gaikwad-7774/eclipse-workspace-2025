package JavaTeam;

import java.util.HashMap;
import java.util.Map;

public class Map_get {

	public static void main(String[] args) {
		Map<Integer, String> a = new HashMap<Integer, String>();
		

		a.put(1, "Tanya");
		a.put(2, "vaibhav");
		a.put(3, "bkx");
		
		System.out.println(a.get(2));
	}

}
