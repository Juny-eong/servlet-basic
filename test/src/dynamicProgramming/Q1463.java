package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1463 {
	
	/**
	 * �Ʒ� ���� ���������� �ݺ�
	 * 	1) 3���� ���������� ������
	 * 	2) ���������� ���� ���, -1�� �� ���� 3���� ���������� ����.
	 * 	3) (2)�� �ش���� ������ 2�� ������.
	 * 	4) -1 �Ѵ�.
	 * 
	 * 	**** -1 -> /3 �� ��� ����, /2 -> /2 �� ��찡 �켱�Ǿ�� �Ѵ�. ****
	 */

	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int input = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while (input != 1) {
			if (input % 3 == 0) {
				input /= 3;
				cnt++;
				continue;
			}
			else if (((float)input / 2) % 2 == 0) { // 4�� ���������� ���
				input /= 2;
				cnt++;
				continue;
			}
			else if ((input - 1) % 3 == 0) { // -1 �� ���� 3���� ���������� ���
				input -= 1;
				cnt++;
				continue;
			}
			else if (input % 2 == 0) {
				input /= 2;
				cnt++;
				continue;
			}
			else {
				input -= 1;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
