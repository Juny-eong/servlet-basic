package algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1922 {
	
	
	public static int[] parent;
	public static int sum = 0;
	public static List<Edge> edgeList;
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 0;
		int c = 0;
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		edgeList = new ArrayList<Edge>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(a, b, c));
		}
		
		Collections.sort(edgeList);
		
		for (int i = 0; i < M; i++) {
			Edge edge = edgeList.get(i);
			if (!isSameParent(edge.node1, edge.node2)) {
				union(edge.node1, edge.node2);
				sum += edge.cost;
			}
			
		}
		
		System.out.println(sum);
	}
	
	
	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		else
			return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
		}
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) {
			return true;
		}
		else
			return false;
	}

}

class Edge implements Comparable<Edge> {
	
	int node1;
	int node2;
	int cost;
	
	public Edge(int node1, int node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		
		if (this.cost < o.cost) {
			return -1;
		}
		else if (this.cost == o.cost)
			return 0;
		else 
			return 1;
	}
	
	
}
