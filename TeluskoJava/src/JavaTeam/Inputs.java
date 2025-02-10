package JavaTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inputs {

	public static void main(String[] args) throws IOException {
//		bufferreader
		BufferedReader abc = new BufferedReader(new InputStreamReader(System.in));
		

		String str = abc.readLine();
		
		System.out.println(str);
		
	}

}
