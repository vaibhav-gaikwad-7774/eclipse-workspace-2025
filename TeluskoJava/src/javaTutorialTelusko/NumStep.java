package javaTutorialTelusko;

import java.util.Scanner;

public class NumStep {

	public static void main(String[] args) 
	
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number which you want to be make : 4");
		int n = sc.nextInt();
		
		for (int i = 1; i<=10;i++) {
			int result  = n * i ;
			
			System.out.println(n + " X " + i + " = "+ result);
		}

	}

}
