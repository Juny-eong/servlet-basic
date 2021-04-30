package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2108 {
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[8001]; // 0 ~ 8000
		
		List<Integer> list = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			list.add(tmp);
			arr[tmp + 4000]++; // �� ���� ���� �󵵸� �����ϴ� �迭
		}
		Collections.sort(list);
		
		/* �߾Ӱ� */
		int median = list.get(N/2);
		
		
		/* ������ */
		int sum = 0;
		for (int data : list) {
			sum += data;
		}
		int avg = (int) Math.round((double)sum/N);
		
		/* ���� */
		int range = list.get(list.size() - 1) - list.get(0);
		
		/* �ֺ� */
		int mode = 0;
		int cnt = 0;
		for (int i = 0; i < 8001; i++) {
			if (arr[i] > cnt) {
				cnt = arr[i];
			}
		}
		
		int maxCnt = 0; // �ߺ��Ǵ� �ֺ��� ��
		for (int i = 0; i < 8001; i++) {
			if (arr[i] == cnt && maxCnt == 0) {
				mode = i;
				maxCnt++;
			}
			else if (arr[i] == cnt && maxCnt == 1) {
				mode = i;
				break; // �ι�°�� ���� ��
			}
		}
		
		mode-= 4000;
		
		System.out.println(avg + "\n" + median + "\n" + mode + "\n" + range);
		
	}
	


}
