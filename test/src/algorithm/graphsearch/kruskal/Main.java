package algorithm.graphsearch.kruskal;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static int[] parent;
	public static ArrayList<Edge> edgeList;
	
	
	public static void main(String[] args) {
		
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(1, 4, 4));
		edgeList.add(new Edge(1, 2, 6));
		edgeList.add(new Edge(2, 3, 5));
		edgeList.add(new Edge(2, 4, 3));
		edgeList.add(new Edge(2, 5, 7));
		edgeList.add(new Edge(2, 6, 8));
		edgeList.add(new Edge(3, 6, 8));
		edgeList.add(new Edge(4, 5, 9));
		edgeList.add(new Edge(5, 6, 11));
        
        parent = new int[7]; // node list
        for (int i = 1; i <= 6; i++) {
        	parent[i] = i;
        }
        
        Collections.sort(edgeList);
        
        int sum = 0;
        
        
        for (int i = 0; i < edgeList.size(); i++) {
        	Edge edge = edgeList.get(i);
        	
        	/* 서로 다른 집합이면 그 코스트를 더하고 union 한다. */
        	if (!isSameParent(edge.v1, edge.v2)) {
        		sum += edge.cost;
        		union(edge.v1, edge.v2);
        	}
        }
        System.out.println(sum);
        
	}
	
	
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
		}
	}
	
	
	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
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
