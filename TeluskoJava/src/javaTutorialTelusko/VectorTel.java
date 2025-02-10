package javaTutorialTelusko;

import java.util.Vector;

public class VectorTel {
	public static void main(String[] args) {
		Vector<Integer> V = new Vector<Integer>();
		V.add(4);
		V.add(6);
		V.add(6);
		V.add(6);
		V.add(6);
		V.add(6);
		V.add(6);
		System.out.println(V.capacity());
		
		for(int i : V) {
			System.out.println(i);
		}
		
		
	}

}
