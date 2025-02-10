import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int year = 0;

        // Loop until a valid 4-digit year is entered
        while (true) {
            System.out.println("Enter a 4-digit Year: ");
            year = sc.nextInt();

            if (year >= 1000 && year <= 9999) {
                break;
            } else {
                System.out.println("Invalid year. Please enter a 4-digit year.");
            }
        }
		
		System.out.println("Enter a 4 Digit year which you want to check");
		if (year % 400 ==0)
			System.out.println(year + "This is a LEAP year");
		else if (year % 100 ==0)
			System.out.println(year + "This is a LEAP year");
		else
			System.out.println(year + "These is not LEAP year");
			
		
		
	
		

	}

}
