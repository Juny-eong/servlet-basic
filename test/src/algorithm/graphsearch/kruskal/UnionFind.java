package algorithm.graphsearch.kruskal;

public class UnionFind {
	
	/**
	 * graph algorithm - 합집합 찾기
	 */

	public static int[] parent = new int[1000001];
	public static int sum = 0;
	
	public static void main(String[] args) {
		
		/* i = 노드번호, parent[i] = 부모 노드 번호
		 * 최초에는 자기 자신을 가리키도록 한다. */
		for (int i = 1; i <= 8; i++) {
			parent[i] = i;
		}
		union(1, 3);
		union(3, 5);
		System.out.println("is 1 and 5 connected? " + isSameParent(1, 5));

	}
	
	
	/* x가 어떤 집합에 포함되어 있는지 찾는 연산 */
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		else {
			/* 값을 할당하고 리턴 */
			return parent[x] = find(parent[x]);
		}
	}
	
	
	/* x와 y가 포함되어 있는 집합을 합치는 연산 */
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
	
	
	public static int test(int x) {

		return x = x-1;
	}
}
