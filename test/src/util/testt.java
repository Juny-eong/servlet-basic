package util;

import java.util.regex.Pattern;

public class testt {
	
	public static void main(String[] args) {
		
		String pattern = "[\\w-?.?]+@\\w[\\w-]*\\.\\w[\\w-]*(\\.\\w[\\w-]*)*";
		System.out.println(Pattern.matches(pattern, "hello_yoolim@naver.com"));
	}

}
