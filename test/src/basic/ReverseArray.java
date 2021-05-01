package basic;

import java.util.Scanner;

public class ReverseArray {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println("N : " + N);
		
		int[] x = new int[N];
		for (int i = 0; i < N; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println("x : " + x.hashCode());
		
		reverse(x);
		
		for (int i = 0; i < N; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
		
		sc.close();
	}
	
	
	/* arr�� ���� �������� �ѱ�Ƿ� �޼ҵ� ���ο��� ��ġ�� �����ص� main�޼ҵ��� ���� �迭�� ����ȴ�. */
	static void reverse(int[] arr) {
		System.out.println("reverse : " + arr.hashCode());
		for (int i = 0; i < arr.length / 2; i++) {
			swap(arr, i, arr.length - 1 - i);
		}
	}
	
	static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
