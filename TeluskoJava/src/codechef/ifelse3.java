package codechef;

import java.util.Scanner;

public class ifelse3 {
	public static void main(String[] args) {
//		Some code is written in the editor.
//
//		Two variables r and k are defined.
//		Output based on these conditions:
//		If r is greater than k, output "Ram is heavier than Karan"
//		If r is less than k, output "Karan is heavier than Ram"
//		Otherwise, output "Ram & Karan have the same weight!"
		
		Scanner sc =  new Scanner (System.in);
		System.out.println("Enter a value of a");
		int a  = sc.nextInt();
		System.out.println("Enter a value of b");
		int b = sc.nextInt();
		
		if(a>b) {
			System.out.println("Ram is heavier than Karan");
		}else if (a<b) {
			System.out.println("Karan is heavier than Ram");
		}else {
			System.out.println("Ram & Karan have the same weight!");
		}
	}
	

}
