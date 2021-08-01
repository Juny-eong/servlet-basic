package basic;

public class BinarySearch {
	
	static int search(int[] arr, int key) {
		
		int firstIndex = 0;
		int lastIndex = arr.length - 1;
		
		do {
			
			int centerIndex = (lastIndex + firstIndex) / 2;
			
			if (arr[centerIndex] == key) {
				return centerIndex;
			}
			else if (arr[centerIndex] < key) {
				firstIndex = centerIndex + 1;
			}
			else {
				lastIndex = centerIndex - 1;
			}
		}
		while (firstIndex <= lastIndex);
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 10, 20, 30, 40, 55, 60, 78, 99, 100, 1233, 15667 };
		
		System.out.println(search(arr, 60));
	}

}
