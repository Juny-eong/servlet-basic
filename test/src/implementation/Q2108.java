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
			arr[tmp + 4000]++; // 각 값의 출현 빈도를 저장하는 배열
		}
		Collections.sort(list);
		
		/* 중앙값 */
		int median = list.get(N/2);
		
		
		/* 산술평균 */
		int sum = 0;
		for (int data : list) {
			sum += data;
		}
		int avg = (int) Math.round((double)sum/N);
		
		/* 범위 */
		int range = list.get(list.size() - 1) - list.get(0);
		
		/* 최빈값 */
		int mode = 0;
		int cnt = 0;
		for (int i = 0; i < 8001; i++) {
			if (arr[i] > cnt) {
				cnt = arr[i];
			}
		}
		
		int maxCnt = 0; // 중복되는 최빈값의 수
		for (int i = 0; i < 8001; i++) {
			if (arr[i] == cnt && maxCnt == 0) {
				mode = i;
				maxCnt++;
			}
			else if (arr[i] == cnt && maxCnt == 1) {
				mode = i;
				break; // 두번째로 작은 값
			}
		}
		
		mode-= 4000;
		
		System.out.println(avg + "\n" + median + "\n" + mode + "\n" + range);
		
	}
	


}
