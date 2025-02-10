import java.util.Scanner;

public class ArmStrong {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a number which you want to check is armstrong or not: ");
		int num = sc.nextInt();
		
		
		if (isArmstrong(num)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }
		
	}

	private static boolean isArmstrong(int num) {
		// TODO Auto-generated method stub
		return false;
	}

}
