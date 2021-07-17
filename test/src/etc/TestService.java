package etc;


public class TestService {

	@PrintType(elementValue = "=", elementCount = 5)
	public void method1() {
		System.out.println("call method1.");
	}
	
	@PrintType(elementValue = "m")
	public void method2() {
		System.out.println("call method2.");
	}
	
	@PrintType
	public void method3() {
		System.out.println("call method3.");
	}
}
