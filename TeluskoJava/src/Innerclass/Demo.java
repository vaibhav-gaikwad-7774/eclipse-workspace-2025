package Innerclass;

class A{
	public void show() {
		System.out.println("In show");
	}
	
	class B{
		public void card() {
			System.out.println("In inner class Card");
		}
	}
}


public class Demo {
	public static void main(String[] args) {
		A obj = new A();
		obj.show();
		
	}

}
