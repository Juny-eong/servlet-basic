package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CardConvRev {
	
	/**
	 * targetNumber와 변환할 기수, 빈 문자 배열을 넘기면 변환한 값을 배열에 넣고 그 자릿수를 리턴한다.
	 * --> 자리수만큼 배열을 거꾸로 순회하면서 리턴
	 * @param args
	 * @throws Throwable
	 */
	
	public static void main(String[] args) throws Throwable {
		
		int number = 0;
		int cd = 0;
		int dno = 0;
		char[] cno = new char[32];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		number = Integer.parseInt(br.readLine());
		cd = Integer.parseInt(br.readLine());
		
		
		dno = cardConvR(number, cd, cno);
		
		for (int i = dno - 1; i >= 0; i--) {
			System.out.print(cno[i]);
		}
	}
	
	/* x를  r진수로 변환하는 메소드 */
	static int cardConvR(int x, int r, char[] d) {
		
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		}
		while (x != 0);
		
		return digits;
		
	}

}
