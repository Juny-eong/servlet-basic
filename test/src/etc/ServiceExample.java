package etc;

import java.lang.reflect.Method;

public class ServiceExample {

	public static void main(String[] args) {
		
		/* get all methods from class */
		Class<TestService> cls = TestService.class;
		Method[] declareMethods = cls.getDeclaredMethods();
		
		for (Method method : declareMethods) {
			
			if (method.isAnnotationPresent(PrintType.class)) {
				PrintType printType = method.getAnnotation(PrintType.class);
				
				System.out.println(method.getName());
				System.out.println(printType.elementValue() + printType.elementCount());
			}
			
			try {
				method.invoke(new TestService());
			}
			catch(Exception e) {
				System.out.println("exception occured.");
			}
		}
		
		System.out.println("----------------------------------------------------");
	}
}
