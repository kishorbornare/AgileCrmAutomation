package agilecrm.pages;

public class Testing {

	public static void main(String[] args) {
	
SoftwareTesting obj= new SoftwareTesting() {

	
	public void addition(int a, int b) {
		System.out.println(a+b);
		
	}


	public void substraction(int a, int b) {

		System.out.println(b-a);
	}

	
	public void multiplication(int a, int b) {
		System.out.println(a*b);
		
	}


	public void division(int a, int b) {
		System.out.println(b/a);
		
	}

	
};
obj.addition(10,49);
obj.division(100,100);
obj.multiplication(10, 10);
obj.substraction(100, 500);
	}

}
