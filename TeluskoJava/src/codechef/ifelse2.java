package codechef;

import java.util.Scanner;

public class ifelse2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter a value of a");
		int a = sc.nextInt();
		System.out.println("Enter a value of b");
		int b = sc.nextInt();
		
		if(a>b) {
			System.out.println("a is greater than b");
			
		}else if (a==b) {
			System.out.println("a is similar for b");
		}

		else {
			System.out.println("b is greater than a");
		}
	}

}
