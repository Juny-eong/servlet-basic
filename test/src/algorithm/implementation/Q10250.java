package algorithm.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10250 {
	
	/**
	 * 10 / 6 = 1 (+1)... 4
	 * 72 / 30 = 2 (+1)...12
	 * �� ���� ������� ������ ���� ������ �������� ����� ���ܸ� �����ؾ� �Ѵ�.
	 */
	
	static int height;
	static int width;	// ��� x
	static int count;
	
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			count = Integer.parseInt(st.nextToken());
			
			/* ������ �������� ��� �� ��ȣ�� ���� ó�� */
			String room = (count % height != 0) ? String.valueOf(count / height + 1)
												: String.valueOf(count / height);
			
			
			if (room.length() == 1) room = "0" + room;
			
			/* �� ���� ���� ó�� */
			String floor = count % height == 0 ? String.valueOf(height) 
											   : String.valueOf(count % height);
			
			int roomNumber = Integer.parseInt(  floor + room  );
			System.out.println(roomNumber);
			
		}
	}
	

}
