import java.util.Scanner;

public class Alphabet {

	public static void main(String[] args) {
		System.out.println("Enter a Character which you want to check whether is alphabet or not: ");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		if ((ch>='a' && ch<='z') || (ch>='A'&& ch<='Z')) {
			System.out.println(ch+ "  is Alphabet");
		} else {
			System.out.println(ch + " is not an Alphabets");
		}
		
		sc.close();
				

	}

}
