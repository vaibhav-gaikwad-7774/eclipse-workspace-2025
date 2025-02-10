package JavaTeam;

import java.util.Vector;

public class vector {

	public static void main(String[] args) {
		Vector<Integer> a = new Vector(22);

		a.add(1);
		a.add(1,3);
		
		for(int i : a) {
			System.out.println(i);
		}
	}

}
