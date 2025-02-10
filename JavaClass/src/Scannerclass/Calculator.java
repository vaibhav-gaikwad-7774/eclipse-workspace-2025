package Scannerclass;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		/*Input
		Output
		35
		23
		Sum is: 58
		Difference is: 12*/
		System.out.println("Enter a ");
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter b ");
		Scanner sc2 = new Scanner(System.in);
		int a = sc1.nextInt();
		int b = sc2.nextInt();
		int sum = (a+b);
		int diff = (a-b);
		System.out.println("");
		System.out.println("The Diff of these are: "+ diff);
		
		

	}

}
