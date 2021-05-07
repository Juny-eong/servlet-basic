package algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1197 {
	
	public static int[] parent;
	public static int max = 0;
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Node> nodeList = new ArrayList<>(); 
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int v1 = 0;
		int v2 = 0;
		int cost = 0;
		
		parent = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			
			nodeList.add(new Node(v1, v2, cost));
		}
		
		Collections.sort(nodeList);
		
		for (int i = 0; i < N; i++) {
			Node node = nodeList.get(i);
			if (!isSameParent(node.v1, node.v2)) {
				union(node.v1, node.v2);
				max += node.cost;
			}
		}
		
		System.out.println(max);
		
	}
	
	public static int find(int x) {
		
		x = parent[x];

		if (x != parent[x]) {
			return parent[x] = find(parent[x]);
		}
		else {
			return x;
		}

	}
	
	
	public static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x; // y가 더 크다는 전제 하에
		}
	}
	
	public static boolean isSameParent(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if (x == y)
			return true;
		else 
			return false;
	}
	
}


class Node implements Comparable<Node> {
	
	int v1;
	int v2;
	int cost;
	
	public Node(int v1, int v2, int cost) {
		// TODO Auto-generated constructor stub
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		if (this.cost > o.cost)
			return 1;
		else if (this.cost == o.cost)
			return 0;
		else
			return -1;

	}
}
