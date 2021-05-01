package basic;

public class EnhancedPrimeNumber {
	
	public static void main(String[] args) {
		
		int counter = 0;
		int ptr = 0;
		int[] primeArr = new int[500];
		
		primeArr[ptr++] = 2;
		primeArr[ptr++] = 3;
		
		for (int n = 5; n < 1000; n += 2) {
			
			boolean flag = false;
			
			/* 제곱근 이하의 소수(홀수)로 나누어지는지 확인 */
			for (int i = 1; primeArr[i] * primeArr[i] <= n; i++) {
				counter += 2;
				
				if (n % primeArr[i] == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				primeArr[ptr++] = n;
				counter++;
			}
		}
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(primeArr[i]);
		}
		
		System.out.println("total operation count : " + counter);
	}
}
