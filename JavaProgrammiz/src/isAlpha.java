import java.util.Scanner;

public class isAlpha {

	public static void main(String[] args) {
		System.out.println("Enter a character: ");
		Scanner sc = new Scanner (System.in);		
		char ch = sc.next().charAt(0);
		if (Character.isAlphabetic(ch)) {
		      System.out.println(ch + " is an alphabet.");
		    }
		    else {
		      System.out.println(ch + " is not an alphabet.");
		    }
		  }
		}
