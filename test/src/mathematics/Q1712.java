package mathematics;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q1712 {
	
	/**
	 * a = ���� ���
	 * b = ���� ���
	 * c = �� ��� ����
	 * --> a + bx < cx ? --> a < (c-b)x
	 */
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if (B >= C) {
			System.out.println(-1);
			
		}
		else {
			System.out.println(  (A/(C-B)) + 1  );
		}
		
	}
}
