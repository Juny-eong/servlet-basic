package algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
	
	static int N;
	static int C;
	static int[] home;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		home = new int[N];
		
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		process();
	}
	
	
	static void process() {
		int ans = Integer.MAX_VALUE;
		int mid = 0;
		int tmp = 0;
		int start = 0;
		int end = home.length - 1;
		int left = 0;
		int right = 0;
		
		if (C == 2) {
			System.out.println(home[end] - home[start]);
			return;
		}
		else {
			C -= 2;
			
			while (C > 0) {
				mid = (start + end) / 2;
				left = home[mid] - home[start];
				right = home[end] - home[mid];
				tmp = Math.min(left, right);
				ans = Math.min(ans, tmp);
				C--;
				if (right > left) {
					start = mid;
				}
				else {
					end = mid;
				}
				
			}
			System.out.println(ans);
			return;
		}
	}

}
