package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CardConvRev {
	
	/**
	 * targetNumber�� ��ȯ�� ���, �� ���� �迭�� �ѱ�� ��ȯ�� ���� �迭�� �ְ� �� �ڸ����� �����Ѵ�.
	 * --> �ڸ�����ŭ �迭�� �Ųٷ� ��ȸ�ϸ鼭 ����
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
	
	/* x��  r������ ��ȯ�ϴ� �޼ҵ� */
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
