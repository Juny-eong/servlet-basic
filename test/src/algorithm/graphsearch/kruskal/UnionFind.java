package algorithm.graphsearch.kruskal;

public class UnionFind {
	
	/**
	 * graph algorithm - ������ ã��
	 */

	public static int[] parent = new int[1000001];
	public static int sum = 0;
	
	public static void main(String[] args) {
		
		/* i = ����ȣ, parent[i] = �θ� ��� ��ȣ
		 * ���ʿ��� �ڱ� �ڽ��� ����Ű���� �Ѵ�. */
		for (int i = 1; i <= 8; i++) {
			parent[i] = i;
		}
		union(1, 3);
		union(3, 5);
		System.out.println("is 1 and 5 connected? " + isSameParent(1, 5));

	}
	
	
	/* x�� � ���տ� ���ԵǾ� �ִ��� ã�� ���� */
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		else {
			/* ���� �Ҵ��ϰ� ���� */
			return parent[x] = find(parent[x]);
		}
	}
	
	
	/* x�� y�� ���ԵǾ� �ִ� ������ ��ġ�� ���� */
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
