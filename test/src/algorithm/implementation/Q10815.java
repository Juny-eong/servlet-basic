package algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q10815 {
	
	static int N;
	static int M;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			if (  set.contains(Integer.parseInt(st.nextToken()))  ) {
				if (sb.length() == 0) {
					sb.append(1);
				}
				else {
					sb.append(" " + 1);
				}
				
			}
			else {
				if (sb.length() == 0) {
					sb.append(0);
				}
				else {
					sb.append(" " + 0);
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
