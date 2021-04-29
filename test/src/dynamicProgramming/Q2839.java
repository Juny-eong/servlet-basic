package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2839 {
	
	/**
	 * input : N
	 * A = 3 / B = 5
	 * 5�� ���� ������ : 
	 * 
	 * 	0 : N / 5			--> 5 �� ���� ����������. --> (N / 5)							: x
	 * 	1 : 5 + 1 = 6 		--> 3 �� ���� ����������. --> (N / 5) - 1(������ 5) + 2(���� 3)	: x + 1
	 * 	2 : 5 + 5 + 2 = 12 	--> 3 �� ���� ����������. --> (N / 5) - 2(������ 5) + 4(���� 3)	: x + 2
	 * 	3 : N / 5 + 3		--> 3 �� ���� ����������. --> (N / 5) + 1(���� 3)				: x + 1
	 * 	4 : 5 + 4 = 9		--> 3 �� ���� ����������. --> (N / 5) - 1(������ 5) + 3(���� 3)	: x + 2
	 * 
	 * 	�� ���, �ִ�� ���� �������� ��� : 12, �� 12 �̻��� ��� ���� ���ܼ� ���������� 5�� 3���� �ذ�ȴ�.
	 * 	������ �ݴ��, 12���� ���� ���� ���ܼ� �� �ɼ��� ������ �ɻ簡 �ʿ��ϴ�.	-->	4, 7				: -1
	 */
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		
		if (N == 4 || N == 7) 
			System.out.println(-1);
		
		else if (N % 5 == 0)
			System.out.println(N / 5);
		
		else if (N % 5 == 1 || N % 5 == 3)
			System.out.println(N / 5 + 1);
		
		else if (N % 5 == 2 || N % 5 == 4)
			System.out.println(N / 5 + 2);
		
		br.close();
	}
}
